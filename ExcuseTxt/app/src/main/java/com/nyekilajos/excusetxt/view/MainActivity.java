package com.nyekilajos.excusetxt.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nyekilajos.excusetxt.ExcuseApplication;
import com.nyekilajos.excusetxt.R;
import com.nyekilajos.excusetxt.dagger.ExcuseComponent;
import com.nyekilajos.excusetxt.model.Excuse;
import com.nyekilajos.excusetxt.presenter.ExcusePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ExcuseView {

    @Inject
    ExcusePresenter excusePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExcuseApplication.getInstance().getExcuseComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    @Override
    protected void onResume() {
        super.onResume();
        excusePresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        excusePresenter.unbindView(this);
    }

    @Override
    public void showAllExcuses(List<Excuse> excuses) {

    }

    @Override
    public void showSelectedExcuse(Excuse excuse) {

    }
}
