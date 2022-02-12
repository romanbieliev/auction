package com.rb.auction.database;

import com.rb.auction.model.Auction;
import com.rb.auction.model.AuctionBet;

import java.util.Optional;

public interface InterfaceAuctionDao {
    void add(Auction auction);
    Optional<Auction> getById(int id);
    Optional<Auction> getByIdAndSortBet(int id);
    void update(Auction auction);
    int addBid(AuctionBet auctionBet);
    Optional<AuctionBet> getBidById(int id);
}
