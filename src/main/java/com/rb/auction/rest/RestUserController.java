package com.rb.estore.rest;

import com.rb.estore.model.User;
import com.rb.estore.service.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest")
public class RestUserController {

    @Autowired
    InterfaceUserService interfaceUserService;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        User user = interfaceUserService.getUserById(id);

        return user;
    }
}
