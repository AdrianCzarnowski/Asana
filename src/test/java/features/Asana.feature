Feature:  Asana Test

  Scenario: Create new project
    Given I have data to create new project
    When  User perform POST request
    Then  New project added

  Scenario: Get projects details: gid
    Given I have project object
    When User perform astana GET projects operation
    Then  User is able to projects GID

  Scenario: Update project
    Given I have project to update
    When User perform PUT request
    Then Project is updated

  Scenario: Delete project
    Given I have project to delete
    When User perform DELETE request
    Then Project is not available


