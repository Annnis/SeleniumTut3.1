Feature:

  Scenario:
    Given i go to main page
    And i choose random name
    And i open dropdown menu
    And i choose domain name
    And i save new e-mail
    And i open settings
    And i save secret address
    And i close settings
    Then i check that settings closed
    And i check visibility of text
    And i click on write button
    And i check that modal window opened
    Then i fill input to
    Then i fill input topic
    Then i fill input text
    Then i click send button
    And  i open new letter
    Then i check the sender
    Then i check the topic
    Then i check the text
    And  i click reply button
    Then i write to the text field
    Then i send a letter
    And i go back to main page
    Then i check that new letter received
    And i open received letter
    Then i check that body consist testTwo
    And i delete message
    Then i wait until modal window of deleting appear
    And i confirm deleting
    And i check that there are no Re Test
    Then i close browser

