Feature: Update booking in the system

  Scenario Outline: update the detail of booking created - full record update
    Given the following new booking details: '<fName>','<lName>','<price>','<dPaid>','<aNeeds>','<cIn>','<cOut>'
    When record the booking
    Given the following new booking details: '<UfName>','<UlName>','<Uprice>','<UdPaid>','<UaNeeds>','<UcIn>','<UcOut>'
    When update the booking
    Then the recorded booking api response code should be: '<responseCode>'
    Examples:
      | fName  | lName  | price | dPaid | aNeeds |   cIn     |  cOut     | UfName | UlName | Uprice | UdPaid | UaNeeds  |   UcIn    |  UcOut   | responseCode |
      | Test1  | User   | 340   | true  | lunch  | 2018-01-01| 2019-01-01| update |   User |  420   | false  | breakfast| 2018-01-01|2019-01-01|    200       |