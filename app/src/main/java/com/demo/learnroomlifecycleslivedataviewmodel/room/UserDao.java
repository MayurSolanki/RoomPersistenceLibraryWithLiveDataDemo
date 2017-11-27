package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by nikunj on 14/9/17.
 */
@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUserDetail(UserDetail userDetail);

    @Query("SELECT user_id,name FROM UserDetail")
    LiveData<List<UserDetail>> getAllUser();


//    @Query("SELECT name FROM UserDetail WHERE name LIKE :name LIMIT 1")
//    UserDetail findByName(String name);

    @Insert
    void insertAll(List<UserDetail> products);

    @Update
    void update(UserDetail userDetail);

    @Delete
    void delete(UserDetail userDetail);
}
