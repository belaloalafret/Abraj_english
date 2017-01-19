package com.inet.Abraj_English;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.inet.Abraj_English.Managing.ConnectionMng;
import com.inet.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class Gaming extends AppCompatActivity implements View.OnFocusChangeListener, Response.ErrorListener, Response.Listener<String> {

    AdView mAdView;
    ConnectionMng connection;

    MediaPlayer mPlayer;

    String sol;

    Button check_sol;

    EditText item_1_1, item_1_2, item_1_3, item_1_4, item_1_5, item_1_6, item_1_7, item_1_8, item_1_9,
            item_2_1, item_2_2, item_2_3, item_2_4, item_2_5, item_2_6, item_2_7, item_2_8, item_2_9,
            item_3_1, item_3_2, item_3_3, item_3_4, item_3_5, item_3_6, item_3_7, item_3_8, item_3_9,
            item_4_1, item_4_2, item_4_3, item_4_4, item_4_5, item_4_6, item_4_7, item_4_8, item_4_9,
            item_5_1, item_5_2, item_5_3, item_5_4, item_5_5, item_5_6, item_5_7, item_5_8, item_5_9,
            item_6_1, item_6_2, item_6_3, item_6_4, item_6_5, item_6_6, item_6_7, item_6_8, item_6_9,
            item_7_1, item_7_2, item_7_3, item_7_4, item_7_5, item_7_6, item_7_7, item_7_8, item_7_9,
            item_8_1, item_8_2, item_8_3, item_8_4, item_8_5, item_8_6, item_8_7, item_8_8, item_8_9,
            item_9_1, item_9_2, item_9_3, item_9_4, item_9_5, item_9_6, item_9_7, item_9_8, item_9_9;

    EditText last_focus;


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {

        super.onResume();

        if (mAdView != null) {
            mAdView.resume();
        }

    }

    private void SetConnectionSettings() {


        connection = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_SUDOKO,
                this,
                this
        );

        connection.setRetryPolicy(new DefaultRetryPolicy(
                7000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(this).add(connection);

    }


    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();


        try {
            //mPlayer.prepare();
            mPlayer.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    InterstitialAd mInterstitialAd;

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        mInterstitialAd = new InterstitialAd(this);


        // set the ad unit ID
        mInterstitialAd.setAdUnitId("ca-app-pub-9618820882948570/5522269447");

        AdRequest adRequest1 = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest1);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });



        try {
            mPlayer = MediaPlayer.create(this, R.raw.music);
            mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
           // mPlayer.prepare();
           // mPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer arg0) {
                mPlayer.start();

            }
        });


        check_sol = (Button) findViewById(R.id.check_sol);
        item_1_1 = (EditText) findViewById(R.id.item_1_1);
        item_1_2 = (EditText) findViewById(R.id.item_1_2);
        item_1_3 = (EditText) findViewById(R.id.item_1_3);
        item_1_4 = (EditText) findViewById(R.id.item_1_4);
        item_1_5 = (EditText) findViewById(R.id.item_1_5);
        item_1_6 = (EditText) findViewById(R.id.item_1_6);
        item_1_7 = (EditText) findViewById(R.id.item_1_7);
        item_1_8 = (EditText) findViewById(R.id.item_1_8);
        item_1_9 = (EditText) findViewById(R.id.item_1_9);

        item_2_1 = (EditText) findViewById(R.id.item_2_1);
        item_2_2 = (EditText) findViewById(R.id.item_2_2);
        item_2_3 = (EditText) findViewById(R.id.item_2_3);
        item_2_4 = (EditText) findViewById(R.id.item_2_4);
        item_2_5 = (EditText) findViewById(R.id.item_2_5);
        item_2_6 = (EditText) findViewById(R.id.item_2_6);
        item_2_7 = (EditText) findViewById(R.id.item_2_7);
        item_2_8 = (EditText) findViewById(R.id.item_2_8);
        item_2_9 = (EditText) findViewById(R.id.item_2_9);


        item_3_1 = (EditText) findViewById(R.id.item_3_1);
        item_3_2 = (EditText) findViewById(R.id.item_3_2);
        item_3_3 = (EditText) findViewById(R.id.item_3_3);
        item_3_4 = (EditText) findViewById(R.id.item_3_4);
        item_3_5 = (EditText) findViewById(R.id.item_3_5);
        item_3_6 = (EditText) findViewById(R.id.item_3_6);
        item_3_7 = (EditText) findViewById(R.id.item_3_7);
        item_3_8 = (EditText) findViewById(R.id.item_3_8);
        item_3_9 = (EditText) findViewById(R.id.item_3_9);

        item_4_1 = (EditText) findViewById(R.id.item_4_1);
        item_4_2 = (EditText) findViewById(R.id.item_4_2);
        item_4_3 = (EditText) findViewById(R.id.item_4_3);
        item_4_4 = (EditText) findViewById(R.id.item_4_4);
        item_4_5 = (EditText) findViewById(R.id.item_4_5);
        item_4_6 = (EditText) findViewById(R.id.item_4_6);
        item_4_7 = (EditText) findViewById(R.id.item_4_7);
        item_4_8 = (EditText) findViewById(R.id.item_4_8);
        item_4_9 = (EditText) findViewById(R.id.item_4_9);

        item_5_1 = (EditText) findViewById(R.id.item_5_1);
        item_5_2 = (EditText) findViewById(R.id.item_5_2);
        item_5_3 = (EditText) findViewById(R.id.item_5_3);
        item_5_4 = (EditText) findViewById(R.id.item_5_4);
        item_5_5 = (EditText) findViewById(R.id.item_5_5);
        item_5_6 = (EditText) findViewById(R.id.item_5_6);
        item_5_7 = (EditText) findViewById(R.id.item_5_7);
        item_5_8 = (EditText) findViewById(R.id.item_5_8);
        item_5_9 = (EditText) findViewById(R.id.item_5_9);

        item_6_1 = (EditText) findViewById(R.id.item_6_1);
        item_6_2 = (EditText) findViewById(R.id.item_6_2);
        item_6_3 = (EditText) findViewById(R.id.item_6_3);
        item_6_4 = (EditText) findViewById(R.id.item_6_4);
        item_6_5 = (EditText) findViewById(R.id.item_6_5);
        item_6_6 = (EditText) findViewById(R.id.item_6_6);
        item_6_7 = (EditText) findViewById(R.id.item_6_7);
        item_6_8 = (EditText) findViewById(R.id.item_6_8);
        item_6_9 = (EditText) findViewById(R.id.item_6_9);

        item_7_1 = (EditText) findViewById(R.id.item_7_1);
        item_7_2 = (EditText) findViewById(R.id.item_7_2);
        item_7_3 = (EditText) findViewById(R.id.item_7_3);
        item_7_4 = (EditText) findViewById(R.id.item_7_4);
        item_7_5 = (EditText) findViewById(R.id.item_7_5);
        item_7_6 = (EditText) findViewById(R.id.item_7_6);
        item_7_7 = (EditText) findViewById(R.id.item_7_7);
        item_7_8 = (EditText) findViewById(R.id.item_7_8);
        item_7_9 = (EditText) findViewById(R.id.item_7_9);

        item_8_1 = (EditText) findViewById(R.id.item_8_1);
        item_8_2 = (EditText) findViewById(R.id.item_8_2);
        item_8_3 = (EditText) findViewById(R.id.item_8_3);
        item_8_4 = (EditText) findViewById(R.id.item_8_4);
        item_8_5 = (EditText) findViewById(R.id.item_8_5);
        item_8_6 = (EditText) findViewById(R.id.item_8_6);
        item_8_7 = (EditText) findViewById(R.id.item_8_7);
        item_8_8 = (EditText) findViewById(R.id.item_8_8);
        item_8_9 = (EditText) findViewById(R.id.item_8_9);

        item_9_1 = (EditText) findViewById(R.id.item_9_1);
        item_9_2 = (EditText) findViewById(R.id.item_9_2);
        item_9_3 = (EditText) findViewById(R.id.item_9_3);
        item_9_4 = (EditText) findViewById(R.id.item_9_4);
        item_9_5 = (EditText) findViewById(R.id.item_9_5);
        item_9_6 = (EditText) findViewById(R.id.item_9_6);
        item_9_7 = (EditText) findViewById(R.id.item_9_7);
        item_9_8 = (EditText) findViewById(R.id.item_9_8);
        item_9_9 = (EditText) findViewById(R.id.item_9_9);

        item_1_1.setInputType(InputType.TYPE_NULL);
        item_1_2.setInputType(InputType.TYPE_NULL);
        item_1_3.setInputType(InputType.TYPE_NULL);
        item_1_4.setInputType(InputType.TYPE_NULL);
        item_1_5.setInputType(InputType.TYPE_NULL);
        item_1_6.setInputType(InputType.TYPE_NULL);
        item_1_7.setInputType(InputType.TYPE_NULL);
        item_1_8.setInputType(InputType.TYPE_NULL);
        item_1_9.setInputType(InputType.TYPE_NULL);

        item_2_1.setInputType(InputType.TYPE_NULL);
        item_2_2.setInputType(InputType.TYPE_NULL);
        item_2_3.setInputType(InputType.TYPE_NULL);
        item_2_4.setInputType(InputType.TYPE_NULL);
        item_2_5.setInputType(InputType.TYPE_NULL);
        item_2_6.setInputType(InputType.TYPE_NULL);
        item_2_7.setInputType(InputType.TYPE_NULL);
        item_2_8.setInputType(InputType.TYPE_NULL);
        item_2_9.setInputType(InputType.TYPE_NULL);

        item_3_1.setInputType(InputType.TYPE_NULL);
        item_3_2.setInputType(InputType.TYPE_NULL);
        item_3_3.setInputType(InputType.TYPE_NULL);
        item_3_4.setInputType(InputType.TYPE_NULL);
        item_3_5.setInputType(InputType.TYPE_NULL);
        item_3_6.setInputType(InputType.TYPE_NULL);
        item_3_7.setInputType(InputType.TYPE_NULL);
        item_3_8.setInputType(InputType.TYPE_NULL);
        item_3_9.setInputType(InputType.TYPE_NULL);

        item_4_1.setInputType(InputType.TYPE_NULL);
        item_4_2.setInputType(InputType.TYPE_NULL);
        item_4_3.setInputType(InputType.TYPE_NULL);
        item_4_4.setInputType(InputType.TYPE_NULL);
        item_4_5.setInputType(InputType.TYPE_NULL);
        item_4_6.setInputType(InputType.TYPE_NULL);
        item_4_7.setInputType(InputType.TYPE_NULL);
        item_4_8.setInputType(InputType.TYPE_NULL);
        item_4_9.setInputType(InputType.TYPE_NULL);

        item_5_1.setInputType(InputType.TYPE_NULL);
        item_5_2.setInputType(InputType.TYPE_NULL);
        item_5_3.setInputType(InputType.TYPE_NULL);
        item_5_4.setInputType(InputType.TYPE_NULL);
        item_5_5.setInputType(InputType.TYPE_NULL);
        item_5_6.setInputType(InputType.TYPE_NULL);
        item_5_7.setInputType(InputType.TYPE_NULL);
        item_5_8.setInputType(InputType.TYPE_NULL);
        item_5_9.setInputType(InputType.TYPE_NULL);

        item_6_1.setInputType(InputType.TYPE_NULL);
        item_6_2.setInputType(InputType.TYPE_NULL);
        item_6_3.setInputType(InputType.TYPE_NULL);
        item_6_4.setInputType(InputType.TYPE_NULL);
        item_6_5.setInputType(InputType.TYPE_NULL);
        item_6_6.setInputType(InputType.TYPE_NULL);
        item_6_7.setInputType(InputType.TYPE_NULL);
        item_6_8.setInputType(InputType.TYPE_NULL);
        item_6_9.setInputType(InputType.TYPE_NULL);

        item_7_1.setInputType(InputType.TYPE_NULL);
        item_7_2.setInputType(InputType.TYPE_NULL);
        item_7_3.setInputType(InputType.TYPE_NULL);
        item_7_4.setInputType(InputType.TYPE_NULL);
        item_7_5.setInputType(InputType.TYPE_NULL);
        item_7_6.setInputType(InputType.TYPE_NULL);
        item_7_7.setInputType(InputType.TYPE_NULL);
        item_7_8.setInputType(InputType.TYPE_NULL);
        item_7_9.setInputType(InputType.TYPE_NULL);

        item_8_1.setInputType(InputType.TYPE_NULL);
        item_8_2.setInputType(InputType.TYPE_NULL);
        item_8_3.setInputType(InputType.TYPE_NULL);
        item_8_4.setInputType(InputType.TYPE_NULL);
        item_8_5.setInputType(InputType.TYPE_NULL);
        item_8_6.setInputType(InputType.TYPE_NULL);
        item_8_7.setInputType(InputType.TYPE_NULL);
        item_8_8.setInputType(InputType.TYPE_NULL);
        item_8_9.setInputType(InputType.TYPE_NULL);

        item_9_1.setInputType(InputType.TYPE_NULL);
        item_9_2.setInputType(InputType.TYPE_NULL);
        item_9_3.setInputType(InputType.TYPE_NULL);
        item_9_4.setInputType(InputType.TYPE_NULL);
        item_9_5.setInputType(InputType.TYPE_NULL);
        item_9_6.setInputType(InputType.TYPE_NULL);
        item_9_7.setInputType(InputType.TYPE_NULL);
        item_9_8.setInputType(InputType.TYPE_NULL);
        item_9_9.setInputType(InputType.TYPE_NULL);


        item_1_1.setOnFocusChangeListener(this);
        item_1_2.setOnFocusChangeListener(this);
        item_1_3.setOnFocusChangeListener(this);
        item_1_4.setOnFocusChangeListener(this);
        item_1_5.setOnFocusChangeListener(this);
        item_1_6.setOnFocusChangeListener(this);
        item_1_7.setOnFocusChangeListener(this);
        item_1_8.setOnFocusChangeListener(this);
        item_1_9.setOnFocusChangeListener(this);


      // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)‌​;

        item_2_1.setOnFocusChangeListener(this);
        item_2_2.setOnFocusChangeListener(this);
        item_2_3.setOnFocusChangeListener(this);
        item_2_4.setOnFocusChangeListener(this);
        item_2_5.setOnFocusChangeListener(this);
        item_2_6.setOnFocusChangeListener(this);
        item_2_7.setOnFocusChangeListener(this);
        item_2_8.setOnFocusChangeListener(this);
        item_2_9.setOnFocusChangeListener(this);

        item_3_1.setOnFocusChangeListener(this);
        item_3_2.setOnFocusChangeListener(this);
        item_3_3.setOnFocusChangeListener(this);
        item_3_4.setOnFocusChangeListener(this);
        item_3_5.setOnFocusChangeListener(this);
        item_3_6.setOnFocusChangeListener(this);
        item_3_7.setOnFocusChangeListener(this);
        item_3_8.setOnFocusChangeListener(this);
        item_3_9.setOnFocusChangeListener(this);

        item_4_1.setOnFocusChangeListener(this);
        item_4_2.setOnFocusChangeListener(this);
        item_4_3.setOnFocusChangeListener(this);
        item_4_4.setOnFocusChangeListener(this);
        item_4_5.setOnFocusChangeListener(this);
        item_4_6.setOnFocusChangeListener(this);
        item_4_7.setOnFocusChangeListener(this);
        item_4_8.setOnFocusChangeListener(this);
        item_4_9.setOnFocusChangeListener(this);


        item_5_1.setOnFocusChangeListener(this);
        item_5_2.setOnFocusChangeListener(this);
        item_5_3.setOnFocusChangeListener(this);
        item_5_4.setOnFocusChangeListener(this);
        item_5_5.setOnFocusChangeListener(this);
        item_5_6.setOnFocusChangeListener(this);
        item_5_7.setOnFocusChangeListener(this);
        item_5_8.setOnFocusChangeListener(this);
        item_5_9.setOnFocusChangeListener(this);

        item_6_1.setOnFocusChangeListener(this);
        item_6_2.setOnFocusChangeListener(this);
        item_6_3.setOnFocusChangeListener(this);
        item_6_4.setOnFocusChangeListener(this);
        item_6_5.setOnFocusChangeListener(this);
        item_6_6.setOnFocusChangeListener(this);
        item_6_7.setOnFocusChangeListener(this);
        item_6_8.setOnFocusChangeListener(this);
        item_6_9.setOnFocusChangeListener(this);

        item_7_1.setOnFocusChangeListener(this);
        item_7_2.setOnFocusChangeListener(this);
        item_7_3.setOnFocusChangeListener(this);
        item_7_4.setOnFocusChangeListener(this);
        item_7_5.setOnFocusChangeListener(this);
        item_7_6.setOnFocusChangeListener(this);
        item_7_7.setOnFocusChangeListener(this);
        item_7_8.setOnFocusChangeListener(this);
        item_7_9.setOnFocusChangeListener(this);

        item_8_1.setOnFocusChangeListener(this);
        item_8_2.setOnFocusChangeListener(this);
        item_8_3.setOnFocusChangeListener(this);
        item_8_4.setOnFocusChangeListener(this);
        item_8_5.setOnFocusChangeListener(this);
        item_8_6.setOnFocusChangeListener(this);
        item_8_7.setOnFocusChangeListener(this);
        item_8_8.setOnFocusChangeListener(this);
        item_8_9.setOnFocusChangeListener(this);

        item_9_1.setOnFocusChangeListener(this);
        item_9_2.setOnFocusChangeListener(this);
        item_9_3.setOnFocusChangeListener(this);
        item_9_4.setOnFocusChangeListener(this);
        item_9_5.setOnFocusChangeListener(this);
        item_9_6.setOnFocusChangeListener(this);
        item_9_7.setOnFocusChangeListener(this);
        item_9_8.setOnFocusChangeListener(this);
        item_9_9.setOnFocusChangeListener(this);

        check_sol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkSol())
                    startActivity(new Intent(Gaming.this ,GameResult.class));
                else
                    Toast.makeText(getApplicationContext(), "الحل غير صحيح", Toast.LENGTH_LONG).show();

            }
        });


        SetConnectionSettings();


    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {



        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if (hasFocus) {

            last_focus = (EditText) v;
            startActivityForResult(new Intent(this, Choices.class), 1);


        }

    }

    private boolean checkSol() {
        try {

            JSONArray puzzle = new JSONArray(sol);

            Log.e("lool 1",sol);
            boolean r1 = false, r2 = false, r3 = false, r4 = false, r5 = false, r6 = false, r7 = false, r8 = false, r9 = false;
            JSONArray row1 = puzzle.getJSONArray(0);
            JSONArray row2 = puzzle.getJSONArray(1);
            JSONArray row3 = puzzle.getJSONArray(2);
            JSONArray row4 = puzzle.getJSONArray(3);
            JSONArray row5 = puzzle.getJSONArray(4);
            JSONArray row6 = puzzle.getJSONArray(5);
            JSONArray row7 = puzzle.getJSONArray(6);
            JSONArray row8 = puzzle.getJSONArray(7);
            JSONArray row9 = puzzle.getJSONArray(8);
            Log.e("lool 2","#"+item_1_1.getText().toString().equals(row1.getString(0))+"#");
            if (
                    item_1_1.getText().toString().equals(row1.getString(0)) &&
                            item_1_2.getText().toString().equals(row1.getString(1)) &&
                            item_1_3.getText().toString().equals(row1.getString(2)) &&
                            item_1_4.getText().toString().equals(row1.getString(3)) &&
                            item_1_5.getText().toString().equals(row1.getString(4)) &&
                            item_1_6.getText().toString().equals(row1.getString(5)) &&
                            item_1_7.getText().toString().equals(row1.getString(6)) &&
                            item_1_8.getText().toString().equals(row1.getString(7)) &&
                            item_1_9.getText().toString().equals(row1.getString(8))

                    ) {
                r1 = true;
            }

            if (
                    item_2_1.getText().toString().equals(row2.getString(0)) &&
                            item_2_2.getText().toString().equals(row2.getString(1)) &&
                            item_2_3.getText().toString().equals(row2.getString(2)) &&
                            item_2_4.getText().toString().equals(row2.getString(3)) &&
                            item_2_5.getText().toString().equals(row2.getString(4)) &&
                            item_2_6.getText().toString().equals(row2.getString(5)) &&
                            item_2_7.getText().toString().equals(row2.getString(6)) &&
                            item_2_8.getText().toString().equals(row2.getString(7)) &&
                            item_2_9.getText().toString().equals(row2.getString(8))

                    ) {
                r2 = true;
            }

            if (
                    item_3_1.getText().toString().equals(row3.getString(0)) &&
                            item_3_2.getText().toString().equals(row3.getString(1)) &&
                            item_3_3.getText().toString().equals(row3.getString(2)) &&
                            item_3_4.getText().toString().equals(row3.getString(3)) &&
                            item_3_5.getText().toString().equals(row3.getString(4)) &&
                            item_3_6.getText().toString().equals(row3.getString(5)) &&
                            item_3_7.getText().toString().equals(row3.getString(6)) &&
                            item_3_8.getText().toString().equals(row3.getString(7)) &&
                            item_3_9.getText().toString().equals(row3.getString(8))

                    ) {
                r3 = true;
            }

            if (
                    item_4_1.getText().toString().toString().equals(row4.getString(0)) &&
                            item_4_2.getText().toString().toString().equals(row4.getString(1)) &&
                            item_4_3.getText().toString().toString().equals(row4.getString(2)) &&
                            item_4_4.getText().toString().toString().equals(row4.getString(3)) &&
                            item_4_5.getText().toString().toString().equals(row4.getString(4)) &&
                            item_4_6.getText().toString().toString().equals(row4.getString(5)) &&
                            item_4_7.getText().toString().toString().equals(row4.getString(6)) &&
                            item_4_8.getText().toString().toString().equals(row4.getString(7)) &&
                            item_4_9.getText().toString().toString().equals(row4.getString(8))

                    ) {
                r4 = true;
            }

            if (
                    item_5_1.getText().toString().equals(row5.getString(0)) &&
                            item_5_2.getText().toString().equals(row5.getString(1)) &&
                            item_5_3.getText().toString().equals(row5.getString(2)) &&
                            item_5_4.getText().toString().equals(row5.getString(3)) &&
                            item_5_5.getText().toString().equals(row5.getString(4)) &&
                            item_5_6.getText().toString().equals(row5.getString(5)) &&
                            item_5_7.getText().toString().equals(row5.getString(6)) &&
                            item_5_8.getText().toString().equals(row5.getString(7)) &&
                            item_5_9.getText().toString().equals(row5.getString(8))

                    ) {
                r5 = true;
            }

            if (
                    item_6_1.getText().toString().equals(row6.getString(0)) &&
                            item_6_2.getText().toString().equals(row6.getString(1)) &&
                            item_6_3.getText().toString().equals(row6.getString(2)) &&
                            item_6_4.getText().toString().equals(row6.getString(3)) &&
                            item_6_5.getText().toString().equals(row6.getString(4)) &&
                            item_6_6.getText().toString().equals(row6.getString(5)) &&
                            item_6_7.getText().toString().equals(row6.getString(6)) &&
                            item_6_8.getText().toString().equals(row6.getString(7)) &&
                            item_6_9.getText().toString().equals(row6.getString(8))

                    ) {
                r6 = true;
            }

            if (
                    item_7_1.getText().toString().equals(row7.getString(0)) &&
                            item_7_2.getText().toString().equals(row7.getString(1)) &&
                            item_7_3.getText().toString().equals(row7.getString(2)) &&
                            item_7_4.getText().toString().equals(row7.getString(3)) &&
                            item_7_5.getText().toString().equals(row7.getString(4)) &&
                            item_7_6.getText().toString().equals(row7.getString(5)) &&
                            item_7_7.getText().toString().equals(row7.getString(6)) &&
                            item_7_8.getText().toString().equals(row7.getString(7)) &&
                            item_7_9.getText().toString().equals(row7.getString(8))

                    ) {
                r7 = true;
            }

            if (
                    item_8_1.getText().toString().equals(row8.getString(0)) &&
                            item_8_2.getText().toString().equals(row8.getString(1)) &&
                            item_8_3.getText().toString().equals(row8.getString(2)) &&
                            item_8_4.getText().toString().equals(row8.getString(3)) &&
                            item_8_5.getText().toString().equals(row8.getString(4)) &&
                            item_8_6.getText().toString().equals(row8.getString(5)) &&
                            item_8_7.getText().toString().equals(row8.getString(6)) &&
                            item_8_8.getText().toString().equals(row8.getString(7)) &&
                            item_8_9.getText().toString().equals(row8.getString(8))

                    ) {
                r8 = true;
            }

            if (
                    item_9_1.getText().toString().equals(row9.getString(0)) &&
                            item_9_2.getText().toString().equals(row9.getString(1)) &&
                            item_9_3.getText().toString().equals(row9.getString(2)) &&
                            item_9_4.getText().toString().equals(row9.getString(3)) &&
                            item_9_5.getText().toString().equals(row9.getString(4)) &&
                            item_9_6.getText().toString().equals(row9.getString(5)) &&
                            item_9_7.getText().toString().equals(row9.getString(6)) &&
                            item_9_8.getText().toString().equals(row9.getString(7)) &&
                            item_9_9.getText().toString().equals(row9.getString(8))

                    ) {
                r9 = true;
            }

            Log.e("lool",r1+""+r2+r3+r4+r5+r6+r7+r8+r9);

            if (r1 && r2 && r3 && r4 && r5 && r6 && r7 && r8 && r9)
                return true;
            else
                return false;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

            Log.e("data", data.getStringExtra("result"));
            if (!data.getStringExtra("result").equals("-1"))
                last_focus.setText(data.getStringExtra("result"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Toast.makeText(this , "حدث خطأ في تحميل اللعبة , الرجاء المحاولة مرة أخرى ",Toast.LENGTH_LONG).show();


        error.printStackTrace();

    }

    @Override
    public void onResponse(String response) {


        Log.e("data", response);
        try {

            JSONObject json = new JSONObject(response);

            JSONArray puzzle = json.getJSONArray("puzzel");
            sol = json.getJSONArray("answer").toString();

            JSONArray row1 = puzzle.getJSONArray(0);
            JSONArray row2 = puzzle.getJSONArray(1);
            JSONArray row3 = puzzle.getJSONArray(2);
            JSONArray row4 = puzzle.getJSONArray(3);
            JSONArray row5 = puzzle.getJSONArray(4);
            JSONArray row6 = puzzle.getJSONArray(5);
            JSONArray row7 = puzzle.getJSONArray(6);
            JSONArray row8 = puzzle.getJSONArray(7);
            JSONArray row9 = puzzle.getJSONArray(8);

            if (!row1.getString(0).equals("0")) {
                item_1_1.setEnabled(false);
                item_1_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_1.setText(row1.getString(0));
            }
            if (!row1.getString(1).equals("0")) {
                item_1_2.setEnabled(false);
                item_1_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_2.setText(row1.getString(1));
            }
            if (!row1.getString(2).equals("0")) {
                item_1_3.setEnabled(false);
                item_1_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_3.setText(row1.getString(2));
            }
            if (!row1.getString(3).equals("0")) {
                item_1_4.setEnabled(false);
                item_1_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_4.setText(row1.getString(3));
            }
            if (!row1.getString(4).equals("0")) {
                item_1_5.setEnabled(false);
                item_1_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_5.setText(row1.getString(4));
            }
            if (!row1.getString(5).equals("0")) {
                item_1_6.setEnabled(false);
                item_1_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_6.setText(row1.getString(5));
            }
            if (!row1.getString(6).equals("0")) {
                item_1_7.setEnabled(false);
                item_1_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_7.setText(row1.getString(6));
            }
            if (!row1.getString(7).equals("0")) {
                item_1_8.setEnabled(false);
                item_1_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_8.setText(row1.getString(7));
            }
            if (!row1.getString(8).equals("0")) {
                item_1_9.setEnabled(false);
                item_1_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_1_9.setText(row1.getString(8));
            }

            if (!row2.getString(0).equals("0")) {
                item_2_1.setEnabled(false);
                item_2_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_1.setText(row2.getString(0));
            }
            if (!row2.getString(1).equals("0")) {
                item_2_2.setEnabled(false);
                item_2_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_2.setText(row2.getString(1));
            }
            if (!row2.getString(2).equals("0")) {
                item_2_3.setEnabled(false);
                item_2_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_3.setText(row2.getString(2));
            }
            if (!row2.getString(3).equals("0")) {
                item_2_4.setEnabled(false);
                item_2_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_4.setText(row2.getString(3));
            }
            if (!row2.getString(4).equals("0")) {
                item_2_5.setEnabled(false);
                item_2_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_5.setText(row2.getString(4));
            }
            if (!row2.getString(5).equals("0")) {
                item_2_6.setEnabled(false);
                item_2_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_6.setText(row2.getString(5));
            }
            if (!row2.getString(6).equals("0")) {
                item_2_7.setEnabled(false);
                item_2_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_7.setText(row2.getString(6));
            }
            if (!row2.getString(7).equals("0")) {
                item_2_8.setEnabled(false);
                item_2_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_8.setText(row2.getString(7));
            }
            if (!row2.getString(8).equals("0")) {
                item_2_9.setEnabled(false);
                item_2_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_2_9.setText(row2.getString(8));
            }

            if (!row3.getString(0).equals("0")) {
                item_3_1.setEnabled(false);
                item_3_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_1.setText(row3.getString(0));
            }
            if (!row3.getString(1).equals("0")) {
                item_3_2.setEnabled(false);
                item_3_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_2.setText(row3.getString(1));
            }
            if (!row3.getString(2).equals("0")) {
                item_3_3.setEnabled(false);
                item_3_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_3.setText(row3.getString(2));
            }
            if (!row3.getString(3).equals("0")) {
                item_3_4.setEnabled(false);
                item_3_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_4.setText(row3.getString(3));
            }
            if (!row3.getString(4).equals("0")) {
                item_3_5.setEnabled(false);
                item_3_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_5.setText(row3.getString(4));
            }
            if (!row3.getString(5).equals("0")) {
                item_3_6.setEnabled(false);
                item_3_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_6.setText(row3.getString(5));
            }
            if (!row3.getString(6).equals("0")) {
                item_3_7.setEnabled(false);
                item_3_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_7.setText(row3.getString(6));
            }
            if (!row3.getString(7).equals("0")) {
                item_3_8.setEnabled(false);
                item_3_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_8.setText(row3.getString(7));
            }
            if (!row3.getString(8).equals("0")) {
                item_3_9.setEnabled(false);
                item_3_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_3_9.setText(row3.getString(8));
            }


            if (!row4.getString(0).equals("0")) {
                item_4_1.setEnabled(false);
                item_4_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_1.setText(row4.getString(0));
            }
            if (!row4.getString(1).equals("0")) {
                item_4_2.setEnabled(false);
                item_4_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_2.setText(row4.getString(1));
            }
            if (!row4.getString(2).equals("0")) {
                item_4_3.setEnabled(false);
                item_4_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_3.setText(row4.getString(2));
            }
            if (!row4.getString(3).equals("0")) {
                item_4_4.setEnabled(false);
                item_4_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_4.setText(row4.getString(3));
            }
            if (!row4.getString(4).equals("0")) {
                item_4_5.setEnabled(false);
                item_4_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_5.setText(row4.getString(4));
            }
            if (!row4.getString(5).equals("0")) {
                item_4_6.setEnabled(false);
                item_4_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_6.setText(row4.getString(5));
            }
            if (!row4.getString(6).equals("0")) {
                item_4_7.setEnabled(false);
                item_4_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_7.setText(row4.getString(6));
            }
            if (!row4.getString(7).equals("0")) {
                item_4_8.setEnabled(false);
                item_4_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_8.setText(row4.getString(7));
            }
            if (!row4.getString(8).equals("0")) {
                item_4_9.setEnabled(false);
                item_4_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_4_9.setText(row4.getString(8));
            }

            if (!row5.getString(0).equals("0")) {
                item_5_1.setEnabled(false);
                item_5_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_1.setText(row5.getString(0));
            }
            if (!row5.getString(1).equals("0")) {
                item_5_2.setEnabled(false);
                item_5_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_2.setText(row5.getString(1));
            }
            if (!row5.getString(2).equals("0")) {
                item_5_3.setEnabled(false);
                item_5_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_3.setText(row5.getString(2));
            }
            if (!row5.getString(3).equals("0")) {
                item_5_4.setEnabled(false);
                item_5_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_4.setText(row5.getString(3));
            }
            if (!row5.getString(4).equals("0")) {
                item_5_5.setEnabled(false);
                item_5_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_5.setText(row5.getString(4));
            }
            if (!row5.getString(5).equals("0")) {
                item_5_6.setEnabled(false);
                item_5_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_6.setText(row5.getString(5));
            }
            if (!row5.getString(6).equals("0")) {
                item_5_7.setEnabled(false);
                item_5_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_7.setText(row5.getString(6));
            }
            if (!row5.getString(7).equals("0")) {
                item_5_8.setEnabled(false);
                item_5_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_8.setText(row5.getString(7));
            }
            if (!row5.getString(8).equals("0")) {
                item_5_9.setEnabled(false);
                item_5_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_5_9.setText(row5.getString(8));
            }

            if (!row6.getString(0).equals("0")) {
                item_6_1.setEnabled(false);
                item_6_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_1.setText(row6.getString(0));
            }
            if (!row6.getString(1).equals("0")) {
                item_6_2.setEnabled(false);
                item_6_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_2.setText(row6.getString(1));
            }
            if (!row6.getString(2).equals("0")) {
                item_6_3.setEnabled(false);
                item_6_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_3.setText(row6.getString(2));
            }
            if (!row6.getString(3).equals("0")) {
                item_6_4.setEnabled(false);
                item_6_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_4.setText(row6.getString(3));
            }
            if (!row6.getString(4).equals("0")) {
                item_6_5.setEnabled(false);
                item_6_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_5.setText(row6.getString(4));
            }
            if (!row6.getString(5).equals("0")) {
                item_6_6.setEnabled(false);
                item_6_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_6.setText(row6.getString(5));
            }
            if (!row6.getString(6).equals("0")) {
                item_6_7.setEnabled(false);
                item_6_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_7.setText(row6.getString(6));
            }
            if (!row6.getString(7).equals("0")) {
                item_6_8.setEnabled(false);
                item_6_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_8.setText(row6.getString(7));
            }
            if (!row6.getString(8).equals("0")) {
                item_6_9.setEnabled(false);
                item_6_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_6_9.setText(row6.getString(8));
            }

            if (!row7.getString(0).equals("0")) {
                item_7_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_1.setEnabled(false);
                item_7_1.setText(row7.getString(0));
            }
            if (!row7.getString(1).equals("0")) {
                item_7_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_2.setEnabled(false);
                item_7_2.setText(row7.getString(1));
            }
            if (!row7.getString(2).equals("0")) {
                item_7_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_3.setEnabled(false);
                item_7_3.setText(row7.getString(2));
            }
            if (!row7.getString(3).equals("0")) {
                item_7_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_4.setEnabled(false);
                item_7_4.setText(row7.getString(3));
            }
            if (!row7.getString(4).equals("0")) {
                item_7_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_5.setEnabled(false);
                item_7_5.setText(row7.getString(4));
            }
            if (!row7.getString(5).equals("0")) {
                item_7_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_6.setEnabled(false);
                item_7_6.setText(row7.getString(5));
            }
            if (!row7.getString(6).equals("0")) {
                item_7_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_7.setEnabled(false);
                item_7_7.setText(row7.getString(6));
            }
            if (!row7.getString(7).equals("0")) {
                item_7_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_8.setEnabled(false);
                item_7_8.setText(row7.getString(7));
            }
            if (!row7.getString(8).equals("0")) {
                item_7_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_7_9.setEnabled(false);
                item_7_9.setText(row7.getString(8));
            }

            if (!row8.getString(0).equals("0")) {
                item_8_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_1.setEnabled(false);
                item_8_1.setText(row8.getString(0));
            }
            if (!row8.getString(1).equals("0")) {
                item_8_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_2.setEnabled(false);
                item_8_2.setText(row8.getString(1));
            }
            if (!row8.getString(2).equals("0")) {
                item_8_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_3.setEnabled(false);
                item_8_3.setText(row8.getString(2));
            }
            if (!row8.getString(3).equals("0")) {
                item_8_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_4.setEnabled(false);
                item_8_4.setText(row8.getString(3));
            }
            if (!row8.getString(4).equals("0")) {
                item_8_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_5.setEnabled(false);
                item_8_5.setText(row8.getString(4));
            }
            if (!row8.getString(5).equals("0")) {
                item_8_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_6.setEnabled(false);
                item_8_6.setText(row8.getString(5));
            }
            if (!row8.getString(6).equals("0")) {
                item_8_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_7.setEnabled(false);
                item_8_7.setText(row8.getString(6));
            }
            if (!row8.getString(7).equals("0")) {
                item_8_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_8.setEnabled(false);
                item_8_8.setText(row8.getString(7));
            }
            if (!row8.getString(8).equals("0")) {
                item_8_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_8_9.setEnabled(false);
                item_8_9.setText(row8.getString(8));
            }

            if (!row9.getString(0).equals("0")) {
                item_9_1.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_1.setEnabled(false);
                item_9_1.setText(row9.getString(0));
            }
            if (!row9.getString(1).equals("0")) {
                item_9_2.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_2.setEnabled(false);
                item_9_2.setText(row9.getString(1));
            }
            if (!row9.getString(2).equals("0")) {
                item_9_3.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_3.setEnabled(false);
                item_9_3.setText(row9.getString(2));
            }
            if (!row9.getString(3).equals("0")) {
                item_9_4.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_4.setEnabled(false);
                item_9_4.setText(row9.getString(3));
            }
            if (!row9.getString(4).equals("0")) {
                item_9_5.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_5.setEnabled(false);
                item_9_5.setText(row9.getString(4));
            }
            if (!row9.getString(5).equals("0")) {
                item_9_6.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_6.setEnabled(false);
                item_9_6.setText(row9.getString(5));
            }
            if (!row9.getString(6).equals("0")) {
                item_9_7.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_7.setEnabled(false);
                item_9_7.setText(row9.getString(6));
            }
            if (!row9.getString(7).equals("0")) {
                item_9_8.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_8.setEnabled(false);
                item_9_8.setText(row9.getString(7));
            }
            if (!row9.getString(8).equals("0")) {
                item_9_9.setEnabled(false);
                item_9_9.setBackgroundColor(getResources().getColor(R.color.textColorPrimary));
                item_9_9.setText(row9.getString(8));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
