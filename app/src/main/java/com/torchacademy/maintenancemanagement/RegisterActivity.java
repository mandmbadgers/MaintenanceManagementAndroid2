package com.torchacademy.maintenancemanagement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by neam.farroukh on 6/20/2016.
 */
public class RegisterActivity extends AppCompatActivity {
    Spinner spinner_building;
    List<String> building_lables;
    List<String> floor_lables;
    Spinner spinner_floor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {


            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
            getSupportActionBar().hide();

        }

        setContentView(R.layout.activity_register);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        setUpViews();
        building_lables = new ArrayList<>();
        floor_lables = new ArrayList<>();
        building_lables.add("Building Name");
        building_lables.add("Building 1");
        building_lables.add("Building 2");


        floor_lables.add("Floor #");
        floor_lables.add("Floor one");
        floor_lables.add("Floor two");
        loadSpinnerData();

    findViewById(R.id.button_submit).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(RegisterActivity.this, ValidationActivity.class));
        }
    });
    }

    private void loadSpinnerData() {

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, R.id.textview_spinner_item, building_lables);

        //Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);

        // attaching data adapter to spinner
        spinner_building.setAdapter(dataAdapter);


        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                R.layout.spinner_item, R.id.textview_spinner_item, floor_lables);

        //Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(R.layout.spinner_item);

        // attaching data adapter to spinner
        spinner_floor.setAdapter(dataAdapter2);
        ;
       /* final ArrayAdapter<String> adapter1 = new CustomizedSpinnerAdapter(
                RegisterActivity.this, android.R.layout.simple_spinner_item,
                building_lables);
        spinner_building.setAdapter(adapter1);*/
    }

    private void setUpViews() {
        spinner_building = (Spinner) findViewById(R.id.spinner_building);
        spinner_floor = (Spinner) findViewById(R.id.spinner_floor);

    }
}
