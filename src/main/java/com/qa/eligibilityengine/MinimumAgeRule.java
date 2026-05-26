package com.qa.eligibilityengine;

import java.util.Optional;

public final class MinimumAgeRule implements EligibilityRule {
    private final int minimumAge;

    public MinimumAgeRule(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    @Override
    public Optional<String> validate(Client client) {
        if (client.getAge() < minimumAge) {
            return Optional.of("Idade mínima de " + minimumAge + " anos não atendida.");
        }
        return Optional.empty();
    }
}
