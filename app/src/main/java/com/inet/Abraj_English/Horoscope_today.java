package com.inet.Abraj_English;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.inet.myapplication.R;


public class Horoscope_today extends AppCompatActivity {


    private Toolbar toolbar;
    Button today_wisdom, Joke_of_the_Day, which_i_read_and_liked, happened_on_this_day;
    AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horoscope_today);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        happened_on_this_day = (Button) findViewById(R.id.Happened_on_this_day);
        today_wisdom = (Button) findViewById(R.id.today_wisdom);
        which_i_read_and_liked = (Button) findViewById(R.id.which_i_read_and_liked);
        Joke_of_the_Day = (Button) findViewById(R.id.Joke_of_the_Day);

        toolbar.setTitle(this.getResources().getString(R.string.cat_5));


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.windowBackground));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        happened_on_this_day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.postfromhistory.com"));
                startActivity(browserIntent);
            }
        });


        today_wisdom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.context, Today_wisdom.class);
                startActivity(i);
            }
        });

        which_i_read_and_liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.context, Which_I_read_and_liked.class);
                startActivity(i);
            }
        });

        Joke_of_the_Day.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.context, Joke_of_the_Day.class);
                startActivity(i);
            }
        });

    }


}
