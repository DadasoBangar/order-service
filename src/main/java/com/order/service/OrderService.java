package com.order.service;

import org.springframework.stereotype.Service;

import com.order.common.TransactionRequest;
import com.order.common.TransactionResponse;

@Service
public interface OrderService {
    TransactionResponse bookMyOrder(TransactionRequest transactionRequest);
}
