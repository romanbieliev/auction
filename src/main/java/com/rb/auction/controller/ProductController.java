package com.rb.auction.controller;

import com.rb.auction.model.AuctionBet;
import com.rb.auction.model.Product;
import com.rb.auction.service.InterfaceAuctionService;
import com.rb.auction.service.ProductService;
import com.rb.auction.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    InterfaceAuctionService interfaceAuctionService;

    @Autowired
    SessionObject sessionObject;

    @RequestMapping(value = "/addproduct", method = RequestMethod.GET)
    public String productAddShow(Model model) {
        model.addAttribute("rproduct", new Product());

        if (this.sessionObject.isLogged()) {
            return "addproduct-b";
        }

        return "redirect:/main";
    }

    @RequestMapping(value = "/addproduct", method = RequestMethod.POST)
    public String productAdd(@ModelAttribute Product product) {
        productService.addProduct(product);

        return "redirect:/main";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String productShow(@PathVariable int id, Model model) {

        Product product = productService.getProductById(id);

        model.addAttribute("rproduct", product);
        model.addAttribute("rauctionbid", new AuctionBet());

        return "product-b";
    }
}
