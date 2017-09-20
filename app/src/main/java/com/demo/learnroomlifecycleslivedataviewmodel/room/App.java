package com.demo.learnroomlifecycleslivedataviewmodel.room;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by nikunj on 15/9/17.
 */

public class App extends Application {
    public static App INSTANCE;
    private static final String DATABASE_NAME = "UserDb";

    private UserDatabase userDatabase;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize User Db
        userDatabase = Room.databaseBuilder(getApplicationContext(), UserDatabase.class, DATABASE_NAME)
                //.addMigrations(UserDatabase.MIGRATION_1_2)
                .build();

        INSTANCE = this;
    }
    public UserDatabase getDB() {
        return userDatabase;
    }
}
