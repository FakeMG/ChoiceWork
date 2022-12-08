package com.example.decisions.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Task.class}, version = 1, exportSchema = false)
public abstract class DecisionDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();

    private static volatile DecisionDatabase INSTANCE = null;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static DecisionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DecisionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DecisionDatabase.class, "choiceWork")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
