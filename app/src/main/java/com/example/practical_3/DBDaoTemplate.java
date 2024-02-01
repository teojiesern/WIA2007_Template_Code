package com.example.practical_3;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DBDaoTemplate {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    // the convenience method - insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DBEntityTemplate user);

    // the query method
    @Query("DELETE FROM DBEntityTemplate")
    void deleteAll();

    // LiveData works with Room database to get instant update whenever there is any changes
    @Query("SELECT * FROM DBEntityTemplate")
    LiveData<List<DBEntityTemplate>> getAllUser();

}
