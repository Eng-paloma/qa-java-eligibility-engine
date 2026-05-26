package com.qa.eligibilityengine;

import java.util.Optional;

public final class MinimumIncomeRule implements EligibilityRule {
    private final double minimumIncome;

    public MinimumIncomeRule(double minimumIncome) {
        this.minimumIncome = minimumIncome;
    }

    @Override
    public Optional<String> validate(Client client) {
        if (client.getMonthlyIncome() < minimumIncome) {
            return Optional.of(String.format(java.util.Locale.US, "Renda mínima de R$ %.2f não atendida.", minimumIncome));
        }
        return Optional.empty();
    }
}
