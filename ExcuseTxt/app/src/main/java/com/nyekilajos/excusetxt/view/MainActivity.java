package com.nyekilajos.excusetxt.view;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.nyekilajos.excusetxt.ExcuseApplication;
import com.nyekilajos.excusetxt.R;
import com.nyekilajos.excusetxt.dagger.ExcuseComponent;
import com.nyekilajos.excusetxt.model.Excuse;
import com.nyekilajos.excusetxt.presenter.ExcusePresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ExcuseView {

    private ExcusesAdapter excusesAdapter;

    @Bind(R.id.excuses_recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.fab)
    FloatingActionButton addExcuse;

    @Inject
    ExcusePresenter excusePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExcuseApplication.getInstance().getExcuseComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle(getString(R.string.app_name));

        excusesAdapter = new ExcusesAdapter(this);
        recyclerView.setAdapter(excusesAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        addExcuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddExcuseActivity();
            }
        });
    }

    private void openAddExcuseActivity() {
        Intent intent = new Intent(this, AddExcuseActivity.class);
        startActivity(intent);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                openSettignsActivity();
                return true;

            case R.id.menu_help:
                //TODO
                return true;

            default:
                throw new IllegalArgumentException("No such menu exists");
        }
    }

    private void openSettignsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    @Override
    public void showAllExcuses(List<Excuse> excuses) {
        excusesAdapter.setExcuses(excuses);
    }

    @Override
    public void showSelectedExcuse(Excuse excuse) {

    }
}
