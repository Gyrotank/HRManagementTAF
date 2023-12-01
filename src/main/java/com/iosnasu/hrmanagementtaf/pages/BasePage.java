package com.iosnasu.hrmanagementtaf.pages;

import com.iosnasu.hrmanagementtaf.stepdefs.Hooks;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Lazy
public abstract class BasePage {
    protected static final Duration WAIT_IN_SECONDS = Duration.ofSeconds(10);

    protected final WebDriver webDriver;

    protected BasePage() {
        this.webDriver = Hooks.getWebDriver();
    }

    protected void open(final String baseUrl) {
        openURL(baseUrl);
    }

    private void openURL(final String url) {
        webDriver.get(url);
    }

    protected void waitForElement(final WebElement element) {
        try {
            waitForElementToBePresent(element);
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(webDriver, this);
            waitForElementToBePresent(element);
        }
    }

    private void waitForElementToBePresent(final WebElement element) {
        new WebDriverWait(webDriver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }
}
