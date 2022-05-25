Feature:  Asana Test

  Scenario: Get projects details: gid
    Given I have projects authorization
    When User perform astana GET projects operation
    Then  User is able to projects GID