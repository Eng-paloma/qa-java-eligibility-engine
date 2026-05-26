package com.qa.eligibilityengine;

public final class Client {
    private final int age;
    private final double monthlyIncome;
    private final int creditScore;

    public Client(int age, double monthlyIncome, int creditScore) {
        this.age = age;
        this.monthlyIncome = monthlyIncome;
        this.creditScore = creditScore;
    }

    public int getAge() {
        return age;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public int getCreditScore() {
        return creditScore;
    }
}
