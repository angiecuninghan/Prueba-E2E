Feature: Flujo de compra

  @happyPath
  Scenario: Compra exitosa
    Given el ingreso al sistema Swag labs
    When inicio de sesion con user "standard_user" y password "secret_sauce"
    And Seleccionar dos productos
    And Visualizar carrito
    And Completar el formulario de compra con el archivo "infocompra.csv"
    Then Visualizar mensaje "Thank you for your order!"