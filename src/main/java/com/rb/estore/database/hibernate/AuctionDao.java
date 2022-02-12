package com.rb.estore.database.hibernate;

import com.rb.estore.database.InterfaceAuctionDao;
import com.rb.estore.model.Auction;
import com.rb.estore.model.AuctionBet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.Optional;

@Repository
public class AuctionDao implements InterfaceAuctionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void add(Auction auction) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(auction);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }


    @Override
    public Optional<Auction> getById(int id) {
        Session session = sessionFactory.openSession();

        Query<Auction> query = session.createQuery("FROM com.rb.estore.model.Auction WHERE id = :id");
        query.setParameter("id", id);

        try {
            Auction auction = query.getSingleResult();
            return Optional.of(auction);
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public Optional<Auction> getByIdAndSortBet(int id) {
        Session session = sessionFactory.openSession();

        Query<Auction> query = session.createQuery("FROM com.rb.estore.model.Auction AS Au" +
                " INNER JOIN FETCH Au.auctionBets AS Be" +
                " INNER JOIN FETCH Au.product AS Pr" +
                " WHERE Au.id = 3" +
                " ORDER BY Be.date ");

        try {
            Auction auction = query.getSingleResult();
            return Optional.of(auction);
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Auction auction) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.update(auction);
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
    public int addBid(AuctionBet auctionBet) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        int id = 0;

        try {
            transaction = session.beginTransaction();
            id = (int) session.save(auctionBet);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return id;
    }

    @Override
    public Optional<AuctionBet> getBidById(int id) {
        Session session = this.sessionFactory.openSession();

        Query<AuctionBet> query = session.createQuery("FROM com.rb.estore.model.AuctionBid WHERE id = :id");
        query.setParameter("id", id);

        try {
            AuctionBet auctionBet = query.getSingleResult();
            return Optional.of(auctionBet);
        } catch (NoResultException e) {
            e.printStackTrace();
            return Optional.empty();
        } finally {
            session.close();
        }
    }

}