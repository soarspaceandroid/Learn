package com.example.administrator.myapplication.proxy;

/**
 * Created by gaofei on 2016/9/2.
 */
public class ProxyImage extends Image {

    private RealImage realImage;

    @Override
    public void displayImage() {
        super.displayImage();
        if(realImage == null){
            realImage = new RealImage();
        }
        realImage.displayImage();
    }
}
