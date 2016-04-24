package com.nyekilajos.excusetxt.provider;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nyekilajos.excusetxt.model.Excuse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nyeki on 2016. 03. 29..
 */
public class DefaultExcuseProvider implements ExcuseProvider {

    private static final String EXCUSE_STORE_NAME = "excuseStore";

    private final SharedPreferences excuseStore;
    private final Context context;
    private final Gson gson;

    public DefaultExcuseProvider(Context context) {
        this.context = context;
        excuseStore = context.getSharedPreferences(EXCUSE_STORE_NAME, Context.MODE_PRIVATE);
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Override
    public List<Excuse> fetchAllExcuses() {
        Map<String, ?> dbMap = excuseStore.getAll();
        List<Excuse> ret = new ArrayList<>();
        for (Map.Entry<String, ?> entry : dbMap.entrySet()) {
            String json = (String) entry.getValue();
            ret.add(gson.fromJson(json, Excuse.class));
        }
        return ret;
    }

    @Override
    public Excuse getExcuseById(long id) {
        Excuse ret = null;
        String desc = excuseStore.getString(Long.toString(id), null);
        if (desc != null) {
            ret = new Excuse(id, desc);
        }
        return ret;
    }

    @Override
    public void addNewExcuse(Excuse excuse) {
        excuseStore.edit().putString(Long.toString(excuse.getId()), gson.toJson(excuse)).apply();
    }
}
