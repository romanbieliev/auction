package com.rb.auction.service;

import com.rb.auction.database.InterfaceOrderDao;
import com.rb.auction.model.Order;
import com.rb.auction.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
public class OrderService implements InterfaceOrderService {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    InterfaceOrderDao interfaceOrderDao;

    @Override
    public void confirmOrder() {
        Order order = new Order(this.sessionObject.getUser(), new HashSet<>(this.sessionObject.getCart().getOrderItems()));
        this.interfaceOrderDao.addOrder(order);
    }

    @Override
    public Order getOrderById(int orderId) {
        Optional<Order> order = interfaceOrderDao.getOrderById(orderId);

        if (order.isEmpty()) {
            return null;
        }

        return order.get();
    }
}
