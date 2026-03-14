package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@xpath='//input[@id=\"username\"]']")
    private WebElement username;

    @FindBy(xpath = "//input[@xpath='//input[@id=\"password\"]']")
    private WebElement password;

    @FindBy(xpath = "//input[@xpath='//input[@id=\"Login\"]']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@xpath='//input[@id=\"rememberUn\"]']")
    private WebElement rememberMe;

    @FindBy(xpath = "//div[@xpath='//div[@id=\"error\"]']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(username));
            username.clear();
            username.sendKeys(user);
            password.clear();
            password.sendKeys(pass);
            loginButton.click();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void selectRememberMe() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(rememberMe));
            if (!rememberMe.isSelected()) {
                rememberMe.click();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getErrorText() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
