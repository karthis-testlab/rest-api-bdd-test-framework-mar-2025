Feature: Validate service now api incident table POST method

  Background: 
    Given set base uri of the service now api
    And set base path of the service now api
    And set basic authentication of the serivce now api

  Scenario Outline: Validate user able to create new record using POST method
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

  Scenario: Validate user able to create new record using POST method request body as string
    When user set the headers of the the service now api
      | Key          | Value            |
      | Content-Type | application/json |
      | Accept       | application/json |
    And hit the post http method with request body as the string object
    Then validate the status code and status line
      | StatusCode |     201 |
      | StatusLine | Created |

  Scenario Outline: Validate user able to create new record using POST method
    When Set the header "Content-Type" key and "application/json" as value
    And Set the Accpet header "Accept" key and "<accept_value>" as value
    And create the incident record with description "<description>" in the request body
    And create the incident record with short description "<short_description>" in the request body
    And hit the post http method with request body as the pojo object
    Then validate the status code and status line

    Examples: 
      | description   | short_description                            | accept_value     |
      | APISessionJAN | Adding new record using POST POJO Object JAN | application/json |
      | APISessionFEB | Adding new record using POST POJO Object FEB | application/json |
      | APISessionMAR | Adding new record using POST POJO Object MAR | application/xml  |
      | APISessionAPR | Adding new record using POST POJO Object APR | application/xml  |
