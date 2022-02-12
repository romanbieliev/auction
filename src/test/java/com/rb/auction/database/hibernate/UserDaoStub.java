package com.rb.auction.database.hibernate;

import com.rb.auction.database.InterfaceUserDao;
import com.rb.auction.model.User;

import java.util.Optional;

public class UserDaoStub implements InterfaceUserDao {
    @Override
    public void addUser(User user) {

    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        User user = new User();
        user.setId(1);
        user.setLogin("admin");
        user.setPassword("21232f297a57a5a743894a0e4a801fc3");
        user.setName("admin");
        user.setSurname("admin");

        return Optional.of(user);
    }
}
