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

---

## ✅ Regras de Negócio Implementadas

O motor avalia um cliente considerando os seguintes critérios:

- **Idade mínima:** 18 anos  
- **Renda mínima:** R$ 2.000,00  
- **Score de crédito mínimo:** 600  

### Comportamento esperado:
- Caso **alguma regra não seja atendida**, o cliente será considerado **não elegível**, com o motivo específico.
- Caso **todas as regras sejam atendidas**, o cliente será considerado **elegível**.

---

## 🧠 Visão de QA – Por que este projeto é relevante

Este projeto foi desenvolvido com mentalidade de **engenharia de qualidade**, demonstrando:

- Criação de **cenários positivos e negativos**
- Validação clara e explícita de regras de negócio
- Mensagens de retorno pensadas para facilitar análise de falhas
- Código organizado para facilitar manutenção e testes
- Uso de **testes automatizados** como base de qualidade

---

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

---

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

Java 17
Maven
JUnit 5
