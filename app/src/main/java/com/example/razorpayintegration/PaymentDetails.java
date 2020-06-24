package com.example.razorpayintegration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentDetails {

    private String id;
    private String entity;
    private String amount;
    private String currency;
    private String status;
    private String method;
    private String order_id;
    private String description;
    private String amount_refunded;
    private String refund_status;
    private String email;
    private String contact;
    private String fee;
    private String tax;
    private String error_code;
    private String error_description;
    private String created_at;

    public PaymentDetails(String id, String entity, String amount, String currency, String status, String method, String order_id, String description, String amount_refunded, String refund_status, String email, String contact, String fee, String tax, String error_code, String error_description, String created_at) {
        this.id = id;
        this.entity = entity;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.method = method;
        this.order_id = order_id;
        this.description = description;
        this.amount_refunded = amount_refunded;
        this.refund_status = refund_status;
        this.email = email;
        this.contact = contact;
        this.fee = fee;
        this.tax = tax;
        this.error_code = error_code;
        this.error_description = error_description;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(String amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public String getRefund_status() {
        return refund_status;
    }

    public void setRefund_status(String refund_status) {
        this.refund_status = refund_status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_description() {
        return error_description;
    }

    public void setError_description(String error_description) {
        this.error_description = error_description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
