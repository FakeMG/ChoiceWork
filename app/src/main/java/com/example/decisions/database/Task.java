package com.example.decisions.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_id")
    public int taskId;

    @ColumnInfo
    public String name;

    @ColumnInfo(name = "file_name")
    public String fileName;

    public Task(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }
}
