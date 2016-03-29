package com.nyekilajos.excusetxt.view;

import com.nyekilajos.excusetxt.model.Excuse;

import java.util.List;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public interface ExcuseView {

    void showAllExcuses(List<Excuse> excuses);

    void showSelectedExcuse(Excuse excuse);
}
