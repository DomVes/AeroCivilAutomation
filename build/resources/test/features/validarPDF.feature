
@ValidarPDF

Feature: Ver PDF de instrucciones
  como usuario debo poder ver el PDF de estado financiero de la pagina aerocivil
  Scenario: PDF
    Given Me encuentro en la pagina de aerocivil
    When Voy al modulo de balances
    Then Puedo ver PDF generado