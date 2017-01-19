package com.inet.Abraj_English;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.adamrosenfield.wordswithcrosses.BrowseActivity;
import com.inet.myapplication.R;

public class Tsali extends AppCompatActivity {

    ImageView sudou , crossword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsali);

        sudou = (ImageView)findViewById(R.id.sudoku);
        crossword = (ImageView)findViewById(R.id.crosswords);

        sudou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tsali.this , Gaming.class));
            }
        });

        crossword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Tsali.this , BrowseActivity.class));

            }
        });

    }

}
