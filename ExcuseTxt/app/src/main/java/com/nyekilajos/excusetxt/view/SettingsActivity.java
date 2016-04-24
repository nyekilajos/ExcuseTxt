package com.nyekilajos.excusetxt.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nyekilajos.excusetxt.R;

/**
 * Created by nyeki on 2016. 04. 02..
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle(R.string.settings_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
