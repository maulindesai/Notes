package com.maulin.notes.data.provider;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.maulin.notes.models.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maulin on 19/9/16.
 */
public class NotesLoader extends AsyncTaskLoader<List<Note>> {

    List<Note> mNotes;

    public NotesLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
    }

    @Override
    public List<Note> loadInBackground() {
        return null;
    }

    @Override
    public void deliverResult(List<Note> data) {
        super.deliverResult(data);
    }
}
