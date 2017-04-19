package com.example.administrator.myapplication.observer;

import java.util.Observable;

/**
 * Created by gaofei on 2016/8/24.
 */
public class User extends Observable{
    private String name ;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        setChanged();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        setChanged();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        setChanged();
    }

}
