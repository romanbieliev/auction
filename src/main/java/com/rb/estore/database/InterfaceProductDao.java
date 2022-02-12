package com.rb.estore.database;

import com.rb.estore.model.Product;

import java.util.List;
import java.util.Optional;

public interface InterfaceProductDao {
    List<Product> getProducts();
    void addProduct(Product product);
    Optional<Product> getProductById(int productId);
    void updateProduct(Product product);
}
