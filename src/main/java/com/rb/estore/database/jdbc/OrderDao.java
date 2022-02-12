package com.rb.estore.database.jdbc;

import com.rb.estore.database.InterfaceOrderItemDao;
import com.rb.estore.database.InterfaceOrderDao;
import com.rb.estore.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.Optional;

public class OrderDao implements InterfaceOrderDao {

    @Autowired
    Connection connection;

    @Autowired
    InterfaceOrderItemDao interfaceOrderItemDao;


    @Override
    public void addOrder(Order order) {
        String sql = "INSERT INTO orders VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setNull(1, Types.INTEGER);
            preparedStatement.setInt(2, order.getUser().getId());
            preparedStatement.setDouble(3, order.getPrice());
            preparedStatement.setString(4, order.getStatus().toString());
            preparedStatement.setTimestamp(5, Timestamp.valueOf(order.getDate()));

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            if (resultSet.next()) {
                order.setId(resultSet.getInt(1));
            }

            /*
            for (CartItem cartItem : order.getCartItems()) {
                this.interfaceCartItemDao.addOrderItem(cartItem, order.getId());
            }
            */

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Order> getOrderById(int orderId) {
        return Optional.empty();
    }
}
