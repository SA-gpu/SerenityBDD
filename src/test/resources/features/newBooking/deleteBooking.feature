Feature: Delete booking from the system

  Scenario Outline: Delete the detail of booking created
    Given the following new booking details: '<fName>','<lName>','<price>','<dPaid>','<aNeeds>','<cIn>','<cOut>'
    When record the booking
    And Delete booking details
    Then the recorded booking api response code should be: '<responseCode>'
    Examples:
      | fName   | lName    | price    |    dPaid  |   aNeeds   |      cIn      |    cOut       | responseCode |
      |  Test1  |   User   |  340     |   true    |   lunch    |  2018-01-01   |   2019-01-01  |     201      |