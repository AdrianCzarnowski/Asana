Feature:  Asana Test

  Scenario: Get projects details: gid
    Given I have project object
    When User perform astana GET projects operation
    Then  User is able to projects GID

  Scenario: Post project
    When  User perform POST request
    Then  new project added