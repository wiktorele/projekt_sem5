package com.example.wiktor.lost_in_london;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Constructor;

public class Lvl1 extends AppCompatActivity {

    Button next;
    Button restart;
    Button back;

    ImageView image;

    Integer[] images;

    MediaPlayer sound;

    Integer[] sounds;

    TextView sign;

    String[] signs;

    Lvl1(String name, Integer images[], Integer sounds[], String signs[]){

        this.images = images;
        this.sounds = sounds;
        this.signs = signs;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);

        image = (ImageView) findViewById(R.id.image);

        next = (Button) findViewById(R.id.next);

        back = (Button) findViewById(R.id.back);

        restart = (Button) findViewById(R.id.restart);

        sign = (TextView) findViewById(R.id.sign);

        next.setOnClickListener(forward);

        back.setOnClickListener(backward);

        restart.setOnClickListener(re);

    }

    View.OnClickListener forward = new View.OnClickListener() {

        int i = 0;
        @Override

        public void onClick(View v) {
            if(i < images.length) {

                image.setImageResource(images[i]);

                sound = MediaPlayer.create(Lvl1.this, sounds[i]);
                sound.start();

                sign.setText(signs[i]);

                i++;
            }else{

                Intent intent = new Intent(Lvl1.this, Lvl2.class);
                startActivity(intent);
            }
        }
    };

    View.OnClickListener backward = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Lvl1.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Lvl1.this, Lvl1.class);
            startActivity(intent);
        }
    };
}
