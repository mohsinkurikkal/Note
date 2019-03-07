package com.e4eazytech.notes.async;

import android.os.AsyncTask;

import com.e4eazytech.notes.models.Note;
import com.e4eazytech.notes.persistence.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {
    private NoteDao mNoteDao;
    public InsertAsyncTask(NoteDao dao) {
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insertNotes(notes);
        return null;
    }
}
