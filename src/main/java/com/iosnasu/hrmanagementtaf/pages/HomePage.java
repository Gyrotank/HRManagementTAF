package com.iosnasu.hrmanagementtaf.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {
    private static final String SUFFIX = "home";

    public void waitForPageToLoad() {
        WebElement title = webDriver.findElement(By.xpath("//div[contains(@class, 'text-center')]"));
        waitForElement(title);
    }

    @Override
    public void open(final String baseUrl) {
        openURL(baseUrl + SUFFIX);
    }
}
