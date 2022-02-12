package com.rb.auction.database;

import com.rb.auction.model.Order;

import java.util.Optional;

public interface InterfaceOrderDao {
    void addOrder(Order order);
    Optional<Order> getOrderById(int orderId);
}
