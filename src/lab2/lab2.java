package lab2;

import java.util.Scanner;
import java.lang.Math;


/*
 * Write a program that reads in investment amount, annual interest rate, and the number of years,
 * and displays the future investment value using the following formula:
 *  futureInvestmentValue =
 *    investmentAmount * (1 + monthlyInterestRate)^(numberOfYears*12)
 */ 
public class lab2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double   investment ;
    double   monthlyInterestRate;
    double   annualInterestRate;
    int   numberOfYears; 
    
    System.out.print("Investment: $");
    investment = scanner.nextDouble();
    //Here is getting the annual interest rate
    System.out.print("Annual Interest rate (in decimal ie: 10% = 0.1): ");
    annualInterestRate = scanner.nextDouble();
    monthlyInterestRate = annualInterestRate / 12;
    System.out.print("Number of years: ");
    numberOfYears = scanner.nextInt();

    double futureInvestmentValue = investment * Math.pow( (1 + monthlyInterestRate), (numberOfYears * 12));
    System.out.printf("\nYour investment after %d years is $%.2f", numberOfYears, futureInvestmentValue);
    
    scanner.close();
  }
}
