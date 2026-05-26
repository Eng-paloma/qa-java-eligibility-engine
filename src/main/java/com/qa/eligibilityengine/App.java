package com.qa.eligibilityengine;

public final class App {
    public static void main(String[] args) {
        Client client = new Client(25, 3500.00, 700);
        EligibilityEngine engine = new EligibilityEngine(EligibilityCriteria.defaultRules());

        EligibilityResult result = engine.evaluate(client);
        System.out.println(result);
    }
}
