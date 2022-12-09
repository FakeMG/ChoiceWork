package com.example.decisions.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "waiting_board", foreignKeys = {
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "main_task_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "next_task1_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "next_task2_id",
                onDelete = ForeignKey.CASCADE
        )
})
public class WaitingBoard {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "board_id")
    public int boardId;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "main_task_id")
    public int mainTaskId;

    @ColumnInfo(name = "timer_minute")
    public int timerMinute;

    @ColumnInfo(name = "next_task1_id")
    public int nextTask1Id;

    @ColumnInfo(name = "next_task2_id")
    public int nextTask2Id;

    public WaitingBoard(String name, int mainTaskId, int timerMinute, int nextTask1Id, int nextTask2Id) {
        this.name = name;
        this.mainTaskId = mainTaskId;
        this.timerMinute = timerMinute;
        this.nextTask1Id = nextTask1Id;
        this.nextTask2Id = nextTask2Id;
    }
}
