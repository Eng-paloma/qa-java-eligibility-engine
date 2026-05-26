package com.qa.eligibilityengine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EligibilityEngineTest {

    private final EligibilityEngine engine = new EligibilityEngine(EligibilityCriteria.defaultRules());

    @Test
    @DisplayName("Deve aprovar cliente elegível quando todas as regras são atendidas")
    void shouldReturnEligibleWhenAllRulesAreMet() {
        Client client = new Client(30, 3000.00, 650);

        EligibilityResult result = engine.evaluate(client);

        assertTrue(result.isEligible());
        assertTrue(result.getReasons().isEmpty());
    }

    @Test
    @DisplayName("Deve reprovar cliente menor de idade e retornar motivo específico")
    void shouldReturnNotEligibleWhenAgeIsBelowMinimum() {
        Client client = new Client(17, 2500.00, 700);

        EligibilityResult result = engine.evaluate(client);

        assertFalse(result.isEligible());
        assertEquals(1, result.getReasons().size());
        assertEquals("Idade mínima de 18 anos não atendida.", result.getReasons().get(0));
    }

    @Test
    @DisplayName("Deve reprovar cliente com renda insuficiente e retornar motivo específico")
    void shouldReturnNotEligibleWhenIncomeIsBelowMinimum() {
        Client client = new Client(25, 1500.00, 650);

        EligibilityResult result = engine.evaluate(client);

        assertFalse(result.isEligible());
        assertEquals(1, result.getReasons().size());
        assertEquals("Renda mínima de R$ 2000.00 não atendida.", result.getReasons().get(0));
    }

    @Test
    @DisplayName("Deve reprovar cliente com score insuficiente e retornar motivo específico")
    void shouldReturnNotEligibleWhenCreditScoreIsBelowMinimum() {
        Client client = new Client(25, 2500.00, 580);

        EligibilityResult result = engine.evaluate(client);

        assertFalse(result.isEligible());
        assertEquals(1, result.getReasons().size());
        assertEquals("Score de crédito mínimo de 600 não atendido.", result.getReasons().get(0));
    }

    @Test
    @DisplayName("Deve listar todos os motivos quando múltiplas regras falharem")
    void shouldReturnAllFailureReasonsWhenMultipleRulesFail() {
        Client client = new Client(16, 1500.00, 500);

        EligibilityResult result = engine.evaluate(client);

        assertFalse(result.isEligible());
        assertEquals(3, result.getReasons().size());
        assertTrue(result.getReasons().contains("Idade mínima de 18 anos não atendida."));
        assertTrue(result.getReasons().contains("Renda mínima de R$ 2000.00 não atendida."));
        assertTrue(result.getReasons().contains("Score de crédito mínimo de 600 não atendido."));
    }
}
