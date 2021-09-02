/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.assessment;

/**
 *
 * @author Austin Graham
 * 09/01/2021
 */
public class SummativeSums {
    public static void main(String[] args){
        //initialize arrays with given values
        int[] array1 = { 1, 90, -33, -55, 67, -16, 28, -55, 15 };
        int[] array2 = { 999, -60, -77, 14, 160, 301 };
        int[] array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130, 
            140, 150, 160, 170, 180, 190, 200, -99 };
        
        //display resulting sums of arrays with method call
        System.out.println("#1 Array sum: " + sum(array1));
        System.out.println("#1 Array sum: " + sum(array2));
        System.out.println("#1 Array sum: " + sum(array3));
    }
    
    public static int sum(int[] array){
        
        //variable to hold sum of values
        int sum= 0;
        
        //for each loop to iterate through array and add values within
        for(int values: array){
            sum += values;
        }
        return sum;
    }
}
