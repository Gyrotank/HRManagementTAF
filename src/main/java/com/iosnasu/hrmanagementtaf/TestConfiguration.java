package com.iosnasu.hrmanagementtaf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class TestConfiguration {
    @Bean
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
