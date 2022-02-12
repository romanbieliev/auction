package com.rb.estore.service;

import com.rb.estore.model.Auction;
import com.rb.estore.model.AuctionBet;
import com.rb.estore.model.Product;

import java.util.Set;

public interface InterfaceAuctionService {
    void addAuction(Product product);
    Auction getAuctionById(int id);
    Auction getAuctionByIdAndSortBet(int id);
    void addBetToAuction(int auctionId, AuctionBet auctionBet);
    void updateStatus(int id);
}
