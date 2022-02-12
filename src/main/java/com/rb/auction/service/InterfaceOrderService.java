package com.rb.auction.service;

import com.rb.auction.model.Order;

public interface InterfaceOrderService {
    void confirmOrder();
    Order getOrderById(int orderId);
}
