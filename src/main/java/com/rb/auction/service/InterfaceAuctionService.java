package com.rb.auction.service;

import com.rb.auction.model.Auction;
import com.rb.auction.model.AuctionBet;
import com.rb.auction.model.Product;

public interface InterfaceAuctionService {
    void addAuction(Product product);
    Auction getAuctionById(int id);
    Auction getAuctionByIdAndSortBet(int id);
    void addBetToAuction(int auctionId, AuctionBet auctionBet);
    void updateStatus(int id);
}
