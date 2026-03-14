package com.salesforce.tests;

import com.salesforce.pages.LoginPage;
import org.testng.annotations.Test;

public class ValidLoginTest extends BaseTest {
    @Test
    public void testValidLogin() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("production_user@salesforce.com", "SecurePass123!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
