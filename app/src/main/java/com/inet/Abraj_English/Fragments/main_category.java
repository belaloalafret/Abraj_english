package com.inet.Abraj_English.Fragments;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.inet.Abraj_English.Daily_Abraj;
import com.inet.Abraj_English.MainActivity;
import com.inet.Abraj_English.NameCompatibility;
import com.inet.Abraj_English.Tsali;
import com.inet.Abraj_English.Horoscope_today;
import com.inet.Abraj_English.ZodicCompatibility;
import com.inet.Abraj_English.luck_today;
import com.inet.myapplication.R;

/**
 * Created by DELL on 28/03/2016.
 */
public class main_category extends Fragment implements View.OnClickListener {


    AdView mAdView;
    Button daily_zodic_btn, your_chance_today, game_btn_1, game_btn_2, game_btn_3, game_btn_4;
    private String[] _animationList = {"fade", "flipHorizontal", "flipVertical", "disappearTopLeft", "appearTopLeft", "appearBottomRight", "disappearBottomRight", "unzoom"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.main_category, container, false);

        daily_zodic_btn = (Button) view.findViewById(R.id.brjak_today);
        your_chance_today = (Button) view.findViewById(R.id.your_chance_today);
        game_btn_1 = (Button) view.findViewById(R.id.game_1);
        game_btn_2 = (Button) view.findViewById(R.id.game_2);
        game_btn_3 = (Button) view.findViewById(R.id.game_3);
        game_btn_4 = (Button) view.findViewById(R.id.game_4);

        game_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), Tsali.class));

            }
        });


        Typeface typface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/font-arabic.ttf");

        /*
        daily_zodic_btn.setTypeface(typface);
        your_chance_today.setTypeface(typface);
        game_btn_1.setTypeface(typface);
        game_btn_2.setTypeface(typface);
        game_btn_3.setTypeface(typface);
*/

        game_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.context, Horoscope_today.class);
                startActivity(i);

            }
        });


        mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        daily_zodic_btn.setOnClickListener(this);
        your_chance_today.setOnClickListener(this);
        game_btn_1.setOnClickListener(this);
        game_btn_2.setOnClickListener(this);

        return view;
    }

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

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.brjak_today:
                Intent i = new Intent(getContext(), Daily_Abraj.class);
                startActivity(i);
                break;
            case R.id.your_chance_today:
                Intent i2 = new Intent(getContext(), luck_today.class);
                startActivity(i2);
                break;
            case R.id.game_1:
                Intent i3 = new Intent(getContext(), ZodicCompatibility.class);
                startActivity(i3);
                break;
            case R.id.game_2:
                Intent i4 = new Intent(getContext(), NameCompatibility.class);
                startActivity(i4);
                break;

        }
    }




}
