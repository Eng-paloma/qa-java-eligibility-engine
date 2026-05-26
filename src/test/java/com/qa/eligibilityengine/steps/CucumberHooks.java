package com.qa.eligibilityengine.steps;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;

public class CucumberHooks {
    
    @ParameterType("\\d+\\.\\d+")
    public Double doubleNumber(String value) {
        return Double.parseDouble(value);
    }
}
