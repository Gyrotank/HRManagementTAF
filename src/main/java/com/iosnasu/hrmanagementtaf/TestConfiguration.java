package com.iosnasu.hrmanagementtaf;

import com.iosnasu.hrmanagementtaf.properties.AppProperties;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class TestConfiguration {
    @Bean
    public AppProperties appProperties() {
        return new AppProperties();
    }
}
