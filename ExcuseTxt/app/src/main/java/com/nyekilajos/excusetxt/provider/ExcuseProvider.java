package com.nyekilajos.excusetxt.provider;

import com.nyekilajos.excusetxt.model.Excuse;

import java.util.List;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public interface ExcuseProvider {

    List<Excuse> fetchAllExcuses();

    Excuse getExcuseById(long id);

    void addNewExcuse(Excuse excuse);
}
