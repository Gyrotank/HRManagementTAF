package com.iosnasu.hrmanagementtaf.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePage {
    @Autowired
    protected WebDriver driver;

    @Autowired
    protected PageUtils pageUtils;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void open(final String baseUrl) {
        openURL(baseUrl);
    }

    public void openURL(final String url) {
        driver.get(url);
    }

    protected void waitForElementToBePresent(WebElement element) {
        try {
            pageUtils.waitForElementToBePresent(element);
        } catch (StaleElementReferenceException e) {
            PageFactory.initElements(driver, this);
            pageUtils.waitForElementToBePresent(element);
        }
    }
}
