package com.rb.auction.database.hibernate;

import com.rb.auction.database.InterfaceProductDao;
import com.rb.auction.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ProductDao implements InterfaceProductDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts() {
        Session session = sessionFactory.openSession();

        Query<Product> query = session.createQuery("FROM com.rb.auction.model.Product");

        try {
            List<Product> books = query.getResultList();
            return books;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> getByUserId(int id) {
        Session session = this.sessionFactory.openSession();

        Query<Product> query = session.createQuery("FROM com.rb.auction.model.Product WHERE user.id = :id");
        query.setParameter("id", id);

        try {
            List<Product> products = query.getResultList();
            return products;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void addProduct(Product product) {
        Session session = sessionFactory.openSession();

        Transaction transaction = null;
        transaction = session.beginTransaction();

        try {
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        Session session = sessionFactory.openSession();

        Query<Product> query = session.createQuery("FROM com.rb.auction.model.Product WHERE id = :id");
        query.setParameter("id", productId);

        try {
            Product product = query.getSingleResult();
            return Optional.of(product);
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateProduct(Product product) {
        Transaction transaction = null;

        try {
            Session session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }
}
