package com.rb.estore.session;

import com.rb.estore.model.Cart;
import com.rb.estore.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionObject {
    private User user = null;
    private final Cart cart = new Cart();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLogged() {
        return this.user != null;
    }

    public Cart getCart() {
        return cart;
    }


}
