Feature: rest feature

  Scenario: verify get method status
    Given create request to "https://jsonplaceholder.typicode.com/"
    When I send request to "posts" with parameter "3"
    Then status code is 200

  Scenario: verify response text
    Given create request to "https://jsonplaceholder.typicode.com/"
    When I send request to "posts" with parameter "3"
    Then response contains "qui ipsa sit aut"

  Scenario: verify response value
    Given create request to "https://jsonplaceholder.typicode.com/"
    When I send request to "posts" with parameter "3"
    Then response contains data
      | userId | 1                                                           |
      | id     | 3                                                           |
      | title  | ea molestias quasi exercitationem repellat qui ipsa sit aut |
