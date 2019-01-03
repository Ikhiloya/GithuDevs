package com.loya.githubdevs;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.loya.githubdevs.model.GitItem;

@Database(entities = {GitItem.class}, version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {
    private static volatile UserRoomDatabase INSTANCE;

    public abstract UserDao userDao();

    static UserRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UserRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UserRoomDatabase.class, "user_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}