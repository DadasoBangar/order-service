package com.order.controller;

import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/order")
    public TransactionResponse bookMyOrder(@RequestBody TransactionRequest transactionRequest)
    {
        return orderService.bookMyOrder(transactionRequest);
    }
}
