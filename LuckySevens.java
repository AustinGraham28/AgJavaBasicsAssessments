/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.basicspractice;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Austin Graham
 */
public class LuckySevens {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);
        
        String playerReady;
        double playerBet;
        
        System.out.println("Welcome to a game of lucky sevens.");
        System.out.println("Are you ready to Play? (y/n)");
        playerReady = inRead.nextLine();
        System.out.println("\n");
        
        if(playerReady.equalsIgnoreCase("y")){
            
            //promt user how much they will bet
            System.out.println("Great! How much money are you betting? $");
            playerBet = Double.parseDouble(inRead.nextLine());
            
            int numOfRolls = 0;
            double betHolder = playerBet;
            double mostMoney = playerBet;
            int mostMoneyRoll = 0;
            //use loop to roll dice until money is gone
            for(int i = 1; playerBet > 0; i++){
                
                rollDice();
                if(rollDice() == 7){
                    playerBet = playerBet + 4;
                    if(playerBet > betHolder){
                        
                        //keep track of highest amount of money held by player
                        mostMoney = playerBet;
                        
                        //keep track of number of rolls when player held their 
                        //highest amount of money
                        mostMoneyRoll = numOfRolls;
                        
                        //holder now holds highest amount for if comparison.
                        betHolder = mostMoney;
                    }
                }
                else{
                    playerBet = playerBet - 1;
                }
                
                //keep track of number of rolls before money ran out
                numOfRolls++;
            }
            System.out.println("You rolled " + numOfRolls + " times before you ran out of money.");
            
            System.out.println("You had $" + mostMoney + " at " + mostMoneyRoll + " rolls. "
                    + "Should've stopped then!");
        }
        else{
            System.out.println("Okay, maybe another time.");
        }
    }
    
    public static int rollDice(){
        int dieOne;
        int dieTwo;
        int roll;
        
        Random randNums = new Random();
        
        dieOne = (int)(Math.random()* 6) + 1;
        dieTwo = (int)(Math.random()* 6) + 1;
        
        roll = dieOne + dieTwo;
        
        return roll;
    }
}
