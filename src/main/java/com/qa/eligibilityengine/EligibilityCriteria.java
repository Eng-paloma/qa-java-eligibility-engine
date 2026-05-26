package com.qa.eligibilityengine;

import java.util.List;

public final class EligibilityCriteria {
    public static final int MINIMUM_AGE = 18;
    public static final double MINIMUM_INCOME = 2000.00;
    public static final int MINIMUM_CREDIT_SCORE = 600;

    private EligibilityCriteria() {
        // Classe utilitária
    }

    public static List<EligibilityRule> defaultRules() {
        return List.of(
                new MinimumAgeRule(MINIMUM_AGE),
                new MinimumIncomeRule(MINIMUM_INCOME),
                new MinimumCreditScoreRule(MINIMUM_CREDIT_SCORE)
        );
    }
}
