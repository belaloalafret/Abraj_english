package com.inet.Abraj_English;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.inet.myapplication.R;

public class Choices extends AppCompatActivity implements View.OnClickListener {

    ImageView one , two , three , four , five , six,
             seven , et , nine ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choices);


        //BrowseActivity d;

        one = (ImageView)findViewById(R.id.one);
        two = (ImageView)findViewById(R.id.two);
        three = (ImageView)findViewById(R.id.three);
        four = (ImageView)findViewById(R.id.four);
        five = (ImageView)findViewById(R.id.five);
        six = (ImageView)findViewById(R.id.six);
        seven = (ImageView)findViewById(R.id.seven);
        et = (ImageView)findViewById(R.id.et);
        nine = (ImageView)findViewById(R.id.nine);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        et.setOnClickListener(this);
        nine.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {

        getIntent().putExtra("result","-1");
        setResult(1,getIntent());

        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id)
        {
            case R.id.one:
                getIntent().putExtra("result","1");
                setResult(1,getIntent());
                break;
            case R.id.two:
                getIntent().putExtra("result", "2");
                setResult(1,getIntent());
                break;
            case R.id.three:
                getIntent().putExtra("result","3");
                setResult(1,getIntent());
                break;
            case R.id.four:
                getIntent().putExtra("result","4");
                setResult(1,getIntent());
                break;
            case R.id.five:
                getIntent().putExtra("result","5");
                setResult(1,getIntent());
                break;
            case R.id.six:
                getIntent().putExtra("result","6");
                setResult(1,getIntent());
                break;
            case R.id.seven:
                getIntent().putExtra("result","7");
                setResult(1,getIntent());
                break;
            case R.id.et:
                getIntent().putExtra("result","8");
                setResult(1,getIntent());
                break;
            case R.id.nine:
                getIntent().putExtra("result","9");
                setResult(1,getIntent());
                break;

        }

        finish();
    }
}
