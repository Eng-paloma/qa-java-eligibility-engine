
# Eligibility Engine

## Visão do projeto

O `Eligibility Engine` é um motor de regras de negócio desenvolvido para portfólio de QA. O foco é demonstrar validação de regras de elegibilidade, criação de cenários positivos e negativos, automação de testes e documentação clara. O projeto evoluiu para incorporar práticas de BDD (Behavior Driven Development) utilizando Cucumber e Gherkin, permitindo que cenários de negócio sejam escritos em linguagem natural e sirvam como testes automatizados.

## Objetivo

Avaliar se um cliente é elegível com base nos dados de idade, renda mensal e score de crédito. O motor retorna:

- `Elegível` quando todas as regras são atendidas
- `Não elegível` quando alguma regra falha, incluindo os motivos específicos de reprovação

## Regras de negócio

1. Idade mínima: 18 anos
2. Renda mínima: R$ 2.000,00
3. Score mínimo: 600

## Arquitetura e responsabilidades

- `Client` - representa os dados do cliente
- `EligibilityRule` - interface que define a validação de regras
- `MinimumAgeRule`, `MinimumIncomeRule`, `MinimumCreditScoreRule` - regras específicas de validação
- `EligibilityCriteria` - centraliza os valores de aprovação e cria o conjunto padrão de regras
- `EligibilityEngine` - aplica todas as regras e agrega os motivos de reprovação
- `EligibilityResult` - representa o resultado final da avaliação
- `App` - exemplo de execução básica

## Cenários de teste cobertos

- Cliente elegível quando todos os critérios são atendidos
- Cliente menor de idade
- Cliente com renda insuficiente
- Cliente com score insuficiente
- Cliente com múltiplas falhas e motivos agregados

## Testes BDD com Cucumber

O projeto utiliza Cucumber para testes comportamentais, permitindo que cenários sejam descritos em Gherkin (em português) e executados como testes automatizados. Os cenários BDD servem como documentação viva e validação principal das regras de negócio.

### Exemplo de Cenário Gherkin

```gherkin
Cenário: Cliente elegível quando atende todos os critérios
  Dado que o cliente tem 30 anos, renda de 3000.00 e score de 650
  Quando avalio a elegibilidade do cliente
  Então o cliente deve ser considerado elegível
  E não deve haver nenhum motivo de reprovação
```

## Como executar

### Testes Unitários (JUnit 5)

```bash
mvn test -Dtest=EligibilityEngineTest
```

### Testes BDD (Cucumber)

```bash
mvn test -Dtest=RunCucumberTest
```

### Todos os Testes

```bash
mvn test
```

Os relatórios HTML do Cucumber são gerados em `target/cucumber-reports.html`.

## Tecnologias

- Java 17
- Maven
- JUnit 5

## Visão de QA e possíveis extensões

Este projeto está preparado para demonstrar uma mentalidade de QA:

- Regras de negócio centralizadas e fáceis de alterar
- Resultados claros e motivos específicos para reprovação
- Estrutura que facilita a criação de cenários de teste
- Código legível e organizado em camadas

### Possível evolução para testes de integração

O motor pode ser integrado a uma API simulada (Mock Server) para validar o fluxo completo de dados:

- receber solicitações HTTP com dados do cliente
- transformar os dados em objetos de domínio
- aplicar as regras do motor de elegibilidade
- retornar a decisão e os motivos em formato JSON

Esse tipo de integração permite demonstrar testes de QA além da camada unitária, como:

- testes de contrato de API
- testes de integração entre serviço e regras de negócio
- validação de mensagens e formatos de resposta

## Observações

Este projeto prioriza qualidade e clareza de resultados, tornando-se um bom exemplo para portfólio de QA em GitHub.


# QA Java – Motor de Elegibilidade

Este projeto faz parte do meu **portfólio como QA**, com foco em **validação de regras de negócio**, **criação de cenários de teste** e **automação de testes unitários** utilizando **Java**.
O objetivo não é desenvolver um sistema completo de mercado, mas sim demonstrar como um profissional de **Qualidade de Software** estrutura, valida e testa regras críticas de elegibilidade de forma clara, organizada e sustentável.

---

## 🎯 Objetivo do Projeto

Desenvolver um **Motor de Elegibilidade** que avalia se um cliente está elegível ou não com base em regras de negócio definidas, retornando:

- ✅ Resultado da avaliação (elegível / não elegível)
- 🧾 Motivo detalhado da decisão

Este motor pode ser utilizado em cenários como:

- Análise de crédito
- Portabilidade
- Ofertas financeiras
- Testes de integração com APIs externas

O objetivo **não é desenvolver um sistema completo de mercado**, mas demonstrar como um profissional de **Qualidade de Software** estrutura, valida e testa **regras críticas de elegibilidade** de forma clara, organizada e sustentável.



## 📋 Visão do Projeto

O **Eligibility Engine** é um **motor de regras de negócio** responsável por avaliar a elegibilidade de um cliente com base em critérios definidos.

O projeto foi desenvolvido com mentalidade de **engenharia de qualidade**, priorizando:

 Clareza das regras de negócio  
 Testes automatizados como base da qualidade  
 Cobertura de cenários positivos e negativos  
 Código limpo, legível e fácil de manter  


## 🎯 Objetivo do Motor

Avaliar se um cliente é **elegível** ou **não elegível** com base nos seguintes dados:

- Idade  
- Renda mensal  
- Score de crédito  

O motor retorna:

- ✅ Resultado da avaliação (**Elegível / Não elegível**)  
- 🧾 Motivo detalhado da decisão em caso de reprovação  


## ✅ Regras de Negócio Implementadas


O motor avalia um cliente considerando os seguintes critérios:
- **Idade mínima:** 18 anos  
- **Renda mínima:** R$ 2.000,00  
- **Score de crédito mínimo:** 600  

### Comportamento esperado:
- Caso **alguma regra não seja atendida**, o cliente será considerado **não elegível**, com o motivo específico.

### Comportamento esperado

- Caso **qualquer regra não seja atendida**, o cliente será considerado **não elegível**, com o motivo específico.
- Caso **todas as regras sejam atendidas**, o cliente será considerado **elegível**.

## 🧠 Visão de QA – Por que este projeto é relevante

Este projeto foi desenvolvido com mentalidade de **engenharia de qualidade**, demonstrando:

- Criação de **cenários positivos e negativos**
- Validação clara e explícita de regras de negócio
- Mensagens de retorno pensadas para facilitar análise de falhas
- Código organizado para facilitar manutenção e testes
- Uso de **testes automatizados** como base de qualidade

## 🏗 Arquitetura e Responsabilidades

- **Client** – Representa os dados do cliente  
- **EligibilityRule** – Interface base para regras de elegibilidade  
- **MinimumAgeRule** – Validação de idade mínima  
- **MinimumIncomeRule** – Validação de renda mínima  
- **MinimumCreditScoreRule** – Validação de score mínimo  
- **EligibilityCriteria** – Centraliza os valores de aprovação e cria o conjunto padrão de regras  
- **EligibilityEngine** – Aplica todas as regras e agrega os motivos de reprovação  
- **EligibilityResult** – Representa o resultado final da avaliação
  
## 🧪 Testes Automatizados

O projeto possui **testes unitários com JUnit 5**, cobrindo os seguintes cenários:

- ✅ Cliente elegível
- ❌ Cliente menor de idade
- ❌ Cliente com renda insuficiente
- ❌ Cliente com score de crédito abaixo do mínimo
- ✅ Validação do motivo retornado em cada reprovação

Os testes demonstram:
- Cobertura de regras críticas
- Prevenção de regressões
- Clareza de intenção nos cenários testados

## 🏗 Estrutura do Projeto

```text
eligibility-engine/
├── src
│   ├── main
│   │   └── java
│   │       └── com.example.eligibility
│   │           ├── model       # Modelos de domínio (Cliente, Resultado)
│   │           ├── rules       # Regras de elegibilidade
│   │           └── engine      # Motor de avaliação
│   ├── test
│   │   └── java
│   │       └── com.example.eligibility
│   │           └── EligibilityEngineTest.java
├── pom.xml
└── README.md

## Executar a aplicação
Smvn compile
java -jar target/eligibility-engine.jar``

## Executar os testes automatizados
mvn test

🛠 Tecnologias Utilizadas

O projeto utiliza **testes unitários com JUnit 5**, focados na validação das regras de negócio.

### Cenários cobertos

- ✅ Cliente elegível  
- ❌ Cliente menor de idade  
- ❌ Cliente com renda insuficiente  
- ❌ Cliente com score abaixo do mínimo  
- ❌ Cliente com múltiplas falhas e motivos agregados  

### Benefícios

- Cobertura de regras críticas  
- Prevenção de regressões  
- Clareza de intenção nos testes  

## ▶️ Como Executar os Testes

### Pré-requisitos

- **Java 17**

- **Maven**


### Possíveis evoluções

Integração com API REST
Inclusão de testes de integração
Simulação de serviços externos (mock server)
Testes de contrato e testes end-to-end


### 🛠 Tecnologias Utilizadas

Java 17
Maven
JUnit 5

###  📝 Licença
Este projeto está licenciado sob a MIT License.

