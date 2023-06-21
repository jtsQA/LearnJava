package org.exercises;

public class LoanCalculator {

    public static void main(String[] args) {
        double principal = 1000000; // Principal loan amount
        double interestRate = 11; // Annual interest rate
        int tenureInMonths = 14 * 12; // Loan tenure in months

        double emi = calculateEMI(principal, interestRate, tenureInMonths);
        System.out.println("EMI: " + emi);
    }

    /*
    The formula to calculate EMI is P x R x (1+R)^N / [(1+R)^N-1] – where,
            “P” is the principal loan amount,
            “N” in tenure in months, and
            “R” is the prevailing interest rate.
     */
    public static double calculateEMI(double principal, double interestRate, int tenureInMonths) {
        double monthlyInterestRate = interestRate / (12 * 100);
        double emi = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureInMonths))
                / (Math.pow(1 + monthlyInterestRate, tenureInMonths) - 1);
        return emi;
    }

}
