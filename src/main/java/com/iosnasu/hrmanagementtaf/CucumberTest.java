package com.iosnasu.hrmanagementtaf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.iosnasu.hrmanagementtaf", "com.iosnasu.hrmanagementtaf.stepdefs"},
        plugin = {"pretty", "html:target/cucumber-report.html", "json:target/cucumber-report.json"}
)
public class CucumberTest {
}
