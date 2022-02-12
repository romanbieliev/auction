package com.rb.estore.service;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements InterfaceProductService {
    @Autowired
    InterfaceProductDao interfaceProductDao;

    @Override
    public List<Product> getAllProducts() {
        return this.interfaceProductDao.getProducts();
    }

    @Override
    public void addProduct(Product product) {
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
}
