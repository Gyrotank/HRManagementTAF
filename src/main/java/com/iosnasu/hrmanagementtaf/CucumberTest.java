package com.iosnasu.hrmanagementtaf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.iosnasu.hrmanagementtaf.config", "com.iosnasu.hrmanagementtaf.stepdefs"}
)
public class CucumberTest {
}
