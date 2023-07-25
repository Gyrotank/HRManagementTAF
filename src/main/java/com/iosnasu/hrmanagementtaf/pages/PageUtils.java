package com.iosnasu.hrmanagementtaf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class PageUtils {
    private static final Duration WAIT_IN_SECONDS = Duration.ofSeconds(10);

    @Autowired
    private WebDriver driver;

    public void waitForElementToBePresent(final WebElement element) {
        new WebDriverWait(driver, WAIT_IN_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }
}
