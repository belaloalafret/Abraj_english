package com.inet.Abraj_English.Model;

/**
 * Created by Ahmad Al-ammar on 25/02/2016.
 */
public class holoscope_item {

    private String title;
    private String detail;
    private int img;

    public holoscope_item(String title , String detail , int img)
    {
        this.title = title ;
        this.detail = detail ;
        this.img = img;

    }

    public String getTitle()
    {

        return this.title;
    }

    public String getDetail()
    {
        return this.detail;
    }

    public int getImg()
    {
        return this.img;
    }

}
