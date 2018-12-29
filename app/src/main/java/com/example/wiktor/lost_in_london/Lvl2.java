package com.example.wiktor.lost_in_london;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lvl2 extends AppCompatActivity {

    String firstImageName, secondImageName, thirdImageName;
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

            "lion",
            "tiger",
            "wolf",
            "bear",
            "parrot",
            "giraffe"
    };

    ImageView image1, image2, image3;

    TextView sign1, sign2, sign3, text1, text2, text3;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl2);

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

        ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i < 6; ++i) number.add(i);
        Collections.shuffle(number);

        r = new Random();

        //i = r.nextInt(6);
        image1.setImageResource(images[number.get(0)]);
        image2.setImageResource(images[number.get(1)]);
        image3.setImageResource(images[number.get(2)]);

        firstImageName = getResources().getResourceEntryName(images[number.get(0)]);
        secondImageName = getResources().getResourceEntryName(images[number.get(1)]);
        thirdImageName = getResources().getResourceEntryName(images[number.get(2)]);

        do {

            text1.setText(signs[number.get(r.nextInt(3))]);
            text2.setText(signs[number.get(r.nextInt(3))]);
            text3.setText(signs[number.get(r.nextInt(3))]);

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

            Intent intent = new Intent(Lvl2.this, MenuActivity.class);
            startActivity(intent);
        }
    };

    View.OnClickListener re = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(Lvl2.this, Lvl2.class);
            startActivity(intent);
        }
    };

    View.OnClickListener forward = new View.OnClickListener() {

        int i = 0;

        public Drawable GetImage(Context c, String ImageName){
            return c.getResources().getDrawable(c.getResources().getIdentifier(ImageName, signs[i], c.getPackageName()));
        }

        @Override
        public void onClick(View v) {

            if(sign1.getText().toString().equals(firstImageName) && sign2.getText().toString().equals(secondImageName) && sign3.getText().toString().equals(thirdImageName)){

                Intent intent = new Intent(Lvl2.this, Lvl3.class);
                startActivity(intent);
            }else{

                Intent intent = new Intent(Lvl2.this, Lvl2.class);
                startActivity(intent);
            }
        }
    };

}
