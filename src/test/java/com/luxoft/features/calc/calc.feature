@calculation
Feature: Caclulator
  Scenario: first calculation
    Given we set result equals 0
    When we add 1
    Then we have result equals 1

    Scenario: second cacl
      Given we set result equals 5
      And we subtract 2
      Then we not have result equals 3

  Scenario Outline: third calculation
    Given we set result equals 0
    When we add <addNumber>
    Then we have result equals <resultNumber>
  Examples:
    |addNumber|resultNumber|
    | 1       |2           |
    | 4       |3           |
    | 6       |5           |
    | 7       |6           |
    | 9       |8           |
