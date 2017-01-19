package com.inet.Abraj_English;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.inet.Abraj_English.Helper.SessionManager;
import com.inet.myapplication.R;

import java.util.Calendar;
import java.util.Random;

public class luck_today extends AppCompatActivity {

    TextView luck_title;
    private Handler customHandler = new Handler();
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    private long startTime = 0L;
    Random random = new Random();
    int min = 1  , max = 10 , value ;
    InterstitialAd mInterstitialAd;
    SessionManager session;


    private void share_with_FB()
    {

        FacebookSdk.sdkInitialize(getApplicationContext());

        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        // this part is optional

        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {

            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

        String txt =luck_title.getText().toString() + "حظك اليوم هو بنسبة ";
        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentTitle("حظك اليوم")
                .setContentDescription(
                        txt)
                .setContentUrl(Uri.parse("http://www.2dayhoroscope.com"))
                .build();

        if (ShareDialog.canShow(ShareLinkContent.class)) {

            shareDialog.show(linkContent);

        }
        MessageDialog.show(this, linkContent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_today);

        session = new SessionManager(this);
        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id_chance_today));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();

            }
        });

        luck_title = (TextView)findViewById(R.id.luck_num);
        startTime = SystemClock.uptimeMillis();
        value = random.nextInt(max - min + 1) + min;
        customHandler.postDelayed(updateTimerThread, 0);


        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private Runnable updateTimerThread = new Runnable() {
        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
            updatedTime = timeSwapBuff + timeInMilliseconds;
            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;

            int milliseconds = (int) (updatedTime % 1000);

            luck_title.setText(""

                    + String.format("%03d", milliseconds));
            if (secs < value) {
                customHandler.postDelayed(this, 0);
            }
            else {

                Calendar c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                if (session.getDate()<day)
                {
                    session.setDate(day);
                    session.setLogin(""+(value*10));
                    luck_title.setText("" + (value * 10));
                }
                else
                {

                    luck_title.setText(session.getChance());

                }

            }
        }

    };

}
