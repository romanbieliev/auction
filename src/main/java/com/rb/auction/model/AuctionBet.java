package com.rb.auction.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "auction_bets")
public class AuctionBet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private double price;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public AuctionBet(int id, LocalDateTime date, double price, User user) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.user = user;
    }

    @Override
    public String toString() {
        return "AuctionBid{" +
                "id=" + id +
                ", date=" + date +
                ", price=" + price +
                ", user=" + user +
                '}';
    }

    public AuctionBet() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
