package com.rb.estore.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems = new HashSet<>();
    private LocalDateTime date;

    public Order(int id, User user, double price, Status status, Set<OrderItem> orderItems, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.price = price;
        this.status = status;
        this.orderItems = orderItems;
        this.date = date;
    }

    public Order(User user, Set<OrderItem> orderItems) {
        this.user = user;
        this.status = Status.NEW;
        this.orderItems = orderItems;
        this.date = LocalDateTime.now();

        calculateOrderPrice();
    }

    public Order() {

    }

    private void calculateOrderPrice() {
        this.price = 0.0;

        for (OrderItem orderItem : this.orderItems) {
            this.price += orderItem.getProduct().getPrice() * orderItem.getQuantity();
        }

        this.price = Math.round(this.price * 100) / 100.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<OrderItem> getCartItems() {
        return orderItems;
    }

    public void setCartItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public enum Status {
        NEW,
        PAID,
        SENT,
        DELIVERED
    }
}
