Feature: CU Tests
  Users should be able to submit GET and POST with all features, represented by WireMock

  Scenario: Testuser creates a new collection
    When it's the first time user logged in to the system and their collection is created
    Then There will be a collection for that user

  Scenario: Testuser wants to know whether there's its collection
    When User send a GET request for the collection
    Then There is a collection information returned


  Scenario: Testuser wants to upload a information about a restaurant
    When User send a POST request with the information of the restaurant
    Then The restaurant is created and its information returned

  Scenario: Testuser wants to get information of all restaurants
    When User send a GET request to see the information of all restaurants
    Then The list of restaurant is returned

  Scenario: Testuser wants to know the restaurants in their collection
    When User send a GET request to see the restaurants in their collection
    Then The list of restaurents in their collection is returned
