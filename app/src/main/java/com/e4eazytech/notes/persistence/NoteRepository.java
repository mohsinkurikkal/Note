package com.e4eazytech.notes.persistence;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.e4eazytech.notes.async.InsertAsyncTask;
import com.e4eazytech.notes.models.Note;

import java.util.List;

public class NoteRepository {

    private NoteDatabase mNoteDatabase;

    public NoteRepository(Context context) {
        mNoteDatabase = NoteDatabase.getInstance(context);
    }

    public void insertNoteTask(Note note){
        new InsertAsyncTask(mNoteDatabase.getNoteDao()).execute(note);

    }

    public void updateNote(Note note){

    }

    public LiveData<List<Note>> retrieveNotesTask(){
        return mNoteDatabase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note){

    }
}
