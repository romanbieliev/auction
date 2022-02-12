package com.rb.estore.controller;

import com.rb.estore.database.InterfaceUserDao;
import com.rb.estore.model.User;
import com.rb.estore.service.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {
    @Autowired
    InterfaceUserDao interfaceUserDAO;

    @Autowired
    InterfaceProductService interfaceProductService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "redirect:/main";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String mainShow(Model model) {
        model.addAttribute("rproducts", this.interfaceProductService.getAllProducts());

        return "main-b";
    }


}
