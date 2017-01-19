package com.inet.Abraj_English.Fragments;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
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
import com.inet.Abraj_English.HoroScope_Clicked;
import com.inet.Abraj_English.Managing.ActivityManagment;
import com.inet.Abraj_English.Managing.ConnectionMng;
import com.inet.Abraj_English.Model.holoscope_item;
import com.inet.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class Chaina_Abraj  extends Fragment implements Response.Listener<String> ,Response.ErrorListener {


    public static final String CONNECTION_STATE = "CONNECTION_STATE";
    public static final String JSON_OBJECT = "JSON_OBJ";

    ConnectionMng connection;
    Map<String,String> mData = new HashMap<>();
    AdView mAdView;
    private holoscope_chaina_Adapter adapter;
    private RecyclerView mList_chaina_horoscope;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressBar progressBar;

    public Chaina_Abraj() {
        // Required empty public constructor
    }

    private void SetConnectionSettings(){
        connection = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_CHAINA,
                this,
                this
        );

        Volley.newRequestQueue(getActivity()).add(connection);

    }

    public void SetData(List<String> data) {
        List<holoscope_item> items = new ArrayList<>();

        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_1),data.get(0),R.drawable.mouse));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_2), data.get(1),R.drawable.ox));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_3),data.get(2),R.drawable.tiger));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_4),data.get(3),R.drawable.rabbit));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_5),data.get(4),R.drawable.dragon));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_6),data.get(5),R.drawable.snake));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_7),data.get(6),R.drawable.horse));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_8),data.get(7),R.drawable.goat));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_9),data.get(8),R.drawable.monkey));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_10),data.get(9),R.drawable.rooster));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_11), data.get(10), R.drawable.dog));
        items.add(new holoscope_item(getString(R.string.horoscope_title_chaina_12), data.get(11), R.drawable.pig));

        adapter = new holoscope_chaina_Adapter(items , getActivity());

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        mList_chaina_horoscope.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
    }

        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chaina_abraj_fragment, container, false);
        // Inflate the layout for this fragment

         progressBar = (ProgressBar)view.findViewById(R.id.progressBar);

        mList_chaina_horoscope = (RecyclerView)view.findViewById(R.id.horoscope_chaina_list_data);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mList_chaina_horoscope.setLayoutManager(mLayoutManager);

        mAdView = (AdView) view.findViewById(R.id.adView_chaina);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        SetConnectionSettings();

        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progressBar.setVisibility(ProgressBar.INVISIBLE);
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
    public void onResponse(String response) {

        try {

            progressBar.setVisibility(ProgressBar.INVISIBLE);
            Log.e(JSON_OBJECT, response.toString());
            JSONArray array_data = new JSONArray(response);
            List<String> horoscope_texts = new ArrayList<>();

            for (int i=0;i<array_data.length();i++)
            {
                JSONObject object =  array_data.getJSONObject(i);
                horoscope_texts.add(object.getString("horochaina_Eng"));
            }

            SetData(horoscope_texts);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e(CONNECTION_STATE , "success");

    }

    // inner class adapter

    public class holoscope_chaina_Adapter extends RecyclerView.Adapter<holoscope_chaina_Adapter.ViewHolder> {

        private List<holoscope_item> mData;
        private HoroScope_Clicked mCallback;
        private Context context;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
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
        public holoscope_chaina_Adapter(List<holoscope_item> myDataset , Context mcontext) {
            this.context = mcontext;
            mData = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public holoscope_chaina_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
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

            Typeface typface= Typeface.createFromAsset(getActivity().getAssets(), "fonts/font-arabic.ttf");

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