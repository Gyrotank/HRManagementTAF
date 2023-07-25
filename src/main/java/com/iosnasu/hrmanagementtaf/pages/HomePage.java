package com.iosnasu.hrmanagementtaf.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {
    private static final String SUFFIX = "home";

    @FindBy(xpath = "//div[contains(@class, 'text-center')]")
    private WebElement title;

    public void waitForPageToLoad() {
        waitForElement(title);
    }

    @Override
    public void open(final String baseUrl) {
        openURL(baseUrl + SUFFIX);
    }
}
