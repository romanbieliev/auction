package com.rb.estore.rest;

import com.rb.estore.model.Product;
import com.rb.estore.service.InterfaceProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RestProductController {

    @Autowired
    InterfaceProductService interfaceProductService;

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id) {
        Product product = interfaceProductService.getProductById(id);
        return product;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return interfaceProductService.getAllProducts();
    }

    @RequestMapping(value = "/product/addproduct", method = RequestMethod.POST)
    public void addProduct(@RequestBody Product product) {
        interfaceProductService.addProduct(product);
    }
}
