package com.company;
import java.util.Random;
import java.util.Date;

public class Dice {
    //Integer Array die
    private int[] die;
    //Instance variable
    private Random random;
     
    /**
     * Default constructor that will construct default pair of die
     */
    public Dice(){
        this(2);
    }

    /**
     * @Overload of Dice
     * Allow any number of dice
     * @param numDice
     */
    public Dice (int numDice){
        if (numDice < 1) {
            throw new IllegalArgumentException("Number must be one or greater");
        }
        this.die = new int[numDice];
        this.random = new Random(new Date().hashCode());
        for(int i = 0; i < die.length; i++){
            this.die[i]= rollDie();
        }
    }

    /**
     * Roll all of dice at once and return total value
     * @return int
     */
    public int roll(){
        //Sum of all the rolls
        int sum = 0;
        for(int i = 0; i < this.die.length; i++) {
            this.die[i] = rollDie();
            sum += rollDie(); // calling up the rollDie method
        }
        return sum;
    }

    /**
     * Rolls a single die and ensures that value is
     * between 1 and 6 inclusive
     * @return int
     */
    private int rollDie(){
        int max = 6; //max roll
        int min = 1;//min roll
        int range = max - min  + 1; //find the range of the dice values
        return random.nextInt(range) + min; //return a random number within the range
    }

    /**
     * Mutator
     * Returns all of the individual die-values
     * @return die
     */
    public int[] getDieValues() {
        int[] diceValues = new int[die.length];
        for(int i = 0; i < diceValues.length; i++){
            diceValues[i] = this.die[i];
        }
        return diceValues;
    }

    /**
     * Returns a string which has a space-seperated list of all the individual die-values
     * @return diceString
     */
    public String toString(){
        //Initialize the string of dice values to the first dice value
        String diceString = String.valueOf(this.die[0]); //Add the first dice roll to the diceString variable
        String diceRoll; //String variable containing the string of the current dice roll
        /*
          * Loop through the dice array after the first index that adds the
          * current diceRoll string at the end of the array.
         */
        for(int i = 1; i< this.die.length; i++){
            diceRoll = String.valueOf(this.die[i]);
            diceString.concat(" " + diceRoll);
        }
        return diceString;
    }

    /**
     * Returns true if there are any double values amongst the die values
     * @return boolean
     */
    public boolean hasDoubles() {
        for(int i = 0; i < die.length; i++){
            for(int j = 0; j < die.length; j++){
                if(die[i]==die[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
