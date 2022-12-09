package com.example.decisions.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;

@Entity(tableName = "schedule_board_with_tasks", primaryKeys = {"schedule_board_id", "task_id"}, foreignKeys = {
        @ForeignKey(
                entity = ScheduleBoard.class,
                parentColumns = "board_id",
                childColumns = "schedule_board_id",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Task.class,
                parentColumns = "task_id",
                childColumns = "task_id",
                onDelete = ForeignKey.CASCADE
        )
})
class ScheduleBoardWithTasks {
    @ColumnInfo(name = "schedule_board_id")
    public int scheduleBoardId;

    @ColumnInfo(name = "task_id")
    public int taskId;

    public ScheduleBoardWithTasks(int scheduleBoardId, int taskId) {
        this.scheduleBoardId = scheduleBoardId;
        this.taskId = taskId;
    }
}
