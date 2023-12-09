package com.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.order.common.PaymentDto;
import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.dto.OrderDto;
import com.order.entity.OrderEntity;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

@Autowired
private RestTemplate restTemplate;
    @Override
    public TransactionResponse bookMyOrder(TransactionRequest transactionRequest) {
        String response="";
        OrderDto orderDto=transactionRequest.getOrderDto();
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setOrderId(orderDto.getOrderId());
        orderEntity.setOrderName(orderDto.getOrderName());
        orderEntity.setOrderPrice(orderDto.getOrderPrice());
        orderEntity.setOrderQuantity(orderDto.getOrderQuantity());

        PaymentDto paymentDto=transactionRequest.getPaymentDto();
        paymentDto.setOrderId(orderDto.getOrderId());
        paymentDto.setPaymentId(orderDto.getOrderId());
        paymentDto.setAmount(orderDto.getOrderPrice());
        paymentDto.setPaymentStatus(paymentDto.getPaymentStatus());
        PaymentDto paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/makePayment",paymentDto,PaymentDto.class);
        if(paymentResponse.getPaymentStatus().equalsIgnoreCase("Success"))
        {
             response="order is successfully placed!";
        }
        else {
            response="order has not placed because In-sufficient amount";
        }
        orderRepository.save(orderEntity);
        return new TransactionResponse(orderDto,paymentResponse.getTransactionId(),paymentResponse.getAmount(),response);
    }
}
