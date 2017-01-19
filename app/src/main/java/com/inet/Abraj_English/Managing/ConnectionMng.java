package com.inet.Abraj_English.Managing;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;


public class ConnectionMng extends StringRequest {

    public static String URL_GET_SUDOKO = "http://2dayhoroscope.com/sudoku";
    public static String URL_GET_DATA = "http://www.2dayhoroscope.com/daily";
    public static String URL_GET_YEARS = "http://www.2dayhoroscope.com/year";
    public static String URL_GET_CHAINA = "http://www.2dayhoroscope.com/china";
    public static String URL_GET_NOTIFY = "http://www.2dayhoroscope.com/lastDaily";
    public static String URL_GET_DAILY_HOROSCOPE = "http://www.2dayhoroscope.com/daily_activity";

    // DONE BABY !!
    // TODO : change the url , to given method from wissam

    public static String HOROSCOPE_TEXT = "horoscope_text";
    public static String HOROSCOPE_YEARS_DESC = "horodesc";
    public static String HOROSCOPE_CHAINA_DESC = "horochaina_desc";


    public ConnectionMng(int method, String url,
                         Response.Listener<String> listener,
                         Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }


}
