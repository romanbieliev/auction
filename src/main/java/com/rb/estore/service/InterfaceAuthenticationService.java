package com.rb.estore.service;

import com.rb.estore.model.view.RegisterUser;

public interface InterfaceAuthenticationService {
    void register(RegisterUser registerUser);
    void login(String login, String password);
}
