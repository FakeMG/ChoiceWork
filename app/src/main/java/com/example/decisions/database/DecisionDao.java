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

    @Query("SELECT :taskId FROM task")
    LiveData<Task> getTaskWithId(int taskId);

    @Query("SELECT * FROM schedule_board")
    LiveData<List<ScheduleBoard>> getAllScheduleBoards();

    @Query("SELECT :boardId FROM schedule_board")
    LiveData<ScheduleBoard> getScheduleBoardWithId(int boardId);

    @Query("SELECT * FROM task" +
            " WHERE task.task_id IN" +
            " (SELECT *" +
            " FROM schedule_board_with_tasks" +
            " WHERE schedule_board_id = :boardId)")
    LiveData<List<Task>> getAllTasksOfAScheduleBoard(int boardId);

    @Query("SELECT * FROM waiting_board")
    LiveData<List<WaitingBoard>> getAllWaitingBoards();

    @Query("SELECT :boardId FROM waiting_board")
    LiveData<WaitingBoard> getWaitingBoardWithId(int boardId);

    @Query("SELECT * FROM feeling_board")
    LiveData<List<FeelingBoard>> getAllFeelingBoards();

    @Query("SELECT :boardId FROM feeling_board")
    LiveData<FeelingBoard> getFeelingBoardWithId(int boardId);

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
