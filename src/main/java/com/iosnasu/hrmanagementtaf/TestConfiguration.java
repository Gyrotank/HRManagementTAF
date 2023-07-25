package com.iosnasu.hrmanagementtaf;

import com.iosnasu.hrmanagementtaf.pages.HomePage;
import com.iosnasu.hrmanagementtaf.properties.AppProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
@EnableAutoConfiguration
public class TestConfiguration {
    @Bean
    public AppProperties getAppProperties() {
        return new AppProperties();
    }

    @Bean
    @Lazy
    public HomePage getHomePage() {
        return new HomePage();
    }
}
