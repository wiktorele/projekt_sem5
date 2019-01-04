package com.example.wiktor.lost_in_london;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Zoo extends Activity {

    Button next;
    Button restart;
    Button back;

    ImageView image;

    MediaPlayer sound;

    TextView sign, name;

    Integer[] images = new Integer[]{

            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.wolf,
    };

    Integer[] sounds = new Integer[]{

            R.raw.lion,
            R.raw.tiger,
            R.raw.wolf,
    };

    String[] signs = new String[]{

            "lion",
            "tiger",
            "wolf",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);

        name = (TextView) findViewById(R.id.name);

        image = (ImageView) findViewById(R.id.image);

        next = (Button) findViewById(R.id.next);

        back = (Button) findViewById(R.id.back);

        restart = (Button) findViewById(R.id.restart);

        sign = (TextView) findViewById(R.id.sign);

        name.setText("Zoo");

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

                sound = MediaPlayer.create(Zoo.this, sounds[i]);
                sound.start();

                sign.setText(signs[i]);

                i++;
            }else{

                Intent intent = new Intent(Zoo.this, Zoo2.class);
                startActivity(intent);
            }
        }
    };

    View.OnClickListener backward = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Zoo.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Zoo.this, Zoo.class);
            startActivity(intent);
        }
    };
}
