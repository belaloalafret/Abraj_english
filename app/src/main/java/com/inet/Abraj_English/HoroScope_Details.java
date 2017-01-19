package com.inet.Abraj_English;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
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
import com.inet.myapplication.R;

public class HoroScope_Details extends AppCompatActivity{

    public static final String HOROSCOPE_TITLE = "horoscope_title";
    public static final String HOROSCOPE_IMG = "horoscope_img";
    public static final String HOROSCOPE_DESCRIPTION = "horoscope_desc";
    CallbackManager callbackManager;
    ShareDialog shareDialog;
    TextView title ;
    TextView description ;
    ImageView img;



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

        ShareLinkContent  linkContent = new ShareLinkContent.Builder()
                .setContentTitle(title.getText().toString())
                .setContentDescription(
                        description.getText().toString())
                .setContentUrl(Uri.parse("http://www.2dayhoroscope.com"))
                .build();

        if (ShareDialog.canShow(ShareLinkContent.class)) {

            shareDialog.show(linkContent);

        }
        MessageDialog.show(this, linkContent);

    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horo_scope__details);

        title = (TextView) findViewById(R.id.details_title);
        description = (TextView) findViewById(R.id.details_description);
        img = (ImageView) findViewById(R.id.details_img);



        Typeface typface= Typeface.createFromAsset(getAssets(), "fonts/font-arabic.ttf");
        title.setText(getIntent().getExtras().getString(HOROSCOPE_TITLE));
        description.setText(getIntent().getExtras().getString(HOROSCOPE_DESCRIPTION));

      //  title.setTypeface(typface);
      //  description.setTypeface(typface);

        img.setImageResource(getIntent().getExtras().getInt(HOROSCOPE_IMG));



    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}
