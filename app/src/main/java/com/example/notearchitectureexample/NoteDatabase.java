package com.example.notearchitectureexample;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance;

    public abstract NoteDataAccessObject noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext()
                    , NoteDatabase.class, "note_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDpAsyncTask(instance).execute();
        }
    };

    private static class PopulateDpAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDataAccessObject noteDao;

        private PopulateDpAsyncTask(NoteDatabase dp) {
            noteDao = dp.noteDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {

            noteDao.insert(new Note("Title1", "Des1", 1));
            noteDao.insert(new Note("Title2", "Des2", 2));
            noteDao.insert(new Note("Title3", "Des3", 3));
            return null;
        }
    }
}
