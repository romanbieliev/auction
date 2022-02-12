package com.rb.auction.controller;


import com.rb.auction.service.InterfaceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    @Autowired
    InterfaceOrderService interfaceOrderService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String confirmOrder() {
        this.interfaceOrderService.confirmOrder();
        return "redirect:/main";
    }
}
