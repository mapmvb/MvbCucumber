@search
Feature: search in several search systems

  Scenario Outline: find in Yandex with press enter
    Given open <browserName> page
    When I type "<query>" in search field
    And I press enter
    Then I can see title contains "<query>"
    Examples:
    |browserName| query|
    |Yandex     |search|
    |Google     |search|
    |Mail       |search|
    |Yahoo      |search|

  Scenario Outline: find in Yandex with press search button
    Given open <browserName> page
    When I type "<query>" in search field
    And I press search button
    Then I can see title contains "<query>"
    Examples:
      |browserName| query|
      |Yandex     |search|
      |Google     |search|
#      |Mail       |search|
      |Yahoo      |search|

