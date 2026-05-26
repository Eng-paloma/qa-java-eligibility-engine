# QA Java – Motor de Elegibilidade

Este projeto faz parte do meu **portfólio como QA**, com foco em **validação de regras de negócio**, **criação de cenários de teste** e **automação de testes unitários** utilizando **Java**.

O objetivo **não é desenvolver um sistema completo de mercado**, mas demonstrar como um profissional de **Qualidade de Software** estrutura, valida e testa **regras críticas de elegibilidade** de forma clara, organizada e sustentável.

---

## 📋 Visão do Projeto

O **Eligibility Engine** é um **motor de regras de negócio** responsável por avaliar a elegibilidade de um cliente com base em critérios definidos.

O projeto foi desenvolvido com mentalidade de **engenharia de qualidade**, priorizando:

- Clareza das regras de negócio  
- Testes automatizados como base da qualidade  
- Cobertura de cenários positivos e negativos  
- Código limpo, legível e fácil de manter  

---

## 🎯 Objetivo do Motor

Avaliar se um cliente é **elegível** ou **não elegível** com base nos seguintes dados:

- Idade  
- Renda mensal  
- Score de crédito  

O motor retorna:

- ✅ Resultado da avaliação (**Elegível / Não elegível**)  
- 🧾 Motivo detalhado da decisão em caso de reprovação  

---

## ✅ Regras de Negócio Implementadas

- **Idade mínima:** 18 anos  
- **Renda mínima:** R$ 2.000,00  
- **Score de crédito mínimo:** 600  

### Comportamento esperado

- Caso **qualquer regra não seja atendida**, o cliente será considerado **não elegível**, com o motivo específico.
- Caso **todas as regras sejam atendidas**, o cliente será considerado **elegível**.

---

## 🏗 Arquitetura e Responsabilidades

- **Client** – Representa os dados do cliente  
- **EligibilityRule** – Interface base para regras de elegibilidade  
- **MinimumAgeRule** – Validação de idade mínima  
- **MinimumIncomeRule** – Validação de renda mínima  
- **MinimumCreditScoreRule** – Validação de score mínimo  
- **EligibilityCriteria** – Centraliza os valores de aprovação e cria o conjunto padrão de regras  
- **EligibilityEngine** – Aplica todas as regras e agrega os motivos de reprovação  
- **EligibilityResult** – Representa o resultado final da avaliação  

---

## 🧪 Testes Automatizados

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

---

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



