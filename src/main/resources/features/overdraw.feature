Feature: overdraw
  As a customer
  I can specified negotiated amount if I open OD account,
  so that I can withdraw more than my balance.

Scenario: Withdraw more than balance from non OD account
  Given a customer with id 1 and pin 111 with balance 100 exists
  And I login to ATM with id 1 and pin 111
  When I overdraw 200 from ATM
  Then I can not over withdraw because I am non OD account
  Then my account balance is 100

Scenario: Withdraw more than balance form OD account
  Given a customer OD account with id 2 and pin 222 with balance 200 and negotitaed amount 500 exists
  And I login to ATM with id 2 and pin 222
  When I overdraw 300 from ATM
  Then customer id 2 negotitaed amount is 400

Scenario: Withdraw more than balance and negotitaed amount from OD account
  Given a customer OD account with id 2 and pin 222 with balance 200 and negotitaed amount 400 exists
  And I login to ATM with id 2 and pin 222
  When I overdraw 800 from ATM
  Then customer id 2 negotitaed amount is 400
  Then my account balance is 200