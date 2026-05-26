# language: pt
Funcionalidade: Avaliação de Elegibilidade do Cliente

  Cenário: Cliente elegível quando atende todos os critérios
    Dado que o cliente tem 30 anos, renda de 3000.00 e score de 650
    Quando avalio a elegibilidade do cliente
    Então o cliente deve ser considerado elegível
    E não deve haver nenhum motivo de reprovação

  Cenário: Cliente não elegível devido à idade insuficiente
    Dado que o cliente tem 17 anos, renda de 2500.00 e score de 700
    Quando avalio a elegibilidade do cliente
    Então o cliente não deve ser considerado elegível
    E o motivo deve ser "Idade mínima de 18 anos não atendida."

  Cenário: Cliente não elegível devido à renda insuficiente
    Dado que o cliente tem 25 anos, renda de 1500.00 e score de 650
    Quando avalio a elegibilidade do cliente
    Então o cliente não deve ser considerado elegível
    E o motivo deve ser "Renda mínima de R$ 2000.00 não atendida."

  Cenário: Cliente não elegível devido ao score insuficiente
    Dado que o cliente tem 25 anos, renda de 2500.00 e score de 580
    Quando avalio a elegibilidade do cliente
    Então o cliente não deve ser considerado elegível
    E o motivo deve ser "Score de crédito mínimo de 600 não atendido."

  Cenário: Cliente não elegível devido a múltiplas falhas
    Dado que o cliente tem 16 anos, renda de 1500.00 e score de 500
    Quando avalio a elegibilidade do cliente
    Então o cliente não deve ser considerado elegível
    E os motivos devem incluir "Idade mínima de 18 anos não atendida."
    E os motivos devem incluir "Renda mínima de R$ 2000.00 não atendida."
    E os motivos devem incluir "Score de crédito mínimo de 600 não atendido."