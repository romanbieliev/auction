package com.rb.auction.service;



import com.rb.auction.database.InterfaceUserDao;
import com.rb.auction.model.User;
import com.rb.auction.model.view.RegisterUser;
import com.rb.auction.session.SessionObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Optional;

@Service
public class AuthenticationService implements InterfaceAuthenticationService {
    @Autowired
    InterfaceUserDao interfaceUserDao;

    @Autowired
    SessionObject sessionObject;

    @Override
    public void register(RegisterUser registerUser) {
        registerUser.setPassword(DigestUtils.md5Hex(registerUser.getPassword()));

        // User u = registerUser.clone();
        User u = registerUser.parentClone();

        System.out.println("------------------------------");
        System.out.println(u.getClass().getTypeName());

        interfaceUserDao.addUser(u);
    }

    @Override
    public void login(String login, String password) {
        Optional<User> userOptional = this.interfaceUserDao.getUserByLogin(login);

        if (userOptional.isEmpty()) {
            return;
        } else if (! userOptional.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            return;
        }

        this.sessionObject.setUser(userOptional.get());
    }
}
