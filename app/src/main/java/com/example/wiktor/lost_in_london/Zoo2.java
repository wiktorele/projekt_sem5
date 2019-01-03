package com.example.wiktor.lost_in_london;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Zoo2 extends AppCompatActivity {

    int image4, image5, image6;
    ImageView check;
    Button next;
    Button restart;
    Button back;

    Integer[] images = new Integer[]{

            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.wolf,
    };

    MediaPlayer sound;

    Integer[] sounds = new Integer[]{

            R.raw.lion,
            R.raw.tiger,
            R.raw.wolf,
    };

    TextView sign;

    String[] signs = new String[]{

            "lion",
            "tiger",
            "wolf",
    };

    ImageView image1, image2, image3;

    TextView sign1, sign2, sign3, text1, text2, text3;

    String firstImageName, secondImageName, thirdImageName;

    Random r;

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo2);

        check = findViewById(R.id.check);
        sign1 = findViewById(R.id.sign_1);
        sign2 = findViewById(R.id.sign_2);
        sign3 = findViewById(R.id.sign_3);
        text1 = findViewById(R.id.text_1);
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text_3);
        image1 = findViewById(R.id.image_1);
        image2 = findViewById(R.id.image_2);
        image3 = findViewById(R.id.image_3);
        back = findViewById(R.id.back);
        restart = findViewById(R.id.restart);
        next = findViewById(R.id.next);

        text1.setOnLongClickListener(longClickListener);
        text2.setOnLongClickListener(longClickListener);
        text3.setOnLongClickListener(longClickListener);

        sign1.setOnDragListener(dragListener1);
        sign2.setOnDragListener(dragListener2);
        sign3.setOnDragListener(dragListener3);

        back.setOnClickListener(backward);
        restart.setOnClickListener(re);

        r = new Random();

        image1.setImageResource(images[0]);
        image2.setImageResource(images[1]);
        image3.setImageResource(images[2]);

        firstImageName = getResources().getResourceEntryName(images[0]);
        secondImageName = getResources().getResourceEntryName(images[1]);
        thirdImageName = getResources().getResourceEntryName(images[2]);

        do {

            text1.setText(signs[r.nextInt(3)]);
            text2.setText(signs[r.nextInt(3)]);
            text3.setText(signs[r.nextInt(3)]);

        }while(text1.getText() == text2.getText() || text1.getText() == text3.getText() || text2.getText() == text3.getText());

        next.setOnClickListener(forward);
    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data, shadowBuilder, v, 0);
            return true;
        }
    };

    View.OnDragListener dragListener1 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            View view = (View) event.getLocalState();

            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:

                    if (view.getId() == R.id.text_1){

                        sign1.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign1.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign1.setText(text3.getText());

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    if (view.getId() == R.id.text_1){

                        sign1.setText("Image 1");

                    }else if (view.getId() == R.id.text_2){

                        sign1.setText("Image 1");

                    }else if (view.getId() == R.id.text_3){

                        sign1.setText("Image 1");

                    }
                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.text_1){

                        sign1.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign1.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign1.setText(text3.getText());

                    }
                    break;

            }

            return true;
        }
    };

    View.OnDragListener dragListener2 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            final View view = (View) event.getLocalState();

            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:

                    if (view.getId() == R.id.text_1){

                        sign2.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign2.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign2.setText(text3.getText());

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    if (view.getId() == R.id.text_1){

                        sign2.setText("Image 2");

                    }else if (view.getId() == R.id.text_2){

                        sign2.setText("Image 2");

                    }else if (view.getId() == R.id.text_3){

                        sign2.setText("Image 2");

                    }
                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.text_1){

                        sign2.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign2.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign2.setText(text3.getText());

                    }
                    break;

            }

            return true;
        }
    };

    View.OnDragListener dragListener3 = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();

            final View view = (View) event.getLocalState();

            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:

                    if (view.getId() == R.id.text_1){

                        sign3.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign3.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign3.setText(text3.getText());

                    }
                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    if (view.getId() == R.id.text_1){

                        sign3.setText("Image 3");

                    }else if (view.getId() == R.id.text_2){

                        sign3.setText("Image 3");

                    }else if (view.getId() == R.id.text_3){

                        sign3.setText("Image 3");

                    }
                    break;
                case DragEvent.ACTION_DROP:

                    if (view.getId() == R.id.text_1){

                        sign3.setText(text1.getText());

                    }else if (view.getId() == R.id.text_2){

                        sign3.setText(text2.getText());

                    }else if (view.getId() == R.id.text_3){

                        sign3.setText(text3.getText());

                    }
                    break;

            }

            return true;
        }
    };

    View.OnClickListener backward = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Zoo2.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Zoo2.this, Zoo2.class);
            startActivity(intent);
        }
    };

    View.OnClickListener forward = new View.OnClickListener() {

        int i = 0;

        @Override
        public void onClick(View v) {

            if(sign1.getText().toString().equals(firstImageName) && sign2.getText().toString().equals(secondImageName) && sign3.getText().toString().equals(thirdImageName)){

                i = i + 3;

                if(i < images.length){

                    sound = MediaPlayer.create(Zoo2.this, R.raw.correct);
                    sound.start();

                    check.setAlpha(255);
                    check.setImageResource(R.drawable.correct);
                    startAnim();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            sign1.setText("Image 1");
                            sign2.setText("Image 2");
                            sign3.setText("Image 3");

                            image1.setImageResource(images[i]);
                            image2.setImageResource(images[i + 1]);
                            image3.setImageResource(images[i + 2]);

                            firstImageName = getResources().getResourceEntryName(images[i]);
                            secondImageName = getResources().getResourceEntryName(images[i + 1]);
                            thirdImageName = getResources().getResourceEntryName(images[i + 2]);

                            do {

                                text1.setText(signs[r.nextInt(i)+3]);
                                text2.setText(signs[r.nextInt(i)+3]);
                                text3.setText(signs[r.nextInt(i)+3]);

                            }while(text1.getText() == text2.getText() || text1.getText() == text3.getText() || text2.getText() == text3.getText());

                            check.setAlpha(0);
                        }
                    }, 1200);
                }else{

                    sound = MediaPlayer.create(Zoo2.this, R.raw.correct);
                    sound.start();

                    check.setAlpha(255);
                    check.setImageResource(R.drawable.correct);
                    startAnim();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            check.setAlpha(0);
                            Intent intent = new Intent(Zoo2.this, Zoo3.class);
                            startActivity(intent);
                        }
                    }, 1200);
                }

            }else{

                sound = MediaPlayer.create(Zoo2.this, R.raw.wrong);
                sound.start();

                check.setAlpha(255);
                check.setImageResource(R.drawable.wrong);
                startAnim();

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
