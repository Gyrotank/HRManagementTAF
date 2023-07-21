Feature: Home Page can be accessed

  Scenario: User accesses Home Page via API
    When User sends GET request to home
    Then User receives status code of 200
