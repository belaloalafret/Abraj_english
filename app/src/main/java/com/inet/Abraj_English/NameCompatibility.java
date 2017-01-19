package com.inet.Abraj_English;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.inet.Abraj_English.Utils.Constant;
import com.inet.myapplication.R;

import java.math.BigDecimal;

/**
 * Created by Ahmad Al-ammar on 28/02/2016.
 */

public class NameCompatibility extends AppCompatActivity implements Animation.AnimationListener {

    EditText name1 , name2;
    Button chk_comp;
    Animation animRotate;
    InterstitialAd mInterstitialAd;

    public int getValue(char alpha)
    {
        for (int i=0; i<Constant.ALPHAPET.size();i++)
        {
            if (Constant.ALPHAPET.get(i).alpha == alpha )
                return Constant.ALPHAPET.get(i).value;
        }

        return 0;
    }

    String getComp()
    {
        String str1 = name1.getText().toString();
        String str2 = name2.getText().toString();

        int sum1=0 , sum2 =0 ;

        for (int i=0 ; i<str1.length();i++)
        {
            sum1 += getValue(str1.charAt(i));
        }

        for (int i=0;i<str2.length();i++)
        {
            sum2 += getValue(str2.charAt(i));
        }


        double finalesum = sum1 + sum2 + 7;

        double n2 = finalesum / 9;

        BigDecimal result = new BigDecimal(n2 % 1);

        int finalResult = (int)(result.floatValue()*9);
        Log.e("Value of Float", finalResult + " n2 = " + n2 + " result = " + result);
        switch (finalResult)
        {
            case 0:
                return getString(R.string.comp10);
            case 1:
                return getString(R.string.comp1);
            case 2:
                return getString(R.string.comp2);
            case 3:
                return getString(R.string.comp3);
            case 4:
                return getString(R.string.comp4);
            case 5:
                return getString(R.string.comp5);
            case 6:
                return getString(R.string.comp6);
            case 7:
                return getString(R.string.comp7);
            case 8:
                return getString(R.string.comp8);
            case 9:
                return getString(R.string.comp9);

        }

        return "";

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.name_compatibility);

        name1 = (EditText)findViewById(R.id.name1);
        name2 = (EditText)findViewById(R.id.name2);
        chk_comp = (Button)findViewById(R.id.chk_comp1);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.rotate);


        // set animation listener
        animRotate.setAnimationListener(this);



        AdView mAdView = (AdView)findViewById(R.id.adView_chaina_game2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        chk_comp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (name1.getText().toString().isEmpty()) {
                    name1.setError(MainActivity.context.getResources().getString(R.string.Please_Fill_This_Field));
                    return;
                }
                if (name2.getText().toString().isEmpty()) {
                    name2.setError(MainActivity.context.getResources().getString(R.string.Please_Fill_This_Field));
                   return;
                }


                Toast.makeText(getBaseContext(), getComp(), Toast.LENGTH_LONG).show();

            }
        });


    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getBaseContext(), getComp(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
