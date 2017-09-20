package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.app.Application;
import android.arch.core.util.Function;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Observable;
import android.databinding.ObservableField;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by nikunj on 14/9/17.
 */

public class UserViewModel extends AndroidViewModel {


    Context context;
    private LiveData<List<UserDetail>> mObservableProducts;
    public ObservableField<Integer> btnAddUser = new ObservableField<>();
    public ObservableField<String> userName = new ObservableField<>("");

    public UserViewModel(Application application) {
        super(application);
        context = application;

        mObservableProducts  = App.get().getDB().userDao().getAllUser();


    }



    public void insertUserInDb(final String username){

        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDetail product = new UserDetail();
                product.setUserName(username);
                App.get().getDB().userDao().insertUserDetail(product);
            }
        }).start();

    }

    public void updateUserInfo(final UserDetail userDetail){
        new Thread(new Runnable() {
            @Override
            public void run() {
                App.get().getDB().userDao().update(userDetail);
            }
        }).start();

    }

    public void deleteUserInfo(final UserDetail userDetail){
        new Thread(new Runnable() {
            @Override
            public void run() {
                App.get().getDB().userDao().delete(userDetail);
            }
        }).start();
    }




    public LiveData<List<UserDetail>> getAllUser() {
        return mObservableProducts;
    }







}
