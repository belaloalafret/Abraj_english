package com.inet.Abraj_English.Fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
import com.inet.Abraj_English.Helper.DBHelper;
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


public class Years_Abraj  extends Fragment implements Response.Listener<String> ,Response.ErrorListener {

    public static final String CONNECTION_STATE = "CONNECTION_STATE";
    public static final String JSON_OBJECT = "JSON_OBJ";

    ConnectionMng connection;
    Map<String,String> mData = new HashMap<>();

    AdView mAdView;
    private horoscope_years_adapter adapter;
    private RecyclerView mList_years_horoscope;
    private RecyclerView.LayoutManager mLayoutManager;
    ProgressBar progressBar;

    private DBHelper mdatabase;


    public Years_Abraj() {
        // Required empty public constructor
    }


    private void SetConnectionSettings(){

        connection = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_YEARS,
                this,
                this
        );

        Volley.newRequestQueue(getActivity()).add(connection);

    }

    public void SetData(List<String> data)
    {
        List<holoscope_item> items = new ArrayList<>();

        mdatabase.open();

        ContentValues content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_1) );
        content.put(DBHelper.COL_HORODES , data.get(0) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img1 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_2) );
        content.put(DBHelper.COL_HORODES , data.get(1) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img2 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_3) );
        content.put(DBHelper.COL_HORODES , data.get(2) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img3 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_4) );
        content.put(DBHelper.COL_HORODES , data.get(3) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img4 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_5) );
        content.put(DBHelper.COL_HORODES , data.get(4) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img5 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_6) );
        content.put(DBHelper.COL_HORODES , data.get(5) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img6 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_7) );
        content.put(DBHelper.COL_HORODES , data.get(6) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img7 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_8) );
        content.put(DBHelper.COL_HORODES , data.get(7) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img8 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_9) );
        content.put(DBHelper.COL_HORODES , data.get(8) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img9 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_10) );
        content.put(DBHelper.COL_HORODES , data.get(9) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img10 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_11) );
        content.put(DBHelper.COL_HORODES , data.get(10) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img11 );
        mdatabase.insertEntry(content);

        content = new ContentValues();
        content.put(DBHelper.COL_HORONAME , getString(R.string.horoscope_title_12) );
        content.put(DBHelper.COL_HORODES , data.get(11) );
        content.put(DBHelper.COL_HOROIMG , R.drawable.img12 );
        mdatabase.insertEntry(content);

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

        adapter = new horoscope_years_adapter(items , getActivity());

        AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
        mList_years_horoscope.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));

        mdatabase.close();

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.years_abraj_fragment, container, false);
         progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        try {

            mdatabase = new DBHelper(getActivity());

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        mAdView = (AdView) view.findViewById(R.id.adView_years);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        mList_years_horoscope = (RecyclerView)view.findViewById(R.id.horoscope_years_list);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mList_years_horoscope.setLayoutManager(mLayoutManager);

        SetConnectionSettings();

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        try {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            Log.e(CONNECTION_STATE, error.getMessage());
            mdatabase.open();
            List<String> data = new
                    ArrayList<>();
            Cursor cr = mdatabase.getAllEntries();
            cr.moveToFirst();

            data.add(cr.getString(2));

            while (cr.moveToNext())
            {
                data.add(cr.getString(2));
            }

            mdatabase.close();

            SetData(data);


        }catch (Exception e)
        {
             e.printStackTrace();
        }
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
            Log.e(JSON_OBJECT , response.toString());
            JSONArray array_data = new JSONArray(response);
            List<String> horoscope_texts = new ArrayList<>();

            for (int i=0;i<array_data.length();i++)
            {
                JSONObject object =  array_data.getJSONObject(i);
                horoscope_texts.add(object.getString("horodesc_Eng"));
            }

            mdatabase.open();
            System.out.println("St_delete "+mdatabase.removeallEntries());
            mdatabase.close();
            SetData(horoscope_texts);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e(CONNECTION_STATE , "success");

    }

    /// inner class


    public class horoscope_years_adapter extends RecyclerView.Adapter<horoscope_years_adapter.ViewHolder> {

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
        public horoscope_years_adapter (List<holoscope_item> myDataset , Context mcontext) {
            this.context = mcontext;
            mData = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public horoscope_years_adapter.ViewHolder onCreateViewHolder(ViewGroup parent,
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

          //  holder.horoscope_title.setTypeface(typface);
            //holder.horoscope_details.setTypeface(typface);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

}