Feature: As a twitter user
  I want to be able to send a direct message to a follower of mine
  So that we could talk in private


  Scenario: Sending DM to a follower
    Given Joe, Julie are on twitter
    And Julie is a follower of Joe
    When Joe sends a DM to Julie
    Then Julie should see Joe’s message

  Scenario: Sending DM to a non-follower
    Given Joe, Julie are on twitter
    And Julie is NOT following Joe
    And Joe is a follower of Julie
    When Joe sends a DM to Julie
    Then Joe should get an error response
    And Julie should not receive Joe’s message
