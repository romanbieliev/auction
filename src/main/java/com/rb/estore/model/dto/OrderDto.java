package com.rb.estore.model.dto;

import com.rb.estore.model.Order;
import com.rb.estore.model.OrderItem;
import com.rb.estore.model.User;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class OrderDto {
    private int id;
    private String user;
    private double price;
    private Order.Status status;
    private Set<OrderItem> orderItems = new HashSet<>();
    private LocalDateTime date;

    public OrderDto(int id, String user, double price, Order.Status status, Set<OrderItem> orderItems, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.status = status;
        this.orderItems = orderItems;
        this.date = date;
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.status = order.getStatus();
        this.orderItems = getOrderItems();
        this.date = order.getDate();

        this.user = "http://localhost:8081/rest/user/" + order.getUser().getId();
    }

    public OrderDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order.Status getStatus() {
        return status;
    }

    public void setStatus(Order.Status status) {
        this.status = status;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
