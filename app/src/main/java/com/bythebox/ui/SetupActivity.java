package com.bythebox.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.bythebox.R;

/**
 * Created by Satvik on 20/01/16.
 */
public class SetupActivity extends AppCompatActivity {

    private static final String LOGTAG = SetupActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v(LOGTAG, "onCreate+");
        setContentView(R.layout.activity_fragment_holder);
    }
}
