package com.example.administrator.myapplication.proxy;

import android.util.Log;

/**
 * Created by gaofei on 2016/9/2.
 */
public class RealImage extends Image {

    @Override
    public void displayImage() {
        Log.e("soar" , "real image display");
        super.displayImage();
    }
}
