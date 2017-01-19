package com.inet.Abraj_English;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.inet.Abraj_English.Helper.SessionManager;
import com.inet.Abraj_English.Managing.ConnectionMng;
import com.inet.myapplication.R;

import org.json.JSONObject;

public class MyService extends Service implements  Response.Listener<String> ,Response.ErrorListener{

    public Handler handler = null;
    public static Runnable runnable = null;
    public ConnectionMng connectionMng;
    public SessionManager session;
    public static NotificationManager manager;
    public static Notification myNotication;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        throw new UnsupportedOperationException("Not yet implemented");

    }

    private void showNotification(String eventtext, Context ctx) {

        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Intent intent = new Intent(ctx , MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(ctx, 1, intent, 0);

        Notification.Builder builder = new Notification.Builder(ctx);

        builder.setAutoCancel(true);
        builder.setTicker(getString(R.string.app_name));
        builder.setContentTitle(getString(R.string.app_name));
        builder.setContentText("تفقد أخر أخبار الأبراج");
        builder.setSmallIcon(R.mipmap.ic_lun);
        builder.setContentIntent(pendingIntent);
        builder.setOngoing(true);
        //builder.setSubText("تفقد أخر أخبار الأبراج");   //API level 16
        //builder.setNumber(100);
        builder.build();
        try{
           // builder.setPriority(Notification.PRIORITY_MIN);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        myNotication = builder.getNotification();
        manager.notify(11, myNotication);

    }


    @Override
    public void onCreate() {
        super.onCreate();

        session = new SessionManager(this);


        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    connectionMng = new ConnectionMng(Request.Method.GET, ConnectionMng.URL_GET_NOTIFY,
                            MyService.this,
                            MyService.this
                    );
                    Volley.newRequestQueue(getApplicationContext()).add(connectionMng);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                // showNotification("ds",getBaseContext());
               // Toast.makeText(getBaseContext(), "Service Still Running ", Toast.LENGTH_LONG).show();
                handler.postDelayed(runnable , 86400000); //1

            }
        };

        handler.postDelayed(runnable, 86400000); //1


    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("responseee","faild");
    }

    @Override
    public void onResponse(String response) {

        try{
            Log.e("responseee","success");
            JSONObject json = new JSONObject(response);
            int number = json.getInt("ID");
            Log.e("NOTFO", session.getNotify()+"");
            if (session.getNotify()<number)
            {
                Log.e("NUMBER_NOTIFY ",number+"");
                session.setNotify(number);
                showNotification("", getBaseContext());
                Log.e("NOTIFY" , "new NOTIFY");
            }

        }catch (Exception e)
        {

        }

    }



}
