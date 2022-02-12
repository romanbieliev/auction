package com.rb.estore.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
