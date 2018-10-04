package com.company;

public class DiceClient {
    public static void main (String args[]) {
        final int NUM_ROLLS = 4000; //Number of rolls
        final int DICE_VALS = 6;
        Dice dieRoll = new Dice(NUM_ROLLS); //number of die values rolled
        int[] rolledDieValues = dieRoll.getDieValues(); //Copies the values from dieRoll into an array
        int[] numDieValue = new int[DICE_VALS]; //Number of values for each die value that's rolled
        String[] star = new String[DICE_VALS]; //Number of stars for the amount of dice values
        double sum = 0; //sum of all the dice values
        double mean; //mean of all the dice values
        double sq_sum = 0; //square sum
        double stdev; //standard deviation of the dice
        //initialize all the numDieValue to 0
        for (int i = 0; i < numDieValue.length; i++) {
            numDieValue[i] = 0;
        }
        for (int i = 0; i < NUM_ROLLS; i++) {
            //Compare each die roll to the value of each die roll
            for (int j = 0; j < numDieValue.length; j++) {
                //checks to see what the value  of each die rolled is
                if ((j + 1) == rolledDieValues[i]) {
                    /* Increment the value of each index in the numDieValue array by 1
                     * when it finds it's corresponding rolled die value
                     */
                    numDieValue[j] += 1;
                }
            }
            sum += rolledDieValues[i]; //sum all of the die values
            sq_sum += rolledDieValues[i] * rolledDieValues[i]; //sum the squares of each die
        }
        mean = sum / NUM_ROLLS; //calculate the average of each die value
        /*
         * Calculating the standard deviation
         * Source: https://www.strchr.com/standard_deviation_in_one_pass
         */
        stdev = Math.sqrt(sq_sum / NUM_ROLLS - mean * mean);
        System.out.println("The average roll was " + mean);
        System.out.println("The standard deviation of the rolls was " + stdev);
        System.out.println("The histogram of the rolls is:");
        //Create the stars in a four loop
        for (int i = 0; i < star.length; i++) {
            int numStars = Math.round( (float) numDieValue[i] / 10 ); //The number of stars is equal to the number of values in each die value divided by 10
            star[i] = "*"; //initialize a star  as the first index, then append the rest later
            //Increment the amount of stars for each value
            for (int j = 0; j < numStars - 1; j++) {
                star[i] += "*";
            }
            System.out.println((i+1) + " (" + numDieValue[i] + ") :" + star[i]);  //Print the histogram
        }
    }
}
