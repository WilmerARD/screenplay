Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario: Consultar informacion de usuario
    Given "Juan" establece la base url "https://gorest.co.in/"
    
    When consulta en el endpoint "public/v1/users/" por id "151"
    Then valida que el estatus code sea 200 y la respuesta contenga el nombre "Aatmaj Nayar"