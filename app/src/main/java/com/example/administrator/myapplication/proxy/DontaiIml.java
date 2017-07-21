package com.example.administrator.myapplication.proxy;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DontaiIml implements DontaiProxy.MyProxy {


    @Override
    public String getName(String xing) {
        return "gao----> "+ xing;
    }
}
