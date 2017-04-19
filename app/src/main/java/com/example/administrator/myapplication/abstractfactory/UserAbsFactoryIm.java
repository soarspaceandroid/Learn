package com.example.administrator.myapplication.abstractfactory;

import com.example.administrator.myapplication.observer.User;

/**
 * Created by gaofei on 2016/8/24.
 */
public class UserAbsFactoryIm extends UserAbsFactory {

    public static UserAbsFactory getInstance(){
        return new UserAbsFactoryIm();
    }

    @Override
    public User createUser() {
        return new User("test" , 2);
    }
}
