package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by nikunj on 14/9/17.
 */
@Entity
public class UserDetail {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    int userId;

    @ColumnInfo(name = "name")
    private String userName;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
