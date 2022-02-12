package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.OrderItem;
import com.rb.estore.model.Product;
import com.rb.estore.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService implements InterfaceCartService {

    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Autowired
    SessionObject sessionObject;

    @Override
    public void addProductToCart(int productId) {
        Optional<Product> productOptional = this.interfaceProductDao.getProductById(productId);

        if (productOptional.isEmpty()) {
            return;
        }

        if (productOptional.get().getQuantity() < 0) {
            return;
        }

        // System.out.println(productOptional.get().getTitle());

        for (OrderItem orderItem : this.sessionObject.getCart().getOrderItems()) {
            if (orderItem.getProduct().getId() == productId) {
                orderItem.incrementQuantity();
                return;
            }
        }

        OrderItem orderItem = new OrderItem(0, productOptional.get(), 1);
        this.sessionObject.getCart().getOrderItems().add(orderItem);

    }
}
