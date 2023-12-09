package com.order.common;

import com.order.dto.OrderDto;
import lombok.*;


@Data
@Getter
@Setter
public class TransactionResponse {
    private OrderDto orderDto;
    private String transactionId;
    private double amount;

    private String responseMessage;

    public TransactionResponse(OrderDto orderDto, String transactionId, double amount, String responseMessage) {
        this.orderDto = orderDto;
        this.transactionId = transactionId;
        this.amount = amount;
        this.responseMessage = responseMessage;
    }

    public TransactionResponse() {
    }

    public OrderDto getOrderDto() {
        return orderDto;
    }

    public void setOrderDto(OrderDto orderDto) {
        this.orderDto = orderDto;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
