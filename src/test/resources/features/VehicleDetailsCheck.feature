Feature: Verify the car registration numbers and details

  Scenario: Verify the car registration number and details from cartaxcheck website
    Given I read the car numbers from car_input.txt
    When I run it through the cartaxcheck website
    Then the details should match car_output.txt