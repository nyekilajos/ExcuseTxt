package com.nyekilajos.excusetxt.presenter;

import com.nyekilajos.excusetxt.model.Excuse;
import com.nyekilajos.excusetxt.provider.ExcuseProvider;
import com.nyekilajos.excusetxt.view.ExcuseView;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public class DefaultExcusePresenter implements ExcusePresenter {

    private ExcuseView view;

    private final ExcuseProvider excuseProvider;

    public DefaultExcusePresenter(ExcuseProvider excuseProvider) {
        this.excuseProvider = excuseProvider;
    }

    @Override
    public void bindView(ExcuseView view) {
        this.view = view;
        view.showAllExcuses(excuseProvider.fetchAllExcuses());
    }

    @Override
    public void addExcuse(String excuseDesc) {
        excuseProvider.addNewExcuse(new Excuse(System.currentTimeMillis(), excuseDesc));
    }

    @Override
    public void unbindView(ExcuseView view) {
        if (this.view == view) {
            this.view = null;
        }
    }
}
