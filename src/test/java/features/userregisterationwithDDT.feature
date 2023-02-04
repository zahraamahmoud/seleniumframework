Feature: user registeration
  I want to check that the user can register in our e-commerce website.
  Scenario Outline: user registeration
    Given user is in the homepage
    When I click on register link
    And I entered "<firstname>","<lastname>","<email>","<password>"
    Then registeration page displayed successfully
    Examples:
      |firstname|lastname|email|password|
      |nehal|ahmed     |nehal@gmail.com|12345677|
      |reham|mahmoud     |reham@gmail.com|12345677|
      |abdo|mahmoud     |abdallahahmed@gmail.com|12345677|

