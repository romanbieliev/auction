package com.rb.auction.database.hibernate;

import com.rb.auction.database.InterfaceAuctionDao;
import com.rb.auction.model.Auction;
import com.rb.auction.model.AuctionBet;

import java.util.Optional;

public class AuctionDaoStub implements InterfaceAuctionDao {
    @Override
    public void add(Auction auction) {

    }

    @Override
    public Optional<Auction> getById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Auction> getByIdAndSortBet(int id) {
        return Optional.empty();
    }

    @Override
    public void update(Auction auction) {

    }

    @Override
    public int addBid(AuctionBet auctionBet) {
        return 0;
    }

    @Override
    public Optional<AuctionBet> getBidById(int id) {
        return Optional.empty();
    }
}
