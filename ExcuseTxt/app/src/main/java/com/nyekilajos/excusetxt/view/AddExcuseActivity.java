package com.nyekilajos.excusetxt.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nyekilajos.excusetxt.ExcuseApplication;
import com.nyekilajos.excusetxt.R;
import com.nyekilajos.excusetxt.model.Excuse;
import com.nyekilajos.excusetxt.presenter.ExcusePresenter;
import com.nyekilajos.excusetxt.provider.ExcuseProvider;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nyeki on 2016. 04. 02..
 */
public class AddExcuseActivity extends AppCompatActivity {

    @Bind(R.id.excuse_description)
    EditText excuseDescription;

    @Bind(R.id.add_excuse_button)
    Button add;

    @Inject
    ExcusePresenter excusePresenter;

    private final View.OnClickListener onAddClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            excusePresenter.addExcuse(excuseDescription.getText().toString());
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_excuse);

        ButterKnife.bind(this);
        ExcuseApplication.getInstance().getExcuseComponent().inject(this);

        getSupportActionBar().setTitle(R.string.add_excuse_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        add.setOnClickListener(onAddClicked);
    }
}
