package com.example.wiktor.lost_in_london;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button zoo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        zoo = (Button) findViewById(R.id.zoo);


        zoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Lvl1 x = new Lvl1();

                Intent intent = new Intent(MenuActivity.this, x.getClass());
                startActivity(intent);
            }
        });
    }
}
