#Auther: Lipika Mohanty
#Date:31-07-2021
Feature: To validate the login functionality

  @1st
  Scenario Outline: Check login functionality with valid username and valid password
    Given login page is opened
    When user enters valid <username> and valid <password>
    And user clicks on login button
    Then <username> is navigated to home page

    Examples: 
      | username | password |
      | Lipika   |    12345 |
      | Dipika   |    12345 |
      | Chinu    |    12345 |
      | Bibhu    |    12345 |
      | Mama     |    12345 |
      | Baba     |    12345 |

  @2nd
  Scenario Outline: Check login functionality with valid username and invalid password
    Given login page is opened
    When user enters valid <username> and valid <password>
    And user clicks on login button
    Then error message should be displayed

    Examples: 
      | username | password |
      | Lipika   |   123345 |
      | Dipika   |   123345 |
      | Chinu    |   123435 |
      | Bibhu    |   123345 |
      | Mama     |   123345 |
      | Baba     |   123345 |
