package com.rb.auction.controller;

import com.rb.auction.model.Cart;
import com.rb.auction.service.InterfaceCartService;
import com.rb.auction.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CartController {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    InterfaceCartService interfaceCartService;

    @RequestMapping(value = "/cart/add/{productId}", method = RequestMethod.GET)
    public String addProductToCart(@PathVariable Integer productId) {
        System.out.println(productId);
        this.interfaceCartService.addProductToCart(productId);

        return "redirect:/main";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cartShow(Model model) {
        Cart cart = this.sessionObject.getCart();

        System.out.println("-------------------------------------------------");
        System.out.println(cart.getOrderItems().toString());

        model.addAttribute("cart", cart);

        return "cart-b";
    }

    @RequestMapping(value="/cart/clear", method = RequestMethod.GET)
    public String cartClear() {
        this.sessionObject.getCart().clear();
        return "redirect:/cart";
    }
}
