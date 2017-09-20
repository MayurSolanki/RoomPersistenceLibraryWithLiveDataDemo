package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.learnroomlifecycleslivedataviewmodel.ClickListener;
import com.demo.learnroomlifecycleslivedataviewmodel.R;
import com.demo.learnroomlifecycleslivedataviewmodel.RecyclerTouchListener;
import com.demo.learnroomlifecycleslivedataviewmodel.databinding.ActivityRoomBinding;


import java.util.List;

/**
 * Created by Mayur on 15/9/17.
 */

public class RoomActivity extends LifecycleActivity {

    Button btAddUser;
    EditText etUserName;
    private RecyclerView recyclerView;
    public UserAdapter userAdapter;
    UserLiveData userLiveData = new UserLiveData();
    ActivityRoomBinding activityRoomBinding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        activityRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_room);


        UserViewModel userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        subscribeUi(userViewModel);

        //subscribeToLiveData();


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btAddUser = (Button) findViewById(R.id.bt_submit);
        etUserName = (EditText) findViewById(R.id.et_name);


        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {

                openDialogToEdit(userAdapter.getUserDetail(position));





            }

            @Override
            public void onLongClick(View view, final int position) {


            }
        }));

        btAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etUserName.getText().toString().trim().isEmpty()) {
                    Toast.makeText(RoomActivity.this, "Username required !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {


                        UserDetail product = new UserDetail();
                        product.setUserName(etUserName.getText().toString().trim());


                        App.get().getDB().userDao().insertUserDetail(product);


                        return null;
                    }
                }.execute();


            }
        });


    }

    private void openDialogToEdit(final UserDetail userDetail) {


        AlertDialog.Builder alert = new AlertDialog.Builder(RoomActivity.this);
        alert.setTitle("Update Username");
        alert.setMessage("Modify Your Name Here");


        final EditText input = new EditText(RoomActivity.this);
        alert.setView(input);

        input.setText(userDetail.getUserName());

        alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //You will get as string input data in this variable.
                // here we convert the input to a string and show in a toast.
                String srt = input.getEditableText().toString();


                final UserDetail userDetail1 = new UserDetail();
                userDetail1.userId = userDetail.userId;
                userDetail1.setUserName(srt);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        App.get().getDB().userDao().update(userDetail1);
                    }
                }).start();




                Toast.makeText(RoomActivity.this, "User Updated ", Toast.LENGTH_LONG).show();

                dialog.dismiss();
            } // End of onClick(DialogInterface dialog, int whichButton)
        }); //End of alert.setPositiveButton
        alert.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        App.get().getDB().userDao().delete(userDetail);
                    }
                }).start();



                Toast.makeText(RoomActivity.this, "User Deleted ", Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        }); //End of alert.setNegativeButton
        AlertDialog alertDialog = alert.create();
        alertDialog.show();

    }

//    private void subscribeToLiveData() {
//
//        final Observer<List<UserDetail>> observer = new Observer<List<UserDetail>>() {
//            /**
//             * Called when the data is changed.
//             *
//             * @param userDetails The new data
//             */
//            @Override
//            public void onChanged(@Nullable List<UserDetail> userDetails) {
//                userAdapter = new UserAdapter(userDetails);
//                activityRoomBinding.recyclerView.setAdapter(userAdapter);
//            }
//
//
//        };
//
//        userLiveData.observe(this, observer);
//    }

    private void subscribeUi(UserViewModel userViewModel) {

        userViewModel.getAllUser().observe(this, new Observer<List<UserDetail>>() {
            @Override
            public void onChanged(@Nullable List<UserDetail> userDetails) {
                if (userDetails != null) {
                    userAdapter = new UserAdapter(userDetails);
                    activityRoomBinding.recyclerView.setAdapter(userAdapter);

                } else {
                    Toast.makeText(RoomActivity.this, "No data", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }


}
