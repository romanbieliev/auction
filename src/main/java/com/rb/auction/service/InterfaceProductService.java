package com.rb.estore.service;

import com.rb.estore.model.Product;

import java.util.List;

public interface InterfaceProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);
    Product getProductById(int productId);
    void updateProduct(Product product);
}
