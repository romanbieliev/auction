package com.rb.auction.model;

import com.rb.auction.sorter.SortByDate;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(fetch = FetchType.EAGER)
    private Product product;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @SortComparator(SortByDate.class)
    private Set<AuctionBet> auctionBets = new HashSet<>();

    public Auction(int id, LocalDateTime startDate, LocalDateTime endDate, Status status, Product product, User user, Set<AuctionBet> auctionBets) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.product = product;
        this.user = user;
        this.auctionBets = auctionBets;
    }

    public Auction() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Set<AuctionBet> getAuctionBets() {
        return auctionBets;
    }

    public void setAuctionBets(Set<AuctionBet> auctionBets) {
        this.auctionBets = auctionBets;
    }

    public void setAuctionBet(AuctionBet auctionBet) {
        this.auctionBets.add(auctionBet);
    }

    public enum Status {
        OPEN,
        CLOSE
    }

}
