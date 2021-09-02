/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.assessment;

import java.util.Scanner;

/**
 *
 * @author Austin Graham
 * 09/01/2021
 */
public class HealthyHearts {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);
        int userAge;
        
        //prompt user for age
        System.out.println("Hello, Welcome to the target heart rate calulator.\n");
        System.out.println("Please enter you age:");
        userAge = Integer.parseInt(inRead.nextLine());
        System.out.println(""); //extra line for spacing
        
        //call to method that calculates and displays info
        getHealthyHeartRange(userAge);
    }
    
    public static void getHealthyHeartRange(int age){
        
        //declare + initialize calculation variables
        final int MAXHEARTRATE = 220;
        int maxUserRate = MAXHEARTRATE - age; //determines max HR for user
        double lowRangeMult = 0.5;
        double highRangeMult = 0.85;
        
        System.out.println("Your maximum heart rate should be " + maxUserRate
            + " beats per minute.");
        System.out.println("your target HR range is " 
                + String.format("%.0f - %.0f", maxUserRate * lowRangeMult, 
                        maxUserRate * highRangeMult) + " beats per minute.");
    }
}
