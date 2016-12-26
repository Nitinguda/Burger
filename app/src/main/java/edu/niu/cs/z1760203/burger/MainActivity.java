package edu.niu.cs.z1760203.burger;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends Activity {

    //initialize variables

    private RadioGroup pattyRG;
    private CheckBox baconCB;
    private RadioGroup cheeseRG;
    private SeekBar sauceSB;
    private TextView caloriesTV;

    private Burger burger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create burger object

        burger = new Burger();

        //connect varialbes ans screen objects

        pattyRG = (RadioGroup)findViewById(R.id.pattyRadioGroup);
        baconCB = (CheckBox)findViewById(R.id.baconcheckBox);
        cheeseRG = (RadioGroup)findViewById(R.id.cheeseRadioGroup);
        sauceSB = (SeekBar)findViewById(R.id.sauceSeekBar);
        caloriesTV = (TextView)findViewById(R.id.calorieText);


        //disaply initial calorie count

        displayCalories();

        //set up listeners

        pattyRG.setOnCheckedChangeListener(burgerListener);

        cheeseRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){

                    case R.id.noCheeseRB: burger.setCheeseCalories(0);
                        break;
                    case R.id.cheddarRB: burger.setCheeseCalories(Burger.CHEDDAR);
                        break;
                    case R.id.mozRB: burger.setCheeseCalories(Burger.MOZZ);
                        break;
                }//switch ends

                displayCalories();
            }
        });

        baconCB.setOnClickListener(baconListener);
        sauceSB.setOnSeekBarChangeListener(sauceListener);

    }

    private RadioGroup.OnCheckedChangeListener burgerListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {

            switch (checkedId){
                case R.id.beefRB: burger.setPattyCalories(Burger.BEEF);
                    break;
                case R.id.turkeyRB: burger.setPattyCalories(Burger.TURKEY);
                    break;
                case R.id.veggieRB: burger.setPattyCalories(Burger.VEGGIE);
                    break;
            }//switch ends here

            displayCalories();


        }
    };

    //handle the checkbox

    private View.OnClickListener baconListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(((CheckBox)v).isChecked()){
                burger.setBaconCalories(true);

            }
            else{
                burger.setBaconCalories(false);
            }
    displayCalories();
        }
    };//onclicklistener ends here

    private SeekBar.OnSeekBarChangeListener sauceListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            burger.setSauceCalories(seekBar.getProgress());
            Log.d("MainActivity", "In seebar" + progress);
            displayCalories();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };//onseekbar ends

    //to display the calories

    private void displayCalories(){
        caloriesTV.setText("Calories : " + burger.getTotalCalories());
    }



}//end of main activity
