Feature: Simple example of how dataTables work


  @dataTable @R
  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |


  Scenario: User should be able to login with correct credentials
    Given User is on the login page of SmartBear
    When User enters below info
      |username|Tester|
      |password|test |
    Then User should see title changed to Web Orders

  @this
  Scenario: Something happens
#    Given user is somewhere
    Then User should see below words displayed
      | Apple      |
      | Kiwi       |
      | Orange     |
      | Broccoli   |
      | Watermelon |

