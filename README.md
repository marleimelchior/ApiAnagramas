# Anagrama Service

## Visão Geral

Este projeto fornece um serviço para gerar anagramas a partir de uma string de entrada. Inclui uma API REST para interagir com o serviço e testes de unidade para validar a funcionalidade.

## Estrutura do Projeto

- `src/main/java/JavaSpring/dse_teste/service/AnagramaService.java`: Contém a lógica para gerar anagramas.
- `src/main/java/JavaSpring/dse_teste/controller/AnagramaController.java`: Controlador REST para lidar com as requisições da API.
- `src/main/java/JavaSpring/dse_teste/model/AnagramaResponse.java`: Classe modelo para a resposta da API.
- `src/test/java/JavaSpring/dse_teste/service/AnagramaServiceTest.java`: Testes de unidade para a classe `AnagramaService`.

## Gerando Anagramas

A classe `AnagramaService` contém a lógica para gerar anagramas. O método principal é `gerarAnagramas`, que recebe uma string de entrada e retorna uma lista de anagramas.

### Lógica

1. **Validação de Entrada**:
    - A string de entrada não deve ser nula ou vazia.
    - A string de entrada deve conter apenas letras.
    - A string de entrada deve conter mais de uma letra.

2. **Gerando Permutações**:
    - O método `gerarPermutacoes` é usado para gerar todas as permutações possíveis da string de entrada.
    - Ele usa uma abordagem recursiva para trocar caracteres e gerar permutações.

3. **Trocando Caracteres**:
    - O método `swap` é usado para trocar caracteres no array de caracteres.

### Exemplo

Para a string de entrada "abc", os anagramas gerados são:
- "abc"
- "acb"
- "bac"
- "bca"
- "cab"
- "cba"

## API

A API REST é fornecida pela classe `AnagramaController`.

### Endpoint

- `GET /api/anagramas?input={input}`: Retorna os anagramas para a string de entrada fornecida.

### Resposta

A resposta é uma instância de `AnagramaResponse`, que contém a entrada original e a lista de anagramas.

### Tratamento de Erros

- Se a entrada for inválida, a API retorna um status `400 Bad Request` com uma mensagem de erro apropriada.

## Testes de Unidade

Os testes de unidade para a classe `AnagramaService` estão localizados em `src/test/java/JavaSpring/dse_teste/service/AnagramaServiceTest.java`. Os testes cobrem os seguintes casos:
- Entrada vazia
- Entrada com uma única letra
- Entrada com várias letras

## Dependências

O projeto usa as seguintes dependências:
- Spring Boot
- Lombok
- JUnit 5


## Executando o Projeto

Para executar o projeto, você pode usar o Maven e o Spring Boot. Basta executar o seguinte comando na raiz do projeto:


tenha o Maven instalado em sua máquina.
use o Java 17
```
mvn clean install
```
```
mvn spring-boot:run
```

swagger: http://localhost:8080/swagger-ui/index.html#/