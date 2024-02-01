package com.example.practical_3;

// This should be named as the actual entity name, i.e. like User, or MoodNote

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class DBEntityTemplate {
    @PrimaryKey(autoGenerate = true)
    public int userId;

    public String userName;

    public DBEntityTemplate(@NonNull String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }
}
