package com.iosnasu.hrmanagementtaf;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
)
public class CucumberTest {
    @BeforeClass
    public static void setUp() {
        System.setProperty("baseUrl", "http://localhost:8080/");
    }

    private CucumberTest() {}
}
