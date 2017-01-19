package com.inet.Abraj_English;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.inet.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import cn.jeesoft.widget.pickerview.CharacterPickerView;

/**
 * Created by DELL on 06/04/2016.
 */
public class ZodicCompatibility  extends AppCompatActivity {

    CharacterPickerView pickerView ;
    ImageView img1, img2;
    TextView compTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.zodic_comb);

        pickerView = (CharacterPickerView)findViewById(R.id.character_picker);
        img1 = (ImageView)findViewById(R.id.vers1);
        img2 = (ImageView)findViewById(R.id.vers2);
        compTxt = (TextView)findViewById(R.id.zodic_comp_text);


        Typeface typface= Typeface.createFromAsset(getAssets(), "fonts/font-arabic.ttf");
       // compTxt.setTypeface(typface);

        List<String> d = new ArrayList<>();
        d.add(getString(R.string.horoscope_title_1));
        d.add(getString(R.string.horoscope_title_2));
        d.add(getString(R.string.horoscope_title_3));
        d.add(getString(R.string.horoscope_title_4));
        d.add(getString(R.string.horoscope_title_5));
        d.add(getString(R.string.horoscope_title_6));
        d.add(getString(R.string.horoscope_title_7));
        d.add(getString(R.string.horoscope_title_8));
        d.add(getString(R.string.horoscope_title_9));
        d.add(getString(R.string.horoscope_title_10));
        d.add(getString(R.string.horoscope_title_11));
        d.add(getString(R.string.horoscope_title_12));



        List<List<String>> d1 = new ArrayList<>();
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);
        d1.add(d);


        pickerView.setPicker(d, d1);

        AdView mAdView = (AdView)findViewById(R.id.adView_comp_zodic);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        pickerView.setOnOptionChangedListener(new CharacterPickerView.OnOptionChangedListener() {
            @Override
            public void onOptionChanged(CharacterPickerView view, int option1, int option2, int option3) {
                Log.e("test", option1 + "," + option2 + "," + option3);
                setImages(option1 , option2);
            }
        });
    }
    void setImages(int op1 , int op2)
    {
        switch (op1)
        {
            case 0:
                img1.setImageResource(R.drawable.img1);
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img1_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img1_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img1_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img1_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img1_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img1_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img1_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img1_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img1_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img1_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img1_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img1_12));
                        break;

                }
                break;
            case 1:
                img1.setImageResource(R.drawable.img2);

                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img2_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img2_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img2_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img2_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img2_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img2_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img2_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img2_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img2_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img2_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img2_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img2_12));
                        break;

                }

                break;
            case 2:
                img1.setImageResource(R.drawable.img3);
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img3_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img3_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img3_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img3_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img3_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img3_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img3_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img3_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img3_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img3_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img3_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img3_12));
                        break;

                }
                break;
            case 3:
                img1.setImageResource(R.drawable.img4);
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img4_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img4_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img4_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img4_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img4_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img4_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img4_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img4_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img4_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img4_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img4_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img4_12));
                        break;

                }
                break;
            case 4:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img5_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img5_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img5_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img5_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img5_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img5_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img5_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img5_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img5_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img5_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img5_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img5_12));
                        break;

                }
                img1.setImageResource(R.drawable.img5);
                break;
            case 5:
                img1.setImageResource(R.drawable.img6);
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img6_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img6_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img6_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img6_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img6_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img6_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img6_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img6_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img6_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img6_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img6_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img6_12));
                        break;

                }
                break;
            case 6:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img7_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img7_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img7_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img7_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img7_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img7_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img7_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img7_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img7_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img7_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img7_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img7_12));
                        break;

                }
                img1.setImageResource(R.drawable.img7);
                break;
            case 7:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img8_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img8_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img8_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img8_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img8_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img8_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img8_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img8_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img8_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img8_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img8_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img8_12));
                        break;

                }
                img1.setImageResource(R.drawable.img8);
                break;
            case 8:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img9_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img9_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img9_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img9_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img9_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img9_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img9_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img9_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img9_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img9_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img9_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img9_12));
                        break;

                }
                img1.setImageResource(R.drawable.img9);
                break;
            case 9:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img10_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img10_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img10_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img10_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img10_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img10_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img10_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img10_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img10_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img10_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img10_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img10_12));
                        break;

                }
                img1.setImageResource(R.drawable.img10);
                break;
            case 10:
                img1.setImageResource(R.drawable.img11);
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img11_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img11_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img11_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img11_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img11_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img11_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img11_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img11_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img11_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img11_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img11_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img11_12));
                        break;

                }
                break;
            case 11:
                switch (op2)
                {
                    case 0:
                        compTxt.setText(getString(R.string.img12_1));
                        break;
                    case 1:
                        compTxt.setText(getString(R.string.img12_2));
                        break;
                    case 2:
                        compTxt.setText(getString(R.string.img12_3));
                        break;
                    case 3:
                        compTxt.setText(getString(R.string.img12_4));
                        break;
                    case 4:
                        compTxt.setText(getString(R.string.img12_5));
                        break;
                    case 5:
                        compTxt.setText(getString(R.string.img12_6));
                        break;
                    case 6:
                        compTxt.setText(getString(R.string.img12_7));
                        break;
                    case 7:
                        compTxt.setText(getString(R.string.img12_8));
                        break;
                    case 8:
                        compTxt.setText(getString(R.string.img12_9));
                        break;
                    case 9:
                        compTxt.setText(getString(R.string.img12_10));
                        break;
                    case 10:
                        compTxt.setText(getString(R.string.img12_11));
                        break;
                    case 11:
                        compTxt.setText(getString(R.string.img12_12));
                        break;

                }
                img1.setImageResource(R.drawable.img12);
                break;

        }

        // img2

        switch (op2)
        {
            case 0:
                img2.setImageResource(R.drawable.img1);
                break;
            case 1:
                img2.setImageResource(R.drawable.img2);
                break;
            case 2:
                img2.setImageResource(R.drawable.img3);
                break;
            case 3:
                img2.setImageResource(R.drawable.img4);
                break;
            case 4:
                img2.setImageResource(R.drawable.img5);
                break;
            case 5:
                img2.setImageResource(R.drawable.img6);
                break;
            case 6:
                img2.setImageResource(R.drawable.img7);
                break;
            case 7:
                img2.setImageResource(R.drawable.img8);
                break;
            case 8:
                img2.setImageResource(R.drawable.img9);
                break;
            case 9:
                img2.setImageResource(R.drawable.img10);
                break;
            case 10:
                img2.setImageResource(R.drawable.img11);
                break;
            case 11:
                img2.setImageResource(R.drawable.img12);
                break;

        }
    }


}
