package com.bythebox.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.bythebox.R;

/**
 * Created by Satvik on 22/01/16.
 */
public class UserInfo {

    private static final String LOGTAG = UserInfo.class.getSimpleName();

    private static UserInfo sInstance;

    private String mPhoneNumber;
    private Context mContext;
    private String mMerchantName;
    private String mProfileName;
    private String mProfilePicUrl;
    private String mEmail;
    private boolean mIsLoggedIn;
    private SharedPreferences mPref;


    private UserInfo(Context context) {
        mContext = context;
    }

    public static UserInfo getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new UserInfo(context);
        }
        return sInstance;
    }

    public void init() {
        mPref = PreferenceManager.getDefaultSharedPreferences(mContext);
        mIsLoggedIn = mPref.getBoolean(mContext.getString(R.string.user_logged_in_key), false);
    }

    public boolean isLoggedIn() {
        return mIsLoggedIn;
    }

    public void setIsLoggedIn(boolean mIsLoggedIn) {
        this.mIsLoggedIn = mIsLoggedIn;
        SharedPreferences.Editor e = mPref.edit();
        e.putBoolean(mContext.getString(R.string.user_logged_in_key), true);
        e.apply();
    }
}
