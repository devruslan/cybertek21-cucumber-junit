Feature: Etsy search feature

  @etsy
  Scenario: Etsy default title verification
    Given user is on the Etsy landing page
    Then user should see Etsy title as expected

    #expected: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  Scenario: Etsy search title verification
    Given user is on the Etsy landing page
    When  user searches for "wooden spoon"
    Then user should see "wooden spoon" in title