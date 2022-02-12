package com.rb.auction.controller;

import com.rb.auction.model.Auction;
import com.rb.auction.model.AuctionBet;
import com.rb.auction.model.Product;
import com.rb.auction.model.User;
import com.rb.auction.service.InterfaceAuctionService;
import com.rb.auction.service.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
public class AuctionController {

    @Autowired
    InterfaceProductService interfaceProductService;

    @Autowired
    InterfaceAuctionService interfaceAuctionService;

    @RequestMapping(value = "/auction/addbet/{id}", method = RequestMethod.POST)
    public String addBid(@ModelAttribute AuctionBet auctionBet, @PathVariable int id) {
        this.interfaceAuctionService.addBetToAuction(id, auctionBet);

        return "redirect:/auction/{id}";
    }

    @RequestMapping(value = "auction/addauction", method = RequestMethod.POST)
    public String addAuction(@ModelAttribute Product product) {
        this.interfaceAuctionService.addAuction(product);

        return "redirect:/main";
    }

    @RequestMapping(value = "/auction/{id}", method = RequestMethod.GET)
    public String auctionShow(@PathVariable int id, Model model) {
        this.interfaceAuctionService.updateStatus(id);

        Auction auction = this.interfaceAuctionService.getAuctionById(id);
        Product product = auction.getProduct();
        Set<AuctionBet> auctionBets = auction.getAuctionBets();
        User user = auction.getUser();

        // this.interfaceAuctionService.sortByDate(auctionBets);

        model.addAttribute("rauction", auction);
        model.addAttribute("rproduct", product);
        model.addAttribute("rauctionbet", new AuctionBet());
        model.addAttribute("rauctionbets", auctionBets);
        model.addAttribute("ruser", user);

        return "auction-b";
    }
}
