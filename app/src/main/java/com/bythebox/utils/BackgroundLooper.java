package com.bythebox.utils;

import android.os.*;

/**
 * Created by Satvik on 22/01/16.
 */
public class BackgroundLooper {

    private static Looper sLooper;

    public synchronized static Looper getInstance() {
        if (sLooper == null) {
            HandlerThread thread = new HandlerThread(BackgroundLooper.class.getName(),
                    android.os.Process.THREAD_PRIORITY_BACKGROUND);
            thread.start();
            sLooper = thread.getLooper();
        }
        return sLooper;
    }
}
