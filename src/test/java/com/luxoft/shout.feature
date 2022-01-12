Feature: Shout feature
  here can be link to Jira
  or just feature description
  it can be multi-row description

  Background: background
    Given show how background works

  Scenario: Listener is within range
  scenario description
    Given Alice is in 14 m from Sean
    When Sean shouts 'Free bagels'
    Then Lucy hears Sean message


  Scenario: Listener is out of range
    Given Lucy is in 20 m from Sean
    But Lucy is hungry
    When Sean shouts 'Free bagels'
    Then Lucy hears Sean message

  Scenario: Listener is out of range 1
    Given Kate is in 20 m from Sean
    When Sean shouts 'Free bagels'
    Then Lucy not hear Sean message

  Scenario: Listener is within range 2
    Given Lucy is in 20 m from Sean
    Given Lucy is hungry
    Given Sean shouts 'Free bagels'
    Given Lucy hears Sean message

  Scenario: Listener is within range 3
    Given Lucy is in 20 m from Sean
# it is a comment
    And Lucy is hungry
    When Sean shouts 'Free bagels'
    Then Lucy hears Sean message

  Scenario: Bullet time
    * Lucy is in 10 m from Sean
    * Sean shouts 'Bullet tim1'
    * Lucy hears Sean message
    And Lucy goes to cafe

  Scenario Outline: Outline example
    Given Lucy is in <dist> m from Sean
    When Sean shouts '<message>'
    Then Lucy hears Sean message
    Examples:
      | dist | message     |
      | 14   | Free bagels |
      | 10   | Free bagels |
      | 12   | outliine    |
