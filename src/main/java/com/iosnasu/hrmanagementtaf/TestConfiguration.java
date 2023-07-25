package com.iosnasu.hrmanagementtaf;

import com.iosnasu.hrmanagementtaf.properties.AppProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;
import java.time.Duration;

@Configuration
@EnableAutoConfiguration
public class TestConfiguration {
    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }

    @Bean
    public WebDriver webDriver() {
        WebDriver driver;
        URL resource = getClass().getResource("/drivers/chromedriver.exe");
        String path = resource.getPath();

        System.setProperty("webdriver.chrome.driver", path);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }
}
