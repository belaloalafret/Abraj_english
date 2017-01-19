package com.inet.Abraj_English;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.inet.Abraj_English.Managing.ActivityManagment;
import com.inet.Abraj_English.Model.holoscope_item;
import com.inet.Abraj_English.Managing.ConnectionMng;
import com.inet.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class Daily_Abraj extends AppCompatActivity implements Response.Listener<String> ,Response.ErrorListener{

    public static final String CONNECTION_STATE = "Connection_STATE : ";
    public static final String CONNECTION_MSG = "ERROR_MSG";
    public static final String JSON_OBJECT = "JSON";
    ConnectionMng connection;
    Map<String,String> mData = new HashMap<>();
    InterstitialAd mInterstitialAd;
    private CoordinatorLayout cordinate;
    private SwipeRefreshLayout refresh_data;
    private RecyclerView mList_horoscope;
    private holoscopeAdapter mList_horoscope_Adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressBar progressBar;


    public Daily_Abraj() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_abraj_activity);

        cordinate = (CoordinatorLayout)findViewById(R.id.cordinate);


        AdView mAdView = (AdView)findViewById(R.id.adView_chaina_game4);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mList_horoscope = (RecyclerView)findViewById(R.id.horoscope_list);
        mLayoutManager = new LinearLayoutManager(this);
        mList_horoscope.setLayoutManager(mLayoutManager);
        refresh_data = (SwipeRefreshLayout)findViewById(R.id.refresh_data);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        refresh_data.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SetConnectionSettings();
            }
        });

        SetConnectionSettings();


    }


    private void SetConnectionSettings(){

         connection = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_DATA,
               this,
               this
        );


        Volley.newRequestQueue(this).add(connection);

    }

    public void SetData(List<String> data)
    {

        List<holoscope_item> items = new ArrayList<>();

        items.add(new holoscope_item(getString(R.string.horoscope_title_1),data.get(0),R.drawable.img1));
        items.add(new holoscope_item(getString(R.string.horoscope_title_2), data.get(1),R.drawable.img2));
        items.add(new holoscope_item(getString(R.string.horoscope_title_3),data.get(2),R.drawable.img3));
        items.add(new holoscope_item(getString(R.string.horoscope_title_4),data.get(3),R.drawable.img4));
        items.add(new holoscope_item(getString(R.string.horoscope_title_5),data.get(4),R.drawable.img5));
        items.add(new holoscope_item(getString(R.string.horoscope_title_6),data.get(5),R.drawable.img6));
        items.add(new holoscope_item(getString(R.string.horoscope_title_7),data.get(6),R.drawable.img7));
        items.add(new holoscope_item(getString(R.string.horoscope_title_8),data.get(7),R.drawable.img8));
        items.add(new holoscope_item(getString(R.string.horoscope_title_9),data.get(8),R.drawable.img9));
        items.add(new holoscope_item(getString(R.string.horoscope_title_10),data.get(9),R.drawable.img10));
        items.add(new holoscope_item(getString(R.string.horoscope_title_11), data.get(10), R.drawable.img11));
        items.add(new holoscope_item(getString(R.string.horoscope_title_12), data.get(11), R.drawable.img12));

        mList_horoscope_Adapter = new holoscopeAdapter(items , this);

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(mList_horoscope_Adapter);
        mList_horoscope.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));


    }

    @Override
    public void onErrorResponse(VolleyError error) {

        Log.e(CONNECTION_STATE , "Error");
        refresh_data.setRefreshing(false);

        progressBar.setVisibility(ProgressBar.INVISIBLE);
        try{

            Snackbar snackbar = Snackbar
                    .make(cordinate, getString(R.string.errormsg), Snackbar.LENGTH_LONG)
                    ;


            snackbar.show();

            Log.e(CONNECTION_MSG , error.getMessage());
        }catch (Exception e)
        {
            Log.e(CONNECTION_MSG , "Something went wrong !");
            e.printStackTrace();
        }

    }

    @Override
    public void onResponse(String response) {
        try {

            progressBar.setVisibility(ProgressBar.INVISIBLE);
            refresh_data.setRefreshing(false);
            Log.e(JSON_OBJECT , response.toString());
            JSONArray array_data = new JSONArray(response);
            List<String> horoscope_texts = new ArrayList<>();

            for (int i=0;i<array_data.length();i++)
            {
                JSONObject object =  array_data.getJSONObject(i);
                horoscope_texts.add(object.getString("horoscope_Eng"));
            }

            SetData(horoscope_texts);

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.e(CONNECTION_STATE , "success");
    }



    public class holoscopeAdapter extends RecyclerView.Adapter<holoscopeAdapter.ViewHolder> {

        private List<holoscope_item> mData;
        private HoroScope_Clicked mCallback;
        private Context context;

        public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener{
            // each data item is just a string in this case
            public TextView horoscope_title;
            public TextView horoscope_details;
            public ImageView horoscope_img;

            public ViewHolder(View v) {
                super(v);

                horoscope_title = (TextView)v.findViewById(R.id.horoscope_item_name);
                horoscope_details = (TextView)v.findViewById(R.id.horoscope_item_details);
                horoscope_img = (ImageView)v.findViewById(R.id.horoscope_item_photo);
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                mCallback = new ActivityManagment();
                mCallback.onHoroScopeClicked(mData.get(getPosition()), context);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public holoscopeAdapter(List<holoscope_item> myDataset , Context mcontext) {
            this.context = mcontext;
            mData = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public holoscopeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.horoscope_item, parent, false);
            // set the view's size, margins, paddings and layout parameters



            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.horoscope_title.setText(mData.get(position).getTitle());
            holder.horoscope_details.setText(mData.get(position).getDetail());
            holder.horoscope_img.setImageResource(mData.get(position).getImg());

            Typeface typface= Typeface.createFromAsset(getAssets(), "fonts/font-arabic.ttf");

           // holder.horoscope_title.setTypeface(typface);
            //holder.horoscope_details.setTypeface(typface);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

}
