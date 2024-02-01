package com.example.practical_3;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// follow naming of Entity + Database, e.g UserDatabase
@Database(entities = {DBEntityTemplate.class}, version = 1, exportSchema = false)

public abstract class DBDatabaseTemplate extends RoomDatabase {
    public abstract DBDaoTemplate noteDao();

    // volatile ensures that changes to this variable takes place immediately, preventing potential recreation of db
    private static volatile DBDatabaseTemplate INSTANCE;

    // We've created an ExecutorService with a fixed thread pool that you will use to run database
    // operations asynchronously on a background thread.
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // getDatabase returns the singleton.
    // It'll create the database the first time it's accessed, using Room's database builder to
    // create a RoomDatabase object in the application context from the NoteRoomDatabase class
    // and names it "note_database".
    public static DBDatabaseTemplate getDatabase(final Context context) {
        if (INSTANCE == null) {
            // ensures only one thread can enter at a time, say if three threads wanted to create this db, two will wait for the first one to finish then go in one by one
            // once the second one reaches in, there is another check to see if instance is null, this is called as a double check
            // this is to prevent the second thread from recreating the db again, since it should already be created by the first thread
            synchronized (DBDatabaseTemplate.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DBDatabaseTemplate.class, "note_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            // this onCreate is only called when is the first time is called
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more notes, just add them.
                DBDaoTemplate dao = INSTANCE.noteDao();
                dao.deleteAll();

                // insert a default instance
                DBEntityTemplate note = new DBEntityTemplate("teo jie sern");
                dao.insert(note);
            });
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            // this is called when there are already an existing local db even when we restart the app
            super.onOpen(db);
        }
    };
}
