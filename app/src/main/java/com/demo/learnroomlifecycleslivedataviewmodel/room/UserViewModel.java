package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.database.Observable;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.util.List;

/**
 * Created by nikunj on 14/9/17.
 */

public class UserViewModel extends AndroidViewModel {


    private LiveData<List<UserDetail>> mObservableProducts;


    public ObservableField<Integer> btnAddUser = new ObservableField<>();
    public ObservableField<String> userName = new ObservableField<>("");

    public UserViewModel(Application application) {
        super(application);


//        UserDetail product = new UserDetail();
//        product.setUserName("ABCD");
//
//        App.get().getDB().userDao().insertUserDetail(product);

        mObservableProducts  = App.get().getDB().userDao().getAllUser();

      //  Log.e("mObservabProducts Size ",""+mObservableProducts.getValue().size());

    }

    //   list.add(product);


        // insert product list into database

      //  App.get().getDB().userDao().insertUserDetail(product);







    public void btnAddUserClicked(){

        UserDetail product = new UserDetail();
        product.setUserName(userName.get());

        //   list.add(product);


        // insert product list into database

        App.get().getDB().userDao().insertUserDetail(product);

    }


    public LiveData<List<UserDetail>> getAllUser() {
        return mObservableProducts;
    }





}
