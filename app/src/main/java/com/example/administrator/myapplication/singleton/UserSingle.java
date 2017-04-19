package com.example.administrator.myapplication.singleton;

import com.example.administrator.myapplication.observer.User;

/**
 * Created by gaofei on 2016/8/24.
 */
public class UserSingle {
    private static User user = null;
    public static User getInstance(){
        if (user == null){
            synchronized (UserSingle.class){
                user = new User("xiaoming" , 16);
            }
        }
        return user;
    }
}
