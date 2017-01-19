package com.inet.Abraj_English.Managing;

import android.content.Context;
import android.content.Intent;

import com.inet.Abraj_English.HoroScope_Clicked;
import com.inet.Abraj_English.HoroScope_Details;
import com.inet.Abraj_English.Model.holoscope_item;
import com.inet.Abraj_English.NameCompatibility;


/**
 * Created by Ahmad Al-ammar on 27/02/2016.
 */

public class ActivityManagment  implements  HoroScope_Clicked{


    @Override
    public void onHoroScopeClicked(holoscope_item item , Context context ) {

        Intent intent = new Intent(context, HoroScope_Details.class);
        intent.putExtra(HoroScope_Details.HOROSCOPE_TITLE ,item.getTitle());
        intent.putExtra(HoroScope_Details.HOROSCOPE_DESCRIPTION ,item.getDetail());
        intent.putExtra(HoroScope_Details.HOROSCOPE_IMG ,item.getImg());
        context.startActivity(intent);

    }

    @Override
    public void onHoroWorldClicked(holoscope_item item, Context context) {

        Intent intent = new Intent(context, NameCompatibility.class);
        intent.putExtra(HoroScope_Details.HOROSCOPE_TITLE ,item.getTitle());
        intent.putExtra(HoroScope_Details.HOROSCOPE_DESCRIPTION ,item.getDetail());
        intent.putExtra(HoroScope_Details.HOROSCOPE_IMG ,item.getImg());
        context.startActivity(intent);

    }




}
