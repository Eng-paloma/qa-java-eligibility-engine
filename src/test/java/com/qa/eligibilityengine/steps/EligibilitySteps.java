package com.qa.eligibilityengine.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

import static org.junit.jupiter.api.Assertions.*;

import com.qa.eligibilityengine.*;

public class EligibilitySteps {
    private Client client;
    private EligibilityResult result;
    private final EligibilityEngine engine = new EligibilityEngine(EligibilityCriteria.defaultRules());

    @Dado("que o cliente tem {int} anos, renda de {doubleNumber} e score de {int}")
    public void que_o_cliente_tem_anos_renda_e_score(int age, Double income, int score) {
        this.client = new Client(age, income, score);
    }

    @Quando("avalio a elegibilidade do cliente")
    public void avalio_a_elegibilidade_do_cliente() {
        this.result = engine.evaluate(client);
    }

    @Então("o cliente deve ser considerado elegível")
    public void o_cliente_deve_ser_considerado_elegivel() {
        assertTrue(result.isEligible());
    }

    @Então("não deve haver nenhum motivo de reprovação")
    public void nao_deve_haver_nenhum_motivo_de_reprovacao() {
        assertTrue(result.getReasons().isEmpty());
    }

    @Então("o cliente não deve ser considerado elegível")
    public void o_cliente_nao_deve_ser_considerado_elegivel() {
        assertFalse(result.isEligible());
    }

    @Então("o motivo deve ser {string}")
    public void o_motivo_deve_ser(String expectedReason) {
        assertEquals(1, result.getReasons().size());
        assertEquals(expectedReason, result.getReasons().get(0));
    }

    @Então("os motivos devem incluir {string}")
    public void os_motivos_devem_incluir(String expectedReason) {
        assertTrue(result.getReasons().contains(expectedReason));
    }
}