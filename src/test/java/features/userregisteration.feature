Feature: user registeration
  I want to check that the user can register in our e-commerce website.
Scenario: user registeration
  Given user is in the homepage
  When I click on register link
  And I entered the user data
  Then registeration page displayed successfully
