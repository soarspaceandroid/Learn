package com.example.administrator.myapplication.celuv;

import com.example.administrator.myapplication.observer.User;

/**
 * Created by gaofei on 2016/8/24.
 */
public class OneAge extends BaseAge implements AgeInter{

    @Override
    public int getAgeoff(int age) {
        return age/2;
    }


    @Override
    public int doSomething(User user) {
        return getAgeoff(user.getAge());
    }
}
