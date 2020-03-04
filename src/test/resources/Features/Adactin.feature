Feature: To validate the Adactin Page

  Scenario: To validate the user details
    Given User is on the Adactin homepage
    When User enters his details
      | userName   | password  |
      | Aravinthan | Adactin1@ |
    And User clicks the login button
    And User should verify the message
    And User should search hotel
      | location | Hotels         | roomtypes    | numberofrooms | adultsperroom | childrenperroom | checkinDate | checkoutDate |
      | London   | Hotel Sunshine | Super Deluxe | 3 - Three     | 2 - Two       | 1 - One         | 26/03/2020  | 30/03/2020   |
    And User enters payment
      | firstname  | lastname | billingaddress | creditcardnumber | creditcardtype   | expirymonth | expiryyear | cvvnumber |
      | Aravinthan | Scott    | chennai        | 9765432112345678 | American Express | March       |       2021 |       564 |
    And User gets orderid
    Then User has canceled the booking
