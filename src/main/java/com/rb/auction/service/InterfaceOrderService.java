package com.rb.estore.service;

import com.rb.estore.model.Order;

public interface InterfaceOrderService {
    void confirmOrder();
    Order getOrderById(int orderId);
}
