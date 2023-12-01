Feature: Home Page can be accessed

#  Run configuration VM options to filter by tags:
#  -Dcucumber.filter.tags="@api"
#  -Dcucumber.filter.tags="@ui"
#  -Dcucumber.filter.tags="@api and @ui"
#  -Dcucumber.filter.tags="@api or @ui"

  @api
  Scenario: User accesses Home Page via API
    When User sends GET request to home
    Then User receives status code of 200

  @ui
  Scenario: User opens Home Page in browser
    When User opens home page
    Then User sees main title
