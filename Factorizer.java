/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.factorize;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author agrah
 */
public class Factorizer {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);
        int userInt;
        int factorCount = 0;
        
        //get number from user for factoring
        System.out.println("Hello, please provide the ineger you would like to factor: ");
        userInt = Integer.parseInt(inRead.nextLine());
        System.out.println();
        
        //print the users number
        System.out.println("The factors of " + userInt + " are: ");
        
        //call to method that prints each factor of the number 
        //Also prints total factors
        getFactors(userInt);
        
        
        //print if the number is perfect
        if(isPerfect(userInt)){
            System.out.println(userInt + " is a perfect number.");
        }
        else
            System.out.println(userInt + " is NOT a perfect number.");
        
        //print if the number is prime
        if(isPrime(userInt)){
            System.out.println(userInt + " is a prime number.");
        }
        else
            System.out.println(userInt + " is NOT a prime numer.");
    }
    
    public static void getFactors(int userInt){
    
        //declare/initialize counter
        int factorCount = 0;
    
        for(int i = 1; i <= userInt; i++){
            if(userInt % i == 0){   //factors will yield remainder of 0
                System.out.print(i + ", ");
                factorCount++;
            }    
        }    
        //print total number of factors of user number
        System.out.println();
        System.out.println(userInt + " has " + factorCount + " factors.");
        
    }
    
    public static boolean isPerfect(int userInt){
        
        long sum = 0;
        int i = 1; //used as check for factor and is incremented
        
        while(i <= userInt/2){
            if(userInt % i == 0){
                sum = sum + i;
            }
        i++;    
        }
        
        if(sum == userInt){
            return true;
        }
        else{
            return false;
        }
    }
    
    //Prime checking method, returns to if else block to print determination
    public static boolean isPrime(int userInt){
        BigInteger bigInt = BigInteger.valueOf(userInt);
        return bigInt.isProbablePrime(100);
    }
}
