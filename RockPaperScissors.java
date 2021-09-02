/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.assessment;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author agrah
 */
public class RockPaperScissors {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);
        
        int numOfRounds;
        String userMove;
        
        String playAgain;
        boolean play;
        
        System.out.println("Wlcome to my virtual game of Rock, Paper, Scissors!!");
        
        //do while loop for play again prompt
        do{
            //declare count variables in loop to make sure resent if played again
            int ties = 0;
            int userWins = 0;
            int compWins = 0;
        
            //prompt user for number of rounds to play 
            System.out.println("Please enter the number of rounds you would like "
                    + "to play from 1 to 10: ");
            numOfRounds = Integer.parseInt(inRead.nextLine());

            //check that number of rounds is within gam limits of 1 to 10 rounds
            if(numOfRounds >= 1 && numOfRounds <= 10){
                for(int i = numOfRounds; i > 0; i--){
                    //variable getse method return value for later method call
                    userMove = getUserMove();
                    
                    //switch based on return of tie, user win, or computer win
                    switch (getRoundResults(userMove, getComputerMove())) {
                        case 0: //tie case
                            ties++;
                            break;
                        case 1: //user win case
                            userWins++;
                            break;
                        case -1: //computer win case
                            compWins++;
                            break;
                        default:
                            break;
                    }
                    
                    //blank line for looks
                    System.out.println("");
                }

                System.out.println("");
                //display final tallys based one above counts
                displayFinalTally(ties, userWins, compWins);
                System.out.println("");
            }
            else{
                System.out.println("Sorry but I can't play that number of rounds."
                        + "Play later? Okay bye for now!");
            }
            
            //prompt to play again
            System.out.println("Would you like to play again? (y/n)");
            playAgain = inRead.nextLine();
            
                //if yes, play again
                if(playAgain.equalsIgnoreCase("y")){
                    play = true;
                }
                //otherwise end game
                else if(playAgain.equalsIgnoreCase("n")){
                    System.out.println("Ok, thanks for playing! Bye.");
                    play = false;
                }
                //otherwise end game
                else{
                    System.out.println("I don't understand. Ta Ta for now.");
                    play = false;
                }
        }while(play); //end do-while loop for play again
    }
    
    //method to get and convert user move
    public static String getUserMove(){
        
        Scanner inRead = new Scanner(System.in);
        int uMoveInt;
        String uMoveStr = "";
        
            //prompt user for their move
            System.out.println("Enter your move, 1 for Rock, 2 for Paper, "
                            + "3 for Scissors: ");
            uMoveInt = Integer.parseInt(inRead.nextLine());
            
            switch(uMoveInt){
                case 1:
                    uMoveStr = "Rock";
                    break;
                case 2:
                    uMoveStr = "Paper";
                    break;
                case 3:
                    uMoveStr = "Scissors";
                    break;
                default:
                    //default to error if input is not valid 
                    System.out.println("Sorry that is not a valid move.");
                    break;
            }
        
        return uMoveStr;
    }
    
    //method to generate computer move and return string interpretation
    public static String getComputerMove(){
        int compNum;
        String compMove = "";
        Random rand = new Random();
        
        compNum = rand.nextInt(3) + 1;
        switch (compNum) {
            case 1:
                compMove = "Rock";
                break;
            case 2:
                compMove = "Paper";
                break;
            case 3:
                compMove = "Scissors";
                break;
            default:
                break;
        }
        
        return compMove;
    }
    
    //method to return round results
    public static int getRoundResults(String userMove, String compMove){
        
        //retun 0 = tie
        //return 1 = Player Win
        //return -1 = computer Win
        
        //display computers move for the round
        System.out.println("The computer threw: " + compMove);
        
        if(userMove.equals(compMove)){
            System.out.println("It's a tie!");
            return 0; //tie
        }
        else if(userMove.equals("Rock")){
            if(compMove.equals("Scissors")){
                System.out.println("You win! Rock breaks Scissors!");
                return 1; //player win
            }
            else if(compMove.equals("Paper")){
                System.out.println("You lost this round. Paper wraps rock!");
                return -1; //computer win
            }
        }
        else if(userMove.equals("Paper")){
            if(compMove.equals("Rock")){
                System.out.println("You win! Paper wraps rock!");
                return 1; //player win
            }
            else if(compMove.equals("Scissors")){
                System.out.println("You lost this round. Scissors cut paper!");
                return -1; //computer win
            }
        }
        else if(userMove.equals("Scissors")){
            if(compMove.equals("Paper")){
                System.out.println("You win! Scissors cut paper!");
                return 1; //player win
            }
            else if(compMove.equals("Rock")){
                System.out.println("You lost this round. Rock breaks scissors!");
                return -1; //computer win
            }
        }
        return 2; //arbitrary return to apease netbeans. could cause bug??
    }
    
    //method to display all final tallys
    public static void displayFinalTally(int ties, int userWins, int compWins){
        System.out.println("Final Tie count: " + ties);
        System.out.println("Final Player Win count: " + userWins);
        System.out.println("Final Computer Win count: " + compWins);
        
        if(userWins > compWins){
            System.out.println("You are the winner! Congratulations!");
        }
        else if(compWins > userWins){
            System.out.println("The Compuert won. Better Luck next time.");
        }
        else if(userWins == compWins){
            System.out.println("Looks like this game ends in a draw.");
        }
    }
}
