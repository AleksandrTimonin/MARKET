package com.geekbrains.spring.web.api.exceptions;

public class OrderStatusException extends RuntimeException{
    public OrderStatusException(String message) {
        super(message);
    }
}
