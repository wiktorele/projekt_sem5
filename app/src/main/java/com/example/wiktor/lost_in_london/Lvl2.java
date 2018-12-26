package com.example.wiktor.lost_in_london;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Lvl2 extends AppCompatActivity {

    Button next;
    Button restart;
    Button back;

    ImageView image;

    Integer[] images = new Integer[]{

            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.wolf,
            R.drawable.bear,
            R.drawable.parrot,
            R.drawable.giraffe
    };

    MediaPlayer sound;

    Integer[] sounds = new Integer[]{

            R.raw.lion,
            R.raw.tiger,
            R.raw.wolf,
            R.raw.bear,
            R.raw.parrot,
            R.raw.giraffe
    };

    TextView sign;

    String[] signs = new String[]{

            "Lion",
            "Tiger",
            "Wolf",
            "Bear",
            "Parrot",
            "Giraffe"
    };


    Lvl1 zoo = new Lvl1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl2);

    }
}
