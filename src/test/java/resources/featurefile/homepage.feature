Feature: B&CE Web Test Cases
  As user I want to check the home page and login page

  @smoke
  Scenario: Verify User can see the logo present on home page
    Given  I try to launch the homepage
    And    I click on accept cookies
    Then   I should be able to see the B&CE logo is present

  @smoke
  Scenario: Verify User can see the alert text displayed
    Given  I try to launch the homepage
    And    I click on accept cookies
    Then   I should see the alert text displayed

  @regression
  Scenario: Verify User can see the list of vacancies
    Given  I try to launch the homepage
    And    I click on accept cookies
    And    I mouse hover on careers tab
    And    I click on current vacancies
    Then   I should be able to see number of vacancies

  @sanity
  Scenario: Verify User can see total products available from dropdown
    Given  I try to launch the homepage
    And    I click on accept cookies
    And    I click on product dropdown
    And    I print the list of products available

  @sanity
  Scenario: Verify User can see the error message with invalid credentials
    Given  I try to launch the homepage
    And    I click on accept cookies
    And    I perform login operations
    Then   I should see an error message

  @regression
  Scenario: Verify the total number of links and print all the links from home page
    Given I try to launch the homepage
    And   I click on accept cookies
    Then  I should be able to verify number of links present
    And   I should be able to print out all the links
