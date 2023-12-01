package com.iosnasu.hrmanagementtaf.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    @Getter
    public static WebDriver webDriver;

    @Before
    public void startTest(final Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            WebDriverManager.chromedriver().clearDriverCache().setup();
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
        }
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }

    @AfterStep
    public void addScreenshot(final Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }
}
