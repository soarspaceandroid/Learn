package com.example.administrator.myapplication.celuv;

/**
 * Created by gaofei on 2016/8/24.
 */
public interface AgeInter {

    /**
     *  两种模式
     */
    public final static int TYPE_ONE = 0;

    public final static int TYPE_TWO = 1;

    /**
     * 获取不同的年龄
     * @param age
     * @return
     */
    public int getAgeoff(int age);
}
