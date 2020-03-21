Feature: Add new booking in the system

    Scenario Outline: Each booking has a unique ID which get in response
      Given the following new booking details: '<fName>','<lName>','<price>','<dPaid>','<aNeeds>','<cIn>','<cOut>'
      When record the booking
      Then the recorded booking api response code should be: '<responseCode>'
      Examples:
      |  fName  |   lName  |  price   |   dPaid   |   aNeeds   |    cIn        |       cOut    | responseCode |
      |  Nisum  |   User   |  500     |   true    |   dinner   |  2018-01-01   |   2019-01-01  |     200      |
#      |  Test1  |   User   |  340     |   true    |   lunch    |  2018-01-01   |   2019-01-01  |     200      |