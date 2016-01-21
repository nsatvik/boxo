package com.bythebox.app;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.bythebox.model.UserInfo;
import com.bythebox.utils.BackgroundLooper;

public class DataManager {

    private static final String LOGTAG = DataManager.class.getSimpleName();
    private static DataManager sInstance;
    private final Object mLock = new Object();
    private Context mContext;
    private volatile boolean mLoaded = false;
    private Handler mBkgHandler = new Handler(BackgroundLooper.getInstance());


    private UserInfo mUserInfo;

    private DataManager(Context c) {
        mContext = c;
    }

    public static DataManager getInstance(Context c) {
        if (sInstance == null) {
            Log.v(LOGTAG, "Creating data manager instance");
            sInstance = new DataManager(c);
        }
        return sInstance;
    }

    public void init() {

        mBkgHandler.post(new Runnable() {
            @Override
            public void run() {

                synchronized (mLock) {
                    mUserInfo = UserInfo.getInstance(mContext);
                    mUserInfo.init();
                    mLoaded = true;
                    mLock.notifyAll();
                }
            }
        });
    }

    private void awaitLoadCompletion() {
        synchronized (mLock) {
            while (!mLoaded) {
                try {
                    mLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * Clean up on logging out
     */
    public void clearDataManager() {
        mBkgHandler.removeCallbacksAndMessages(null);
    }
}
