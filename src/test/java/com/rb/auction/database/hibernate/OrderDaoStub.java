package com.rb.auction.database.hibernate;

import com.rb.auction.database.InterfaceOrderDao;
import com.rb.auction.model.Order;

import java.util.Optional;

public class OrderDaoStub implements InterfaceOrderDao {
    @Override
    public void addOrder(Order order) {

    }

    @Override
    public Optional<Order> getOrderById(int orderId) {
        return Optional.empty();
    }
}
