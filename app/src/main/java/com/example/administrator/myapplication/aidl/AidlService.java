package com.example.administrator.myapplication.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.example.administrator.myapplication.IMyAidlInterface;

/**
 * Created by gaofei on 2016/8/25.
 */
public class AidlService extends Service {

    private IMyAidlInterface.Stub stub = new IMyAidlInterface.Stub() {
        @Override
        public int getAgeFromOther(String name) throws RemoteException {
            return 0;
        }
    };


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }


}
