package com.inet.Abraj_English.Helper;

/**
 * Created by DELL on 16/04/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;

public class SessionManager {
    // LogCat tag
    private static String TAG = SessionManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "AbrajPref";

    private static final String CHANCE = "chance";
    private static final String DATE = "date";
    private static final String NOTIFY = "notify";

    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void setLogin(String chane) {

        editor.putString(CHANCE, chane);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public String getChance(){
        return pref.getString(CHANCE, "");
    }



    public void setNotify(int notify) {

        editor.putInt(NOTIFY, notify);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public int getNotify(){
        return pref.getInt(NOTIFY, 0 );
    }


    public void setDate(int date) {

        editor.putInt(DATE, date);

        // commit changes
        editor.commit();

        Log.d(TAG, "User login session modified!");
    }

    public int getDate(){
        return pref.getInt(DATE, 1);
    }

}
