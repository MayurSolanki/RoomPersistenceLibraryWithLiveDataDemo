package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.core.util.Function;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;

import java.util.List;

/**
 * Created by nikunj on 14/9/17.
 */

public class UserLiveData extends LiveData<List<UserDetail>> {

    private LiveData<List<UserDetail>> mObservableProducts;

    public UserLiveData(){

        mObservableProducts = new LiveData<List<UserDetail>>() {
            @Override
            protected void setValue(List<UserDetail> value) {
                super.setValue(value);
            }
        };
    }




    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    protected void onActive() {
        super.onActive();
    }
}
