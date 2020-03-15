Feature: Record a new trade

  Scenario Outline: Each trade has a unique ID
    Given the following trade: '<security>','<buySell>','<quantity>','<priceInCents>'
    When I record the trade
    Then the recorded trade should include the following details:
      | security | buySell | quantity | priceInCents | totalCostInCents |
      | APPL     | BUY     | 10       | 10000        | 100000           |
    Examples:
      | security | buySell | quantity | priceInCents |
      | APPL     | BUY     | 10       | 10000        |
      | TEST     | POS     | 10       | 10000        |