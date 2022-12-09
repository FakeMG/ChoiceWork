package com.example.decisions.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DecisionRepository {
    private DecisionDao mDecisionDao;
    private LiveData<List<Task>> mAllTasks;

    public DecisionRepository(Application application) {
        DecisionDatabase db = DecisionDatabase.getDatabase(application);
        mDecisionDao = db.decisionDao();
        mAllTasks = mDecisionDao.getAllTasks();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Task>> getAllTasks() {
        return mAllTasks;
    }

    public void insertTask(Task task) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mDecisionDao.insertTask(task);
        });
    }

    public void insertScheduleBoard(ScheduleBoard scheduleBoard) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mDecisionDao.insertScheduleBoard(scheduleBoard);
        });
    }

    public void insertWaitingBoard(WaitingBoard waitingBoard) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mDecisionDao.insertWaitingBoard(waitingBoard);
        });
    }

    public void insertFeelingBoard(FeelingBoard feelingBoard) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mDecisionDao.insertFeelingBoard(feelingBoard);
        });
    }

    public void insertScheduleBoardWithTask(ScheduleBoardWithTasks scheduleBoardWithTasks) {
        DecisionDatabase.databaseWriteExecutor.execute(() -> {
            mDecisionDao.insertScheduleBoardWithTask(scheduleBoardWithTasks);
        });
    }
}
