package com.iosnasu.hrmanagementtaf;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = TestConfiguration.class)
public class CucumberSpringContextConfiguration {
}
