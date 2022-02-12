package com.rb.estore.database;

import com.rb.estore.model.User;

import java.util.Optional;

public interface InterfaceUserDao {
    void addUser(User user);
    Optional<User> getUserById(int id);
    Optional<User> getUserByLogin(String login);
}
