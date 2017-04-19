package com.example.administrator.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.example.administrator.myapplication.abstractfactory.UserAbsFactoryIm;
import com.example.administrator.myapplication.aidl.AidlService;
import com.example.administrator.myapplication.celuv.AgeInter;
import com.example.administrator.myapplication.celuv.AgeLimit;
import com.example.administrator.myapplication.celuv.BaseAge;
import com.example.administrator.myapplication.factory.UserFactory;
import com.example.administrator.myapplication.observer.User;
import com.example.administrator.myapplication.proxy.Image;
import com.example.administrator.myapplication.proxy.ProxyImage;
import com.example.administrator.myapplication.rxjava.Fix;
import com.example.administrator.myapplication.rxjava.RxLearn;
import com.example.administrator.myapplication.singleton.UserSingle;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by gaofei on 2016/8/24.
 */
public class MainActivity extends AppCompatActivity implements Observer {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PathView pathView = (PathView)findViewById(R.id.pathView);
        pathView.getPathAnimator()
                .delay(100)
                .duration(500)
                .interpolator(new AccelerateDecelerateInterpolator())
                .start();

        observerableMoshi();

        factoryMoshi();

        singleTonMoshi();

        factoryabsMoshi();

        celueMoshi(AgeInter.TYPE_ONE);

        celueMoshi(AgeInter.TYPE_TWO);


        aidl();

        proxy();

        Fix fix  = new Fix("1" , "2" , "3");
        Fix fix1  = new Fix("4" , "5" , "6");
        Fix fix2  = new Fix("7" , "8" , "9");

        List<Fix> list = new ArrayList<>();
        list.add(fix);
        list.add(fix1);
        list.add(fix2);


        RxLearn.doData(list);

    }


    /**
     * 观察者模式i
     */
    private void observerableMoshi(){
        User user = new User("soar" , 25);
        user.addObserver(this);
        user.setName("gaofei");
        user.setAge(15);
        user.notifyObservers(user);
    }

    @Override
    public void update(Observable observable, Object data) {
        Log.e("soar" , "do this update --- "+((User)data).getName()+"  "+((User)data).getAge());
    }

    /**
     * 工厂模式
     */
    private void factoryMoshi(){
        User user = UserFactory.createUser();
        user.addObserver(this);
        user.notifyObservers(user);
    }


    /**
     * 抽象工厂模式
     */
    private void factoryabsMoshi(){
        User user = UserAbsFactoryIm.getInstance().createUser();
        user.addObserver(this);
        user.notifyObservers(user);
    }

    /**
     * 单例模式
     */

    private void singleTonMoshi(){
        User user = UserSingle.getInstance();
        user.addObserver(this);
        user.notifyObservers(user);
    }


    /**
     * 策略模式
     */

    private void celueMoshi(@AgeLimit int type){
        User user = new User("xiaofeng" , 60);
        BaseAge baseAge = BaseAge.getInstance().create(type);
        int age = baseAge.doSomething(user);
        Log.e("soar" , "celue moshi age = "+age);
    }


    /**
     * aidl
     */
    private void aidl(){
        Intent intent = new Intent(this , AidlService.class);
        startService(intent);

    }


    /**
     *  proxy model
     */

    private void proxy(){
        Image image = new ProxyImage();
        image.displayImage();
    }

}
