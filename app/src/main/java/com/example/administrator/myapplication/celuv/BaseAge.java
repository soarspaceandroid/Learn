package com.example.administrator.myapplication.celuv;

import com.example.administrator.myapplication.observer.User;

/**
 * Created by gaofei on 2016/8/24.
 */
public class BaseAge {

    public static BaseAge getInstance(){
        return new BaseAge();
    }

    public  BaseAge create(@AgeLimit int type){
        switch (type){
            case AgeInter.TYPE_ONE:
                return new OneAge();
            case AgeInter.TYPE_TWO:
                return new TwoAge();
            default:
                return new OneAge();
        }
    }

    public  int doSomething(User user){
        return 0;
    };
}
