Feature: DB Table Users can be accessed

  @db
  Scenario: User accesses DB Table Users
    Given DB connection is established
    When Count users number in DB
    Then Count result is 16
    And DB connection is closed