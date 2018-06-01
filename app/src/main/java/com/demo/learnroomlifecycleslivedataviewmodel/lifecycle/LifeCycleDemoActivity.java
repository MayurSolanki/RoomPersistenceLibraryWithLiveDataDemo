package com.demo.learnroomlifecycleslivedataviewmodel.lifecycle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.demo.learnroomlifecycleslivedataviewmodel.R;

/**
 * Created by nikunj on 13/9/17.
 */

public class LifeCycleDemoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);


    }
}
