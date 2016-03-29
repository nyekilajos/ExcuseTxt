package com.nyekilajos.excusetxt.dagger;

import android.content.Context;

import com.nyekilajos.excusetxt.presenter.DefaultExcusePresenter;
import com.nyekilajos.excusetxt.presenter.ExcusePresenter;
import com.nyekilajos.excusetxt.provider.DefaultExcuseProvider;
import com.nyekilajos.excusetxt.provider.ExcuseProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by nyeki on 2016. 03. 29..
 */
@Module
public class AppModule {

    private final Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    ExcusePresenter providesExcusePresenter(ExcuseProvider excuseProvider) {
        return new DefaultExcusePresenter(excuseProvider);
    }

    @Provides
    ExcuseProvider providesExcuseProvider() {
        return new DefaultExcuseProvider(context);
    }
}
