package com.qa.eligibilityengine;

import java.util.Optional;

public final class MinimumCreditScoreRule implements EligibilityRule {
    private final int minimumScore;

    public MinimumCreditScoreRule(int minimumScore) {
        this.minimumScore = minimumScore;
    }

    @Override
    public Optional<String> validate(Client client) {
        if (client.getCreditScore() < minimumScore) {
            return Optional.of("Score de crédito mínimo de " + minimumScore + " não atendido.");
        }
        return Optional.empty();
    }
}
