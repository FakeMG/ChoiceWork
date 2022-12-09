package com.example.decisions.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DecisionDao {
    @Query("SELECT * FROM task")
    LiveData<List<Task>> getAllTasks();

    @Query("SELECT * FROM schedule_board")
    LiveData<List<ScheduleBoard>> getScheduleBoard();

    @Query("SELECT * FROM waiting_board")
    LiveData<List<WaitingBoard>> getWaitingBoard();

    @Query("SELECT * FROM feeling_board")
    LiveData<List<FeelingBoard>> getFeelingBoard();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTask(Task... activities);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertScheduleBoard(ScheduleBoard... scheduleBoards);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWaitingBoard(WaitingBoard... waitingBoard);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFeelingBoard(FeelingBoard... feelingBoards);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertScheduleBoardWithTask(ScheduleBoardWithTasks... scheduleBoardWithTasks);
}
