package com.example.displayjoke;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_jokes);
        String joke = getIntent().getStringExtra("check");

        TextView jokeView = (TextView) findViewById(R.id.jokeTextView);
        jokeView.setText(joke);



    }
}

//TODO Add UPactionEnabled
