package com.example.afinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button goRPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goRPS = (Button) findViewById(R.id.rpsbtn);
        goRPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRPSGame();
            }

        });


    }
    public void openRPSGame(){
        Intent intent = new Intent(MainActivity.this, Rock.class);
        startActivity(intent);
    }
}