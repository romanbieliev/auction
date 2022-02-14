package com.rb.auction.service;

import com.rb.auction.database.InterfaceProductDao;
import com.rb.auction.model.Product;
import com.rb.auction.model.User;
import com.rb.auction.session.SessionObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements InterfaceProductService {
    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Autowired
    SessionObject sessionObject;

    @Override
    public List<Product> getAllProducts() {
        return this.interfaceProductDao.getProducts();
    }

    @Override
    public void addProduct(Product product) {
        User user = sessionObject.getUser();
        product.setUser(user);

        this.interfaceProductDao.addProduct(product);
    }

    @Override
    public Product getProductById(int productId) {
        Optional<Product> productOptional = interfaceProductDao.getProductById(productId);

        if (productOptional.isEmpty()) {
            return null;
        }

        return productOptional.get();
    }

    @Override
    public void updateProduct(Product product) {
        interfaceProductDao.updateProduct(product);
    }

    @Override
    public List<Product> getProductsByUserId(int id) {
        return this.interfaceProductDao.getByUserId(id);
    }
}
