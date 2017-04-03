package com.example.dominic.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Process;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
            private RemoteService mRemoteService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(this, IRemoteService.class);

        ServiceConnection conn = new ServiceConnection() {


            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mRemoteService = RemoteService.Stub.asInterface(service);

                try {
                    Log.d(TAG, "onServiceConnected " + Process.myPid());
                    Log.d(TAG, "onServiceConnected " + mRemoteService.getPid());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                 mRemoteService = null;
            }
        };
        bindService(intent, conn, BIND_AUTO_CREATE);
    }
}
