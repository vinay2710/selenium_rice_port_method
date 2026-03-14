package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends BaseTest {
    @Test
    public void testInvalidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("invalid_user@salesforce.com", "WrongPass!");
            String error = loginPage.getErrorText();
            Assert.assertTrue(error.contains("check your username and password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
