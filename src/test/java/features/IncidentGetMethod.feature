Feature: Validate service now api incident table GET method

  Scenario: Validate user able to fecth all records using GET method
    Given set base uri of the service now api using the static variable
    And set base path of the service now api using the static variable
    And set basic authentication of the serivce now api using the static variable
    When user hit the get method of the incident table
    Then user should see the all records of the incident table