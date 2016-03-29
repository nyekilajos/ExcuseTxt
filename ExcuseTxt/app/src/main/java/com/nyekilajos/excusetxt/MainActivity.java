package com.nyekilajos.excusetxt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nyekilajos.excusetxt.dagger.ExcuseComponent;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExcuseApplication.getInstance().getExcuseComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
