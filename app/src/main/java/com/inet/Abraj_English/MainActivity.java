package com.inet.Abraj_English;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.inet.Abraj_English.Fragments.Chaina_Abraj;
import com.inet.Abraj_English.Fragments.Years_Abraj;
import com.inet.Abraj_English.Fragments.main_category;
import com.inet.Abraj_English.Model.alpha_model;
import com.inet.Abraj_English.Utils.Constant;
import com.inet.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static int width,height;
    InterstitialAd mInterstitialAd;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    public  static  Context context;

    private void SetAlphaValues()
    {

        Constant.ALPHAPET.add(new alpha_model('ا', 1));
        Constant.ALPHAPET.add(new alpha_model('أ', 1));
        Constant.ALPHAPET.add(new alpha_model('ئ',1));
        Constant.ALPHAPET.add(new alpha_model('ى', 1));
        Constant.ALPHAPET.add(new alpha_model('ء',1));
        Constant.ALPHAPET.add(new alpha_model('ب', 2));
        Constant.ALPHAPET.add(new alpha_model('ج', 3));
        Constant.ALPHAPET.add(new alpha_model('د', 4));
        Constant.ALPHAPET.add(new alpha_model('ه',5));
        Constant.ALPHAPET.add(new alpha_model('و',6));
        Constant.ALPHAPET.add(new alpha_model('ؤ', 6));
        Constant.ALPHAPET.add(new alpha_model('ز', 7));
        Constant.ALPHAPET.add(new alpha_model('ح', 8));
        Constant.ALPHAPET.add(new alpha_model('ط',9));
        Constant.ALPHAPET.add(new alpha_model('ي',10));
        Constant.ALPHAPET.add(new alpha_model('ك',20));
        Constant.ALPHAPET.add(new alpha_model('ل',30));
        Constant.ALPHAPET.add(new alpha_model('م', 40));
        Constant.ALPHAPET.add(new alpha_model('ن', 50));
        Constant.ALPHAPET.add(new alpha_model('س', 60));
        Constant.ALPHAPET.add(new alpha_model('ع', 70));
        Constant.ALPHAPET.add(new alpha_model('ف',80));
        Constant.ALPHAPET.add(new alpha_model('ص',90));
        Constant.ALPHAPET.add(new alpha_model('ق', 100));
        Constant.ALPHAPET.add(new alpha_model('ر', 200));
        Constant.ALPHAPET.add(new alpha_model('ش', 300));
        Constant.ALPHAPET.add(new alpha_model('ت', 400));
        Constant.ALPHAPET.add(new alpha_model('ة',400));
        Constant.ALPHAPET.add(new alpha_model('ث',500));
        Constant.ALPHAPET.add(new alpha_model('خ', 600));
        Constant.ALPHAPET.add(new alpha_model('ذ', 700));
        Constant.ALPHAPET.add(new alpha_model('ض', 800));
        Constant.ALPHAPET.add(new alpha_model('ظ', 900));
        Constant.ALPHAPET.add(new alpha_model('غ', 1000));

    }

    void CheckPerm()
    {
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                String [] str = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                ActivityCompat.requestPermissions(MainActivity.this,str,2);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true, new DepthPageTransformer());
        setupViewPager(viewPager);


        CheckPerm();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;

        startService(new Intent(this, MyService.class));
        mInterstitialAd = new InterstitialAd(this);


        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id_splash));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();

            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        setupTabIcons();

        SetAlphaValues();

        Typeface typface= Typeface.createFromAsset(getAssets(), "fonts/font-arabic-2.ttf");

        // Setting Custom Tab
        View  viewOne = LayoutInflater.from(this).inflate(R.layout.tab_title, null);
        TextView tabOne = (TextView)viewOne.findViewById(R.id.tab_title);
        ImageView taboneImg = (ImageView)viewOne.findViewById(R.id.tab_img);

       // tabOne.setTypeface(typface);
        tabOne.setText(getString(R.string.tabOne));
        taboneImg.setImageResource(R.drawable.tab1);
        tabLayout.getTabAt(0).setCustomView(viewOne);

        View  viewTwo = LayoutInflater.from(this).inflate(R.layout.tab_title, null);
        TextView tabTwo = (TextView)viewTwo.findViewById(R.id.tab_title);
        ImageView tabtwoImg = (ImageView)viewTwo.findViewById(R.id.tab_img);

       // tabTwo.setTypeface(typface);
        tabTwo.setText(getString(R.string.tabTwo));
        tabtwoImg.setImageResource(R.drawable.tab2);
        tabLayout.getTabAt(1).setCustomView(viewTwo);

        View  viewThree = LayoutInflater.from(this).inflate(R.layout.tab_title, null);
        TextView tabThree = (TextView)viewThree.findViewById(R.id.tab_title);
        ImageView tabthreeImg = (ImageView)viewThree.findViewById(R.id.tab_img);

       // tabThree.setTypeface(typface);
        tabThree.setText(getString(R.string.tabThree));
        tabthreeImg.setImageResource(R.drawable.tab3);
        tabLayout.getTabAt(2).setCustomView(viewThree);

        try {
            MyService.manager.cancel(11);
            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager nMgr = (NotificationManager)getApplicationContext().getSystemService(ns);
            nMgr.cancel(11);

        }catch(Exception e)
        {

            try{
                String ns = Context.NOTIFICATION_SERVICE;
                NotificationManager nMgr = (NotificationManager)getApplicationContext().getSystemService(ns);
                nMgr.cancel(11);

            }catch (Exception ee)
            {

            }

        }
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private void setupTabIcons() {
       // tabLayout.getTabAt(0).setIcon(tabIcons[0]);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new main_category(), "الأبراج اليومية");
        adapter.addFragment(new Years_Abraj(), "الأبراج السنوية");
        adapter.addFragment(new Chaina_Abraj(),"الصينية");
        viewPager.setAdapter(adapter);
    }


    // inner Adapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


    // Animation For ViewPager
    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}
