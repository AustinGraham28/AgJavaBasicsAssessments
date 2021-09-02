/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.basicspractice;

import java.util.Scanner;

/**
 *
 * @author agrah
 */
public class InterestCalculator {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);

        double principal;
        float annualInterestRate;
        int yearsHeld;
        String compoundPeriod;

        System.out.println("Hello, Welcome to my interst calulator program!");

        //prompt for initial principal amount
        System.out.println("Please enter the princpal amount your will be investing: $");
        principal = Double.parseDouble(inRead.nextLine());
        
        //prompt for interest rate
        System.out.println("What is the annual interst rate % of this investment? "
                + "(Do not enter '%')");
        annualInterestRate = Float.parseFloat(inRead.nextLine());

        //prompt for year money will be held
        System.out.println("For how many years will you be investing? ");
        yearsHeld = Integer.parseInt(inRead.nextLine());
        
        boolean validEntry;
        do{ 
            
            //prompt for compound choice
            System.out.println("How often is your ivevestment compounded,");
            System.out.println("quarterly, monthly, or daily?");
            compoundPeriod = inRead.nextLine();
            System.out.println("\n"); 
            
            if(compoundPeriod.equalsIgnoreCase("Quarterly")){
                System.out.println("Thank you, here are the calculations: ");
                
                compoundQuarterly(principal, annualInterestRate, yearsHeld);
                validEntry = true;
            }
            else if(compoundPeriod.equalsIgnoreCase("Monthly")){
                System.out.println("Thank you, here are the calculations: ");
                
                compoundMonthly(principal, annualInterestRate, yearsHeld);
                validEntry = true;
            }
            else if(compoundPeriod.equalsIgnoreCase("Daily")){
                System.out.println("Thank you, here are the calculations: ");
                
                compoundDaily(principal, annualInterestRate, yearsHeld);
                validEntry = true;
            }
            else{
                System.out.println("Sorry, that is not a vaild compounding increment.");
                System.out.println("Please enter: Quarterly, Monthly, or Daily.");
                validEntry = false;
            }
        }while(validEntry = true);
    }  
    
    public static void compoundQuarterly(double principal, float annualInterestRate, int yearsHeld){    
        for(int i = 1; i <= yearsHeld; i++){
            
            double interestEarned = 0.0;
            float quarterlyInterestRate;
            double currentBalance = principal;
            
            //calculate quarterly rate
            quarterlyInterestRate = annualInterestRate / 4;
            
            //print year number
            System.out.println("Year " + i + ": ");
            
            //print the principal balance at the beginning of year
            System.out.println("Began with $" + Math.round(principal * 100.0) / 100.0);
            
            //calculate interest
            for(int j = 1; j <= 4; j++){
                currentBalance = currentBalance * (1+(quarterlyInterestRate / 100));
                interestEarned = currentBalance - principal; 
            }
            //print the interest earnd during year
            System.out.println("Interst earned: $" + Math.round(interestEarned * 100.0) / 100.0);
            
            //calculate new principal after year elapsed
            principal = currentBalance; 
            //print new principle post interest for the year
            System.out.println("Ended with: $" + Math.round(principal * 100.0) / 100.0);
            System.out.println("");
        }
    } 
    
    public static void compoundMonthly(double principal, float annualInterestRate, int yearsHeld){    
        for(int i = 1; i <= yearsHeld; i++){
            
            double interestEarned = 0.0;
            float monthlyInterestRate;
            double currentBalance = principal;
            
            //calculate Monthly rate
            monthlyInterestRate = annualInterestRate / 12;
            
            //print year number
            System.out.println("Year " + i + ": ");
            
            //print the principal balance at the beginning of year
            System.out.println("Began with $" + Math.round(principal * 100.0) / 100.0);
            
            //calculate interest
            for(int j = 1; j <= 12; j++){
                currentBalance = currentBalance * (1+(monthlyInterestRate / 100));
                interestEarned = currentBalance - principal; 
            }
            //print the interest earnd during year
            System.out.println("Interst earned: $" + Math.round(interestEarned * 100.0) / 100.0);
            
            //calculate new principal after year elapsed
            principal = currentBalance; 
            //print new principle post interest for the year
            System.out.println("Ended with: $" + Math.round(principal * 100.0) / 100.0);
            System.out.println("");
        }
    }
        
    public static void compoundDaily(double principal, float annualInterestRate, int yearsHeld){    
        for(int i = 1; i <= yearsHeld; i++){
            
            double interestEarned = 0.0;
            float dailyInterestRate;
            double currentBalance = principal;
            
            //calculate quarterly rate
            dailyInterestRate = annualInterestRate / 365;
            
            //print year number
            System.out.println("Year " + i + ": ");
            
            //print the principal balance at the beginning of year
            System.out.println("Began with $" + Math.round(principal * 100.0) / 100.0);
            
            //calculate interest
            for(int j = 1; j <= 365; j++){
                currentBalance = currentBalance * (1+(dailyInterestRate / 100));
                interestEarned = currentBalance - principal; 
            }
            //print the interest earnd during year
            System.out.println("Interst earned: $" + Math.round(interestEarned * 100.0) / 100.0);
            
            //calculate new principal after year elapsed
            principal = currentBalance; 
            //print new principle post interest for the year
            System.out.println("Ended with: $" + Math.round(principal * 100.0) / 100.0);
            System.out.println("");
        }
    }         
}
