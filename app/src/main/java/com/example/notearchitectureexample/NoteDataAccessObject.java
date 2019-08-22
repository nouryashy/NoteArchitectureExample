package com.example.notearchitectureexample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDataAccessObject {
    @Insert
    void insert(Note note);

    @Update
    void upDate(Note note);

    @Delete
    void delete(Note note);
    @Query("DELETE FROM note_table")
    void deleteAllNotes();
@Query("SELECT*FROM note_table ORDER BY mPriority DESC")
  LiveData <List<Note>>getAllNote();


}