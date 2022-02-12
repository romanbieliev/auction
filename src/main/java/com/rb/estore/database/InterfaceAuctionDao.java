package com.rb.estore.database;

import com.rb.estore.model.Auction;
import com.rb.estore.model.AuctionBet;

import java.util.Optional;

public interface InterfaceAuctionDao {
    void add(Auction auction);
    Optional<Auction> getById(int id);
    Optional<Auction> getByIdAndSortBet(int id);
    void update(Auction auction);
    int addBid(AuctionBet auctionBet);
    Optional<AuctionBet> getBidById(int id);
}
