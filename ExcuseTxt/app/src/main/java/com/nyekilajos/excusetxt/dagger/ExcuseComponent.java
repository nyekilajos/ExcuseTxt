package com.nyekilajos.excusetxt.dagger;

import com.nyekilajos.excusetxt.view.AddExcuseActivity;
import com.nyekilajos.excusetxt.view.MainActivity;
import com.nyekilajos.excusetxt.view.SettingsActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by nyeki on 2016. 03. 29..
 */
@Singleton
@Component(modules={AppModule.class})
public interface ExcuseComponent {

    void inject(MainActivity mainActivity);
    void inject(SettingsActivity settingsActivity);
    void inject(AddExcuseActivity addExcuseActivity);

}
