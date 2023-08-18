package com.iosnasu.hrmanagementtaf.stepdefs.db;

import com.iosnasu.hrmanagementtaf.properties.AppProperties;
import com.iosnasu.hrmanagementtaf.utils.DbConnection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
@SpringBootTest
public class DbStepDefs {
    @Autowired
    private AppProperties appProperties;

    @Autowired
    private DbConnection dbConnection;

    private int countResult;

    @Given("DB connection is established")
    public void dbConnectionEstablished() {
        dbConnection.initDbConnection(appProperties.getDbDriverName(),
                appProperties.getDbUrl(),
                appProperties.getDbUser(),
                appProperties.getDbPassword());
    }

    @When("Count users number in DB")
    public void selectAllUsers() {
        try (Statement statement = dbConnection.getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM Users");
            rs.next();
            countResult = rs.getInt(1);
        } catch (SQLException e) {
            log.error("!!! Error executing query: SELECT * FROM Users !!!");
        }
    }

    @Then("Count result is {int}")
    public void countResultIs(final int expectedResult) {
        Assertions.assertThat(countResult).isEqualTo(expectedResult);
    }

    @And("DB connection is closed")
    public void dbConnectionClosed() {
        dbConnection.closeDbConnection();
    }
}
