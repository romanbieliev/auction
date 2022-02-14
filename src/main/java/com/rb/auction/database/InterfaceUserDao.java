package com.rb.auction.database;

import com.rb.auction.model.Product;
import com.rb.auction.model.User;

import java.util.Optional;
import java.util.Set;

public interface InterfaceUserDao {
    void addUser(User user);
    Optional<User> getUserById(int id);
    Optional<User> getUserByLogin(String login);
}
