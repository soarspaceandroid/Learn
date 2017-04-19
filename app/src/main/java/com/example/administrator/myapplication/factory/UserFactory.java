package com.example.administrator.myapplication.factory;

import com.example.administrator.myapplication.observer.User;

/**
 * Created by gaofei on 2016/8/24.
 */
public class UserFactory {
    public static User createUser(){
        return new User("mali" , 20);
    };
}
