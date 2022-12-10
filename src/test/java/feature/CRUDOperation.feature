Feature: To perform  CRUD operation

  Scenario: To perfom the GET operation on Employe DB
    Given The base URI is "http://localhost:3000/employees"
    When I perform the Get Operation
    Then Response code should be 200

  Scenario Outline: To perfom the POST operation on Employe DB
    Given The base URI is "http://localhost:3000/employees/create"
    When The username "<name>", salary of employee "<salary>" and perform post operation
    Then Response code is 201

    Examples: 
      | name   | salary |
      | Nikita |  25000 |
      | Payal  |  23000 |