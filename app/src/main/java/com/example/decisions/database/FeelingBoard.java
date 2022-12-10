package com.example.decisions.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "feeling_board", foreignKeys = {
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "main_task_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "solution_task1_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "solution_task2_id",
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
public class FeelingBoard {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "board_id")
    public int boardId;

    @ColumnInfo
    public String name;

    @ColumnInfo(name = "main_task_id")
    public int mainTaskId;

    @ColumnInfo(name = "solution_task1_id")
    public int solutionTask1Id;

    @ColumnInfo(name = "solution_task2_id")
    public int solutionTask2Id;

    @ColumnInfo(name = "next_task1_id")
    public int nextTask1Id;

    @ColumnInfo(name = "next_task2_id")
    public int nextTask2Id;

    public FeelingBoard(String name, int mainTaskId, int solutionTask1Id, int solutionTask2Id, int nextTask1Id, int nextTask2Id) {
        this.name = name;
        this.mainTaskId = mainTaskId;
        this.solutionTask1Id = nextTask1Id;
        this.solutionTask2Id = solutionTask2Id;
        this.nextTask1Id = nextTask1Id;
        this.nextTask2Id = nextTask2Id;
    }
}
