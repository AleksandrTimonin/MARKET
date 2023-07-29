package com.geekbrains.spring.web.api.core;

public class OrderDetailsDto {
    private String address;
    private String addressLine2;
    private String adminArea1;
    private String adminArea2;
    private String postalCode;
    private String countryCode;
    private String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderDetailsDto() {
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAdminArea1() {
        return adminArea1;
    }

    public void setAdminArea1(String adminArea1) {
        this.adminArea1 = adminArea1;
    }

    public String getAdminArea2() {
        return adminArea2;
    }

    public void setAdminArea2(String adminArea2) {
        this.adminArea2 = adminArea2;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public OrderDetailsDto(String address, String addressLine2, String adminArea1, String adminArea2, String postalCode, String countryCode, String phone) {
        this.address = address;
        this.addressLine2 = addressLine2;
        this.adminArea1 = adminArea1;
        this.adminArea2 = adminArea2;
        this.postalCode = postalCode;
        this.countryCode = countryCode;
        this.phone = phone;
    }
}
