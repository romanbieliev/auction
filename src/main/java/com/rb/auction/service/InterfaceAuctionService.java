package com.rb.auction.service;

import com.rb.auction.model.Auction;
import com.rb.auction.model.AuctionBet;
import com.rb.auction.model.Product;
import com.rb.auction.model.view.AuctionView;

import java.util.List;

public interface InterfaceAuctionService {
    void addAuction(AuctionView auctionView);
    Auction getAuctionById(int id);
    void addBetToAuction(int auctionId, AuctionBet auctionBet);
    void updateStatus(int id);
    List<Auction> getAll();
}
