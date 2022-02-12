package com.rb.estore.database.hibernate;

import com.rb.estore.database.InterfaceOrderDao;
import com.rb.estore.model.Order;
import com.rb.estore.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class OrderDao implements InterfaceOrderDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void addOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Order> getOrderById(int orderId) {

        Session session = sessionFactory.openSession();

        Query<Order> query = session.createQuery("FROM com.rb.estore.model.Order WHERE id = :id");
        query.setParameter("id", orderId);

        try {
            Order order = query.getSingleResult();
            return Optional.of(order);
        } catch(NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

}
