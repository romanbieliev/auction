package com.rb.estore.service;

import com.rb.estore.database.InterfaceAuctionDao;
import com.rb.estore.model.Auction;
import com.rb.estore.model.AuctionBet;
import com.rb.estore.model.Product;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
public class AuctionService implements InterfaceAuctionService {

    @Autowired
    InterfaceProductService interfaceProductService;

    @Autowired
    InterfaceAuctionDao interfaceAuctionDao;

    @Autowired
    SessionObject sessionObject;

    @Override
    public void addAuction(Product product) {

        Product productDb = interfaceProductService.getProductById(product.getId());
        productDb.setPrice(product.getPrice());
        interfaceProductService.updateProduct(productDb);

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime todayPlusDays = today.plusDays(10);

        Auction auction = new Auction();
        auction.setStartDate(LocalDateTime.now());
        auction.setEndDate(todayPlusDays);
        auction.setProduct(product);
        auction.setStatus(Auction.Status.OPEN);

        interfaceAuctionDao.add(auction);
    }

    @Override
    public Auction getAuctionById(int id) {
        Optional<Auction> auctionOptional = interfaceAuctionDao.getById(id);

        if (auctionOptional.isEmpty()) {
            return null;
        }

        return auctionOptional.get();
    }

    @Override
    public Auction getAuctionByIdAndSortBet(int id) {
        Optional<Auction> auctionOptional = interfaceAuctionDao.getByIdAndSortBet(id);

        if (auctionOptional.isEmpty()) {
            return null;
        }

        return auctionOptional.get();
    }

    @Override
    public void addBetToAuction(int auctionId, AuctionBet auctionBet) {
        Optional<Auction> auctionOptional = interfaceAuctionDao.getById(auctionId);

        if (auctionOptional.isEmpty()) {
            return;
        }

        Auction auction = auctionOptional.get();
        if (auction.getStatus().equals(Auction.Status.CLOSE)) {
            return;
        }

        double maxBetPrice = auction.getProduct().getPrice();
        Set<AuctionBet> auctionBets = auction.getAuctionBets();

        for (AuctionBet auctionBetItem : auctionBets) {
            if (auctionBetItem.getPrice() > maxBetPrice) {
                maxBetPrice = auctionBetItem.getPrice();
            }
        }

        if (maxBetPrice > auctionBet.getPrice()) {
            return;
        }

        auctionBet.setUser(this.sessionObject.getUser());
        auctionBet.setDate(LocalDateTime.now());
        auctionBet.setId(0);
        auction.setAuctionBet(auctionBet);

        interfaceAuctionDao.update(auction);
    }

    @Override
    public void updateStatus(int id) {
        Optional<Auction> auctionOptions = interfaceAuctionDao.getById(id);

        if (auctionOptions.isEmpty()) {
            return;
        }

        Auction auction = auctionOptions.get();
        if (auction.getStatus().equals(Auction.Status.CLOSE)) {
            return;
        }

        LocalDateTime currentDate = LocalDateTime.now();
        if (currentDate.isAfter(auction.getEndDate())) {
            auction.setStatus(Auction.Status.CLOSE);
            this.interfaceAuctionDao.update(auction);
        }
    }


}
