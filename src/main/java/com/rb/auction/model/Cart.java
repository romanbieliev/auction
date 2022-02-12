package com.rb.auction.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<OrderItem> orderItems = new ArrayList<>();

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getSum() {
        double sum = 0.0;

        for (OrderItem orderItem : orderItems) {
            sum += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }

        return Math.round(sum * 100) / 100.0;
    }

    public void clear() {
        this.orderItems = new ArrayList<>();
    }
}
