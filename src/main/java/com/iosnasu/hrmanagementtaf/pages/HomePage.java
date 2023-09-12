package com.iosnasu.hrmanagementtaf.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class HomePage extends BasePage {
    private static final String SUFFIX = "home";

    @FindBy(xpath = "//div[contains(@class, 'text-center')]")
    WebElement title;

    public HomePage(final WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void waitForPageToLoad() {
        waitForElement(title);
    }

    @Override
    public void open(final String baseUrl) {
        super.open(baseUrl + SUFFIX);
    }
}
