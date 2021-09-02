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
 */
public class DogGenetics {
    public static void main(String[] args){
        
        Scanner inRead = new Scanner(System.in);
        String dogName;

        System.out.println("Hello! Welcome to the Dog genetics simulation!");
        
        //ask user for dog name
        System.out.println("Please enter your dog's name! ");
        dogName = inRead.nextLine();
        System.out.println("Thank you, sit tight while I gather the genetic "
                + "make up of " + dogName);
        System.out.println("");
        
        System.out.println(dogName + "'s make up is: ");
        
        //call method to display results
        //method calls methods that return refernces to their arrays
        displayResults(getBreeds(), getPercents());
        
        System.out.println("");
        System.out.println("Wow! That's quite the Dog!");
    }
    
    public static String[] getBreeds(){
        
        //initialize array of dog breeds
        String[] allBreeds = {"Labrador Retriever", " German Shepherd", "Golden Retriever",
            "French Bulldog", "Bulldog", "Beagle", "Poodle", "Rottweiler",
            "Yorkshire Terrier", "German Shorthaired Pointer", "Boxer", "Siberian Husky",
            "Dachshund", "Great Dane", "Pembroke Welsh Corgi", "Doberman Pinscher",
            "Austrailian Shepherd", "Miniature Schnauzer", "Cavalier King Charles Spaniel",
            "Shih Tzu", "Boston Terrier", "Pomeranian", "Havanese", "Shetlan Sheepdog"};
        
        //create array to hold 5 random breeds for users dog
        String[] userDogsBreeds = new String[5];
        int[] randIndexes = new int[15];
        boolean found = true;
        for(int i = 0; i < 5; i++){
            //get a random index of all breeds to fill index of new array
            do{
                int randomIndex = (int)(Math.random() * allBreeds.length);
                randIndexes[i] = randomIndex;
                
                //check if random index has already been chosen
                for(int n : randIndexes){
                    if(n != randomIndex){
                        userDogsBreeds[i] = allBreeds[randomIndex];
                        found = false;
                    }
                    else{
                        randomIndex = (int) (Math.random() * allBreeds.length);
                        found = true;
                    }
                }
            }while(found);  //still getting repeated breeds in user breed array??
        }
        
        return userDogsBreeds;
    }
    
    public static int[] getPercents(){
        
        //new array for percentages
        int[] percentages = new int[5];
        //declare variables for percentage array
        int randomPercentage;
        int maxPercentage = 100;
        
        for(int i = 0; i < 4; i++){  
            //get a random percentage
            //add 1 to ensure percentage is never 0
            randomPercentage = (int)(Math.random() * (maxPercentage - 2)) + 1;
            //assign value to array index
            percentages[i] = randomPercentage;
            //adjust max so new random cannot be greater than the last
            maxPercentage = maxPercentage - randomPercentage;
        }
        
        int sum = 0;
        //for each loop to get sum of percentages and assign final percentage
        for(int numbers : percentages){
            sum += numbers;
        }
        //assign final percentage
        percentages[4] = 100 - sum;
        
        return percentages;     //still able to get 0%??
    }
    
    public static void displayResults(String[] breeds, int[] percents){
        for(int i = 0; i < percents.length; i++){
            System.out.println(percents[i] + "% " + breeds[i]);
        }
    }
}
