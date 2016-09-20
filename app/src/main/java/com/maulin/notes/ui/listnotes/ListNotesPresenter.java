package com.maulin.notes.ui.listnotes;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.maulin.notes.models.Note;

import java.util.List;

/**
 * Created by maulin on 19/9/16.
 */
public class ListNotesPresenter implements LoaderManager.LoaderCallbacks<List<Note>>{

    private final ListNotesContract.ListNotesView mListNotesView;

    public ListNotesPresenter(ListNotesContract.ListNotesView listNotesView) {
        mListNotesView=listNotesView;
    }

    public void displayNotes() {

    }

    @Override
    public Loader<List<Note>> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<List<Note>> loader, List<Note> data) {

    }

    @Override
    public void onLoaderReset(Loader<List<Note>> loader) {

    }

}
