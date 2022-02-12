package com.rb.estore.database;

import com.rb.estore.model.OrderItem;

public interface InterfaceOrderItemDao {
    void addOrderItem(OrderItem orderItem, int orderId);
}
