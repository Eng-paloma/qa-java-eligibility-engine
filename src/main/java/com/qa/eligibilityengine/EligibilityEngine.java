package com.qa.eligibilityengine;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class EligibilityEngine {
    private final List<EligibilityRule> rules;

    public EligibilityEngine(List<EligibilityRule> rules) {
        this.rules = new ArrayList<>(Objects.requireNonNull(rules, "rules must not be null"));
    }

    public EligibilityResult evaluate(Client client) {
        Objects.requireNonNull(client, "client must not be null");

        List<String> reasons = new ArrayList<>();
        for (EligibilityRule rule : rules) {
            rule.validate(client).ifPresent(reasons::add);
        }

        if (reasons.isEmpty()) {
            return EligibilityResult.eligible();
        }
        return EligibilityResult.notEligible(reasons);
    }
}
