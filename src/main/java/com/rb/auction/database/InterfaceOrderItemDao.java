package com.rb.auction.database;

import com.rb.auction.model.OrderItem;

public interface InterfaceOrderItemDao {
    void addOrderItem(OrderItem orderItem, int orderId);
}
