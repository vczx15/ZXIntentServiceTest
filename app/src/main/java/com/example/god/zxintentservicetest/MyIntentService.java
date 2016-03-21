package com.example.god.zxintentservicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by god on 2016/3/21.
 */
public class MyIntentService extends IntentService {
    public static final String TAG="vczx";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        long endTime=System.currentTimeMillis()+20*1000;
        Log.d(TAG, "IntentService Started");
        while(System.currentTimeMillis()<endTime)
        {
            synchronized (this)
            {
                try {
                    wait(endTime-System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(TAG, "耗时任务完成");
    }
}
