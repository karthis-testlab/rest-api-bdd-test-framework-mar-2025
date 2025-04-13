Feature: Validate service now api incident table GET method using parameter

Scenario: Validate user able to fecth all records using GET method using query parameter
    Given set base uri of the service now api using the responsespecbuilder
    And set base path of the service now api using the responsespecbuilder
    And set basic authentication of the serivce now api using the responsespecbuilder
    And Set the header "Content-Type" key and "application/json" as value using the responsespecbuilder
    And set the query parameter "sysparm_query" key and "category=Hardware" value to filter response 
    And set the query parameter "sysparm_limit" key and "3" value to filter response
    And set the query parameter "sysparm_fields" key and "sys_id,number,category,short_description,description" value to filter response
    When user hit the get method of the incident table with the responsespecbuilder
    Then user should see the all records of the incident table using query parameter