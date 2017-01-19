package com.inet.Abraj_English;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.inet.Abraj_English.Managing.ConnectionMng;
import com.inet.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class Joke_of_the_Day extends AppCompatActivity  implements Response.Listener<String> ,Response.ErrorListener {

    public static final String CONNECTION_STATE = "Connection_STATE : ";
    public static final String CONNECTION_MSG = "ERROR_MSG";
    public static final String JSON_OBJECT = "JSON";
    ProgressBar progressBar;
    ConnectionMng connection;
    TextView details_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_of_the__day);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        details_title= (TextView)findViewById(R.id.details_description);
        SetConnectionSettings();

    }

    private void SetConnectionSettings(){

        connection = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_DAILY_HOROSCOPE,
                this,
                this
        );

        Volley.newRequestQueue(this).add(connection);
    }


    @Override
    public void onErrorResponse(VolleyError error) {

        Log.e(CONNECTION_STATE, "Error");
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        try{

            Toast.makeText(this, this.getResources().getString(R.string.errormsg), Toast.LENGTH_LONG).show();
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
            Log.e(JSON_OBJECT , response.toString());

            JSONArray array_data = new JSONArray(response);

            if(array_data.length()!=0)
            {
                JSONObject object =  array_data.getJSONObject(0);
                details_title.setText(object.getString("joke_en"));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.e(CONNECTION_STATE, "success");
    }

}
