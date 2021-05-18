Feature: Inicio de sesion Inkafarma - Google

  Scenario: Inicio Exitoso
    Given Cliente Entra a la página de inkafarma
    When selecciona el inicio de sesión con Google
    And  ingresamos con el correo "correoPruebasCov" y presionamos el botón siguiente
    And  ingresamos la contraseña "123456_$%&" y presionamos el botón siguiente
    Then podemos acceder al aplicativo y se muestra nuestro nombre "pruebas correo prueba"