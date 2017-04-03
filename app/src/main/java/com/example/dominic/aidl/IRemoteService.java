package com.example.dominic.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Dominic on 2017/4/3.
 */

public class IRemoteService extends Service {
    

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    RemoteService.Stub binder = new RemoteService.Stub() {
        @Override
        public int getPid() throws RemoteException {
            return Process.myPid();
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    };




}
