package com.iosnasu.hrmanagementtaf.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class BasePage {
    protected static final Duration WAIT_IN_SECONDS = Duration.ofSeconds(10);

    protected final WebDriver webDriver;

    BasePage() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @PostConstruct
    public void init() {
        PageFactory.initElements(webDriver, this);
    }

    public void open(final String baseUrl) {
        openURL(baseUrl);
    }

    public void openURL(final String url) {
        webDriver.get(url);
    }

    private void waitForElementToBePresent(final WebElement element) {
        new WebDriverWait(webDriver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForElement(final WebElement element) {
        try {
            waitForElementToBePresent(element);
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(webDriver, this);
            waitForElementToBePresent(element);
        }
    }
}
