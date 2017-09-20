package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

/**
 * Created by nikunj on 14/9/17.
 */
@Database(entities = {UserDetail.class}, version=1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();

//    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
//        @Override
//        public void migrate(SupportSQLiteDatabase database) {
//            database.execSQL("ALTER TABLE product "
//                    + " ADD COLUMN price INTEGER");
//
//            // enable flag to force update products
//           // App.get().setForceUpdate(true);
//        }
//    };
}
