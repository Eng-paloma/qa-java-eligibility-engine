package com.qa.eligibilityengine;

import java.util.Optional;

public interface EligibilityRule {
    Optional<String> validate(Client client);
}
