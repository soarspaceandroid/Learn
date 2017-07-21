package com.example.administrator.myapplication.proxy;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/7/21.
 */

public class DontaiProxy {


    public void proxt(Class clz){
        MyProxy myProxy = (MyProxy)Proxy.newProxyInstance(clz.getClassLoader(), new Class[]{clz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(new DontaiIml() , args);
            }
        });
        Log.e("soar" , myProxy.getName("yig"));
    }



    public interface MyProxy{

        String getName(String xing);
    }


}


