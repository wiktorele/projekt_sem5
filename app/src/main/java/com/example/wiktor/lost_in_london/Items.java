package com.example.wiktor.lost_in_london;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Items {

    Integer imageLion = R.drawable.lion;
    Integer soundLion = R.raw.lion;
    String signLion = "Lion";

    Integer imageWolf = R.drawable.wolf;
    Integer soundWolf = R.raw.wolf;
    String signWolf = "Wolf";


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

            "Lion",
            "Tiger",
            "Wolf",
            "Bear",
            "Parrot",
            "Giraffe"
    };

    Items(Integer image, Integer sound, String sign){

    }

}
