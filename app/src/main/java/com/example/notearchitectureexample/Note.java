package com.example.notearchitectureexample;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
private int mID;
    private String mtitle;
    private String mDescription;
    private int mPriority;

    public Note(String mtitle, String description, int priority) {
        this.mtitle = mtitle;
        mDescription = description;
        mPriority = priority;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public int getID() {
        return mID;
    }

    public String getMtitle() {
        return mtitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getPriority() {
        return mPriority;
    }
}
