Feature: Add new booking in the system

    Scenario Outline: Each booking has a unique ID which get in response
      Given the following new booking details: '<fName>','<lName>','<price>','<dPaid>','<aNeeds>','<cIn>','<cOut>'
      When record the booking
      Then the recorded booking api response code should be: '<responseCode>'
      Examples:
      |  fName  |   lName  |  price   |   dPaid   |   aNeeds   |    cIn        |       cOut    | responseCode |
      |  User1  |   Test   |  200     |   false   |  breakfast |  2018-01-01   |   2019-01-01  |     200      |
      |  Nisum  |   User   |  500     |   true    |   dinner   |  2018-01-01   |   2019-01-01  |     200      |
      |  Test1  |   User   |  340     |   true    |   lunch    |  2018-01-01   |   2019-01-01  |     200      |





#Feature: Record a new trade
#
#  Scenario Outline: Each trade has a unique ID
#    Given the following trade: '<security>','<buySell>','<quantity>','<priceInCents>'
#    When I record the trade
#    Then the recorded trade should include the following details:
#      | security | buySell | quantity | priceInCents | totalCostInCents |
#      | APPL     | BUY     | 10       | 10000        | 100000           |
#    Examples:
#      | security | buySell | quantity | priceInCents |
#      | APPL     | BUY     | 10       | 10000        |
#      | TEST     | POS     | 10       | 10000        |