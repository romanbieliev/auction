package com.rb.auction.service;

import com.rb.auction.model.Product;

import java.util.List;

public interface InterfaceProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    Product getProductById(int productId);
    void updateProduct(Product product);
    List<Product> getProductsByUserId(int id);
}
