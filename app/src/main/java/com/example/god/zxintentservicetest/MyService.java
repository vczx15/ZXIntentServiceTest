package com.example.god.zxintentservicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by god on 2016/3/21.
 */
public class MyService extends Service {
    public static final String TAG="vczx";
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        long endTime=System.currentTimeMillis()+20*1000;
        Log.d(TAG, "MyService is onStart");
        while(System.currentTimeMillis()<endTime)
        {
            synchronized (this)//把此service锁住
            {
                try {
                    wait(endTime-System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(TAG, "耗时任务完成");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    class NormalService extends Service
    {

        @Override
        public void onCreate() {
            super.onCreate();
            new Thread(new Runnable() {
                @Override
                public void run() {

                }
            }).start();
        }

        @Nullable
        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }
}
