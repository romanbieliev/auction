package com.rb.estore.database.jdbc;

import com.rb.estore.database.InterfaceProductDao;
import com.rb.estore.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDao implements InterfaceProductDao {
    @Autowired
    Connection connection;

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM products";

            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setCode(resultSet.getString("code"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setPrice(resultSet.getDouble("price"));

                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Optional<Product> getProductById(int productId) {

        try {
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, productId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getDouble("price"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setCode(resultSet.getString("code"));

                return Optional.of(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setString(2, product.getTitle());
            preparedStatement.setString(3, product.getCode());
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getQuantity());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
