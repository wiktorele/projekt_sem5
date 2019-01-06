package com.example.wiktor.lost_in_london;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.Serializable;

public class MenuActivity extends AppCompatActivity {

    Button zoo, restaurant;
    SharedPreferences utils;
    TextView points;
    ImageView finish;
    MediaPlayer sound;
    int background;

    int currentScore = 0;
    int newScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        currentScore = getPoints();
        newScore = getIntent().getIntExtra("SCORE", 0);
        savePoints(currentScore);

        points = findViewById(R.id.points);
        points.setText(currentScore + "/2");

        zoo = (Button) findViewById(R.id.zoo);
        restaurant = (Button) findViewById(R.id.restaurant);

        finish = findViewById(R.id.finish);

        restaurant.setAlpha(0);
        finish.setAlpha(0);

        if(currentScore >= 1){
            restaurant.setAlpha(1);
        }
        if(currentScore >= 2){
            finish.setAlpha(255);
        }

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sound = MediaPlayer.create(MenuActivity.this, R.raw.applause);
                sound.start();
            }
        });

        zoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, Zoo.class);
                startActivity(intent);
            }
        });

        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MenuActivity.this, Restaurant.class);
                startActivity(intent);
            }
        });
    }
    public int getPoints(){
        SharedPreferences sharesPref = PreferenceManager.getDefaultSharedPreferences(this);
        return  sharesPref.getInt("points", 0);
    }
    public void savePoints(int points){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("points", points);
        editor.apply();
    }
}
