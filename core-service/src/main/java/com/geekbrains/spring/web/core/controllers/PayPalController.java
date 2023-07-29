package com.geekbrains.spring.web.core.controllers;

import com.geekbrains.spring.web.api.exceptions.AppError;
import com.geekbrains.spring.web.core.services.OrderService;
import com.geekbrains.spring.web.core.services.PayPalService;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCaptureRequest;
import com.paypal.orders.OrdersCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Optional;
@Slf4j
@Controller
@RequestMapping("/api/v1/paypal")
@RequiredArgsConstructor
public class PayPalController {
    private final PayPalHttpClient payPalClient;
    private final OrderService orderService;
    private final PayPalService payPalService;

    @PostMapping("/create/{orderId}")
    public ResponseEntity<?> createOrder(@PathVariable Long orderId) throws IOException {
        log.debug("controller: create/order");
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.prefer("return=representation");
        request.requestBody(payPalService.createOrderRequest(orderId));

        try {
            HttpResponse<Order> response = payPalClient.execute(request);
            return new ResponseEntity<>(response.result().id(), HttpStatus.valueOf(response.statusCode()));
        }catch (Exception e){
            log.error(e.getMessage(),e);
            orderService.changeStatus(orderId,"CANCELLED");
            return new ResponseEntity<>(new AppError("PAYPAL_ERROR", e.getMessage()),HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/capture/{payPalId}")
    public ResponseEntity<?> captureOrder(@PathVariable String payPalId) throws IOException {
        log.debug("controller: capture/order");
        OrdersCaptureRequest request = new OrdersCaptureRequest(payPalId);
        request.requestBody(new OrderRequest());

        HttpResponse<Order> response = payPalClient.execute(request);
        Order payPalOrder = response.result();
        long orderId = Long.parseLong(payPalOrder.purchaseUnits().get(0).referenceId());
        if ("COMPLETED".equals(payPalOrder.status())) {

            orderService.changeStatus(orderId,"COMPLETED");



            return new ResponseEntity<>("Order completed!", HttpStatus.valueOf(response.statusCode()));
        }

        orderService.changeStatus(orderId,"CANCELLED");
        return new ResponseEntity<>(payPalOrder, HttpStatus.valueOf(response.statusCode()));
    }
}
