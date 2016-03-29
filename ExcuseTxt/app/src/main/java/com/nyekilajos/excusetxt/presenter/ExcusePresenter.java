package com.nyekilajos.excusetxt.presenter;

import com.nyekilajos.excusetxt.view.ExcuseView;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public interface ExcusePresenter {

    void bindView(ExcuseView view);

    void addExcuse(String excuseDesc);

    void unbindView(ExcuseView view);
}
