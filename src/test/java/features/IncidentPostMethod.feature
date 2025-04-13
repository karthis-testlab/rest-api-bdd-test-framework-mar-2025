Feature: Validate service now api incident table POST method

Scenario Outline: Validate user able to create new record using POST method
    Given set base uri of the service now api
    And set base path of the service now api
    And set basic authentication of the serivce now api
    When Set the header "Content-Type" key and "application/json" as value
    And create the incident record with description "<description>" in the request body
    And create the incident record with short description "<short_description>" in the request body
    And hit the post http method with request body as the pojo object
    Then validate the status code and status line

    Examples: 
      | description   | short_description                            |
      | APISessionJAN | Adding new record using POST POJO Object JAN |
      | APISessionFEB | Adding new record using POST POJO Object FEB |
      | APISessionMAR | Adding new record using POST POJO Object MAR |
      | APISessionAPR | Adding new record using POST POJO Object APR |