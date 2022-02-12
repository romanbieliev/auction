package com.rb.auction.configuration;

import com.rb.auction.database.InterfaceAuctionDao;
import com.rb.auction.database.InterfaceOrderDao;
import com.rb.auction.database.InterfaceProductDao;
import com.rb.auction.database.InterfaceUserDao;
import com.rb.auction.database.hibernate.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.rb.auction.controller",
        "com.rb.auction.service",
        "com.rb.auction.session"
})
public class TestConfiguration {

    @Bean
    public InterfaceAuctionDao auctionDao() {
        return new AuctionDaoStub();
    }

    @Bean
    public InterfaceOrderDao orderDao() {
        return new OrderDaoStub();
    }

    @Bean
    public InterfaceProductDao productDao() {
        return new ProductDaoStub();
    }

    @Bean
    public InterfaceUserDao userDao() {
        return new UserDaoStub();
    }

}
