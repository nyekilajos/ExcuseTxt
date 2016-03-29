package com.nyekilajos.excusetxt;

import android.app.Application;

import com.nyekilajos.excusetxt.dagger.AppModule;
import com.nyekilajos.excusetxt.dagger.DaggerExcuseComponent;
import com.nyekilajos.excusetxt.dagger.ExcuseComponent;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public class ExcuseApplication extends Application {

    private static ExcuseApplication instance;

    private ExcuseComponent excuseComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        excuseComponent = DaggerExcuseComponent.builder().appModule(new AppModule()).build();
        instance = this;
    }

    public static ExcuseApplication getInstance() {
        return instance;
    }

    public ExcuseComponent getExcuseComponent() {
        return excuseComponent;
    }
}
