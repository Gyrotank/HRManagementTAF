package com.iosnasu.hrmanagementtaf.config;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfiguration.class)
public class CucumberSpringContextConfiguration {
}
