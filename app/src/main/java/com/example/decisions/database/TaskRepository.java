package com.example.decisions.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TaskRepository {
    private TaskDao mTaskDao;
    private LiveData<List<Task>> mAllTasks;

    public TaskRepository(Application application) {
        DecisionDatabase db = DecisionDatabase.getDatabase(application);
        mTaskDao = db.taskDao();
        mAllTasks = mTaskDao.getAllTasks();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Task task) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mTaskDao.insert(task);
        });
    }
}
