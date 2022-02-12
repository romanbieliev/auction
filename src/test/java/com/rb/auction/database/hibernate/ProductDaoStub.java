package com.rb.auction.database.hibernate;

import com.rb.auction.database.InterfaceProductDao;
import com.rb.auction.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoStub implements InterfaceProductDao {
    @Override
    public List<Product> getProducts() {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return Optional.empty();
    }

    @Override
    public void updateProduct(Product product) {

    }
}
