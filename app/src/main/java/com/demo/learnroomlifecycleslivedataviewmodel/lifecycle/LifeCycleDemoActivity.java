package com.demo.learnroomlifecycleslivedataviewmodel.lifecycle;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demo.learnroomlifecycleslivedataviewmodel.R;

/**
 * Created by nikunj on 13/9/17.
 */

public class LifeCycleDemoActivity extends LifecycleActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle_demo);



    }
}
