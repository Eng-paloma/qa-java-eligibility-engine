package com.qa.eligibilityengine;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class EligibilityResult {
    private final boolean eligible;
    private final List<String> reasons;

    private EligibilityResult(boolean eligible, List<String> reasons) {
        this.eligible = eligible;
        this.reasons = Collections.unmodifiableList(reasons);
    }

    public static EligibilityResult eligible() {
        return new EligibilityResult(true, List.of());
    }

    public static EligibilityResult notEligible(List<String> reasons) {
        Objects.requireNonNull(reasons, "reasons must not be null");
        return new EligibilityResult(false, reasons);
    }

    public boolean isEligible() {
        return eligible;
    }

    public List<String> getReasons() {
        return reasons;
    }

    @Override
    public String toString() {
        if (eligible) {
            return "Elegível";
        }
        return "Não elegível: " + String.join("; ", reasons);
    }
}
