package com.example.wiktor.lost_in_london;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Restaurant3 extends AppCompatActivity {

    ImageView check;
    Button next;
    Button restart;
    Button back;

    ImageView image;

    MediaPlayer sound;

    TextView sign;

    Integer[] images = new Integer[]{

            R.drawable.cheese,
            R.drawable.chicken,
            R.drawable.pancake,
    };

    Integer[] sounds = new Integer[]{

            R.raw.cheese,
            R.raw.chicken,
            R.raw.pancake,
    };

    String[] signs = new String[]{

            "cheese",
            "chicken",
            "pancake",
    };

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo3);

        check = (ImageView) findViewById(R.id.check);

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

            Intent intent = new Intent(Restaurant3.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Restaurant3.this, Restaurant3.class);
            startActivity(intent);
        }
    };

    View.OnClickListener forward = new View.OnClickListener() {

        int i = 0;

        @Override
        public void onClick(View v) {

            if (sign.getText().toString().equals(signs[i])){

                check.setAlpha(255);
                check.setImageResource(R.drawable.correct);
                startAnim();

                sound = MediaPlayer.create(Restaurant3.this, R.raw.correct);
                sound.start();

                if(i < (images.length - 1)) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            i++;
                            check.setAlpha(0);
                            image.setImageResource(images[i]);
                            sign.setText("");
                        }
                    }, 1200);
                }else if(i >= (images.length - 1)){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            Intent intent = new Intent(Restaurant3.this, MenuActivity.class);
                            startActivity(intent);
                        }
                    }, 1200);

                }

            }else{

                check.setAlpha(255);
                check.setImageResource(R.drawable.wrong);
                startAnim();

                sound = MediaPlayer.create(Restaurant3.this, R.raw.wrong);
                sound.start();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        check.setAlpha(0);
                    }
                }, 2000);
            }
        }
        private void startAnim(){

            Animation alpha = new AlphaAnimation(1f, 0f);
            alpha.setDuration(2000);
            check.startAnimation(alpha);
        }
    };
}
