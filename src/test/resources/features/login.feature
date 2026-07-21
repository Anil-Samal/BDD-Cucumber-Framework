Feature: OrangeHRM Login

  Scenario: Successful Login using Excel
    Given User launches the OrangeHRM application
    When User logs in with test data "TC001"
    Then User should navigate to Dashboard


  Scenario: For Invalid username Login Test
    Given User launches the OrangeHRM application
    When User logs in with test data "TC001"
    Then User should navigate to Dashboard


  Scenario: For invalid password Login Test
    Given User launches the OrangeHRM application
    When User logs in with test data "TC001"
    Then User should navigate to Dashboard