package com.example.hellodroid;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HelloDroidActivity extends AppCompatActivity {
    private TextView message;
    private int counter = 0;
    private boolean redOn = false;
    private boolean blueOn = false;
    private boolean greenOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.clickCounter);
        ImageView droid = findViewById(R.id.droidImage);


        //Define and attach click listener
        droid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapDroid();
            }
        });


        Button red = findViewById(R.id.red_button);
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redOn = clickChange(red, redOn);
            }
        });


        Button blue = findViewById(R.id.blue_button);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueOn = clickChange(blue, blueOn);
            }
        });


        Button green = findViewById(R.id.green_button);
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenOn = clickChange(green, greenOn);
            }
        });
    }

    private void tapDroid() {
        counter++;
        String countAsText;
        /*
         * In real applications you should not write switch like the one below.
         * Use resource of type "Quantity strings (plurals)" instead.
         * See https://developer.android.com/guide/topics/resources/string-resource#Plurals
         */
        switch (counter) {
            case 1:
                countAsText = "once";
                break;
            case 2:
                countAsText = "twice";
                break;
            default:
                countAsText = String.format("%d times", counter);
        }
        message.setText(String.format("You touched the droid %s", countAsText));
    }

    @SuppressLint("ResourceAsColor")
    private boolean clickChange(Button button, boolean state){
        boolean bool = !state;
        if (bool) button.setTextColor(getResources().getColor(R.color.button_text_color_On));
        else button.setTextColor(getResources().getColor(R.color.button_text_color));
        return bool;
    }
}