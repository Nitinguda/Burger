package edu.niu.cs.z1760203.burger;

/**
 * Created by z1760203 on 2/9/2016.
 */
public class Burger {


    //constants

    static final int BEEF = 90,
                     TURKEY = 170,
                     VEGGIE = 150,
                     CHEDDAR = 113,
                     MOZZ = 78,
                     BACON = 86;

    //instance variables

    private int pattyCalories, cheeseCalories, baconCalories, sauceCalories;

    //constructor to initialize values

    public Burger(){

        pattyCalories = BEEF;
        cheeseCalories = 0;
        baconCalories = 0;
        sauceCalories = 0;

    }//constructor ends

    //setter methods

    public void setPattyCalories(int newCalories)
    {
        this.pattyCalories = newCalories;
    }

    public void setCheeseCalories(int cheeseCalories) {
        this.cheeseCalories = cheeseCalories;
    }

    public void setBaconCalories(boolean hasBacon) {
        if (hasBacon)
            baconCalories = BACON;
        else
            baconCalories = 0;
    }

    public void setSauceCalories(int sauceCalories) {
        this.sauceCalories = sauceCalories;
    }


    public int getTotalCalories()
    {
        return  pattyCalories + cheeseCalories + baconCalories + sauceCalories;
    }



}//class ends here
