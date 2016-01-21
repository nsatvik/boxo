package com.bythebox.app;

import android.app.Application;
import android.util.Log;

/**
 * Created by Satvik on 22/01/16.
 */
public class BoxApp extends Application {
    private static final String LOGTAG = BoxApp.class.getSimpleName();

    private DataManager mDataManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v(LOGTAG, "onCreate");

        mDataManager = DataManager.getInstance(BoxApp.this);
        mDataManager.init();

    }

    @Override
    public void onTerminate() {

        Log.v(LOGTAG, "terminating the application");
        super.onTerminate();
    }

    public synchronized DataManager getDataManager() {
        return mDataManager;
    }
}
