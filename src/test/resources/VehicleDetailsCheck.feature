Feature: Verify the Licence plate numbers

  Scenario: Verify the car tax details from cartaxcheck website
    Given I read the car numbers from car_input.txt
    When I run it thorugh the cartaxcheck website
    Then the details should match car_output.txt