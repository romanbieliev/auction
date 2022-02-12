package com.rb.estore.database.jdbc;

import com.rb.estore.database.InterfaceOrderItemDao;
import com.rb.estore.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class OrderItemDao implements InterfaceOrderItemDao {
    @Autowired
    Connection connection;

    @Override
    public void addOrderItem(OrderItem orderItem, int orderId) {
        String sql = "INSERT INTO order_items VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, orderId);
            preparedStatement.setInt(3, orderItem.getProduct().getId());
            preparedStatement.setInt(4, orderItem.getQuantity());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                orderItem.setId(resultSet.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
