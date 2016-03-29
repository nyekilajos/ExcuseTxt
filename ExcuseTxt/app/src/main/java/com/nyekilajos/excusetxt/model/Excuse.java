package com.nyekilajos.excusetxt.model;

import com.google.gson.annotations.Expose;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public class Excuse {

    @Expose
    private final long id;

    @Expose
    private final String excuseDesc;

    public Excuse(long id, String excuseDesc) {
        this.id = id;
        this.excuseDesc = excuseDesc;
    }

    public String getExcuseDesc() {
        return excuseDesc;
    }

    public long getId() {
        return id;
    }
}
