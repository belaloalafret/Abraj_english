package com.inet.Abraj_English;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.inet.Abraj_English.Managing.ActivityManagment;
import com.inet.Abraj_English.Model.holoscope_item;
import com.inet.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Al-ammar on 25/02/2016.
 */
public class World_Abraj extends AppCompatActivity {

    public World_Abraj() {
        // Required empty public constructor
    }

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private RecyclerView mList_horoscope_world;
    private horoworldadapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_abraj_activity);

        mList_horoscope_world = (RecyclerView) findViewById(R.id.horoscope_world_list);

        List<holoscope_item> data = new ArrayList<>();


        adapter = new horoworldadapter(data , this);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mList_horoscope_world.setLayoutManager(gaggeredGridLayoutManager);

        mList_horoscope_world.setAdapter(adapter);

    }

    // inner class Adapter


    public class horoworldadapter extends RecyclerView.Adapter<horoworldadapter.ViewHolder> {

        private List<holoscope_item> mData;
        private HoroScope_Clicked mCallback;
        private Context context;

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            // each data item is just a string in this case
            public TextView horoscope_title;
            public ImageView horoscope_img;

            public ViewHolder(View v) {
                super(v);

                horoscope_title = (TextView)v.findViewById(R.id.horoworld_item_name);
                horoscope_img = (ImageView)v.findViewById(R.id.horoworld_item_photo);
                v.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                mCallback = new ActivityManagment();
                mCallback.onHoroWorldClicked(mData.get(getPosition()), context);
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public horoworldadapter (List<holoscope_item> myDataset , Context mcontext) {
            this.context = mcontext;
            mData = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public horoworldadapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.world_card_item, parent, false);
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
            holder.horoscope_img.setImageResource(mData.get(position).getImg());

            Typeface typface= Typeface.createFromAsset(getAssets(), "fonts/font-arabic.ttf");

          //  holder.horoscope_title.setTypeface(typface);

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


}