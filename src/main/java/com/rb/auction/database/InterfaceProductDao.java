package com.rb.auction.database;

import com.rb.auction.model.Product;

import java.util.List;
import java.util.Optional;

public interface InterfaceProductDao {
    List<Product> getProducts();
    void addProduct(Product product);
    Optional<Product> getProductById(int productId);
    void updateProduct(Product product);
}
