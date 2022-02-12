package com.rb.auction.service;

import com.rb.auction.configuration.AppConfiguration;
import com.rb.auction.configuration.TestConfiguration;
import com.rb.auction.session.SessionObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {TestConfiguration.class})
public class AuthenticationServiceTest {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    SessionObject sessionObject;

    @Test
    public void AuthenticationTest() {
        String login = "admin";
        String password = "admin";

        this.authenticationService.login(login, password);

        Assert.assertTrue(this.sessionObject.isLogged());
    }
}
