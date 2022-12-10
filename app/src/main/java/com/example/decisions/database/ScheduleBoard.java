package com.example.decisions.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "schedule_board", foreignKeys = {
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
public class ScheduleBoard {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "board_id")
    public int boardId;

    @ColumnInfo
    public String name;

    @ColumnInfo(name = "next_task1_id")
    public int nextTask1;

    @ColumnInfo(name = "next_task2_id")
    public int nextTask2;

    public ScheduleBoard(String name, int nextTask1, int nextTask2) {
        this.name = name;
        this.nextTask1 = nextTask1;
        this.nextTask2 = nextTask2;
    }
}
