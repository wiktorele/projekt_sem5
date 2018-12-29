package com.example.wiktor.lost_in_london;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Lvl3 extends AppCompatActivity {

    Button next;
    Button restart;
    Button back;

    ImageView image;

    MediaPlayer sound;

    TextView sign;

    Integer[] images = new Integer[]{

            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.wolf,
            R.drawable.bear,
            R.drawable.parrot,
            R.drawable.giraffe
    };

    Integer[] sounds = new Integer[]{

            R.raw.lion,
            R.raw.tiger,
            R.raw.wolf,
            R.raw.bear,
            R.raw.parrot,
            R.raw.giraffe
    };

    String[] signs = new String[]{

            "lion",
            "tiger",
            "wolf",
            "bear",
            "parrot",
            "giraffe"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl3);

        image = (ImageView) findViewById(R.id.image);

        next = (Button) findViewById(R.id.next);

        back = (Button) findViewById(R.id.back);

        restart = (Button) findViewById(R.id.restart);

        sign = (EditText) findViewById(R.id.sign);

        next.setOnClickListener(forward);

        back.setOnClickListener(backward);

        restart.setOnClickListener(re);

        image.setImageResource(images[0]);
    }

    View.OnClickListener backward = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Lvl3.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Lvl3.this, Lvl3.class);
            startActivity(intent);
        }
    };

    View.OnClickListener forward = new View.OnClickListener() {

        int i = 1;
        //String editText = sign.getText().toString();

        @Override
        public void onClick(View v) {

            if (sign.getText().toString().equals(signs[i - 1]) && i < images.length){

                image.setImageResource(images[i]);

                sign.setText("");

                i++;
            }else if (i >= images.length){

                Intent intent = new Intent(Lvl3.this, MenuActivity.class);
                startActivity(intent);

            }else{

                sound = MediaPlayer.create(Lvl3.this, sounds[i]);
                sound.start();
            }
        }
    };
}
