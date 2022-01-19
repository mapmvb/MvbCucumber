@web
Feature: web feature

  Scenario: login test
    Given I enter "tomsmith" to the field "username"
    And I enter "SuperSecretPassword!" to the field "password"
    When I press button "login"
#    Then I see button "logout"
    Then Button "logout" is displayed

  Scenario: negative test
    Given I enter "tomsmith" to the field "username"
    And I enter "SuperSecretPassword!" to the field "password"
    When I press button "login"
    Then Button "logout" is not displayed

  Scenario: negative test 1
    Given I enter "tomsmith" to the field "username"
    And I enter "SuperSecret!" to the field "password"
    When I press button "login"
    Then Button "logout" is not displayed
