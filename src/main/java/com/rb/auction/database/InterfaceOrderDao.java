package com.rb.estore.database;

import com.rb.estore.model.Order;

import java.util.Optional;

public interface InterfaceOrderDao {
    void addOrder(Order order);
    Optional<Order> getOrderById(int orderId);
}
