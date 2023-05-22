
@aberturadeconta
Feature: Abertura de conta
  
  @pessoafisica
  Scenario: Fluxo do formulario de abertura 
  Scenario Outline: Conta pessoa Fisica
    Given que o usuario acesse a url "https://www.original.com.br/"
    And selecione o botao abrir nova conta
    And selecionar o botao abrir conta para voce
    #When o usuario preencher o formulario
    When preencher o campo nome "<nome>"
    And selecionar o botao quero ser cliente
    Then valido o texto falta pouco
    
    Examples:
              |nome |
              |Thais|
              |Maria|
