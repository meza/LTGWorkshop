Feature: As a twitter user
  I want to be able to send a direct message to a follower of mine
  So that we could talk in private

  Scenario: Sending DM to a follower
    Given I open "http://www.twitter.com"
    And I enter "username2" into "#username"
    And I enter "bbb2" into "#password"
    And I click the "Sign in" button
    And I open "http://www.twitter.com/username1"
    And I click the "Follow" button
    Then I click on ".nav-session"
    And I click on the "Sign out" button
    Given I open "http://www.twitter.com"
    And I enter "username1" into "#username"
    And I enter "bbb" into "#password"
    And I click the "Sign in" button
    When I open "http://www.twitter.com/messages"
    And I click the "New message" button
    And I enter "username2" into ".dm-to-input"
    And enter "some mesage" into "#tweet-box-dm-new-conversation"
    And I click the "Send message" button
    Then I click on ".nav-session"
    And I click on the "Sign out" button
    And I enter "username2" into "#username"
    And I enter "bbb2" into "#password"
    And I click the "Sign in" button
    When I click open "http://www.twitter.com/messages"
    Then I should find "username1" on the page
    And I should see "some message" on the page

  Scenario: Sending DM to a non-follower
    Given I open "http://www.twitter.com"
    And I enter "username2" into "#username"
    And I enter "bbb2" into "#password"
    And I click the "Sign in" button
    And I open "http://www.twitter.com/username1"
    And I click the "Unfollow" button
    Then I click on ".nav-session"
    And I click on the "Sign out" button
    Given I open "http://www.twitter.com"
    And I enter "username1" into "#username"
    And I enter "bbb" into "#password"
    And I click the "Sign in" button
    When I open "http://www.twitter.com/messages"
    And I click the "New message" button
    And I enter "username2" into ".dm-to-input"
    And enter "some mesage 2" into "#tweet-box-dm-new-conversation"
    And I click the "Send message" button
    Then I should see "Your message could not be sent to @username1 because they do not follow you." on the page
