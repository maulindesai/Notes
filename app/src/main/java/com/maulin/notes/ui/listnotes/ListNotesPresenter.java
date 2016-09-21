package com.maulin.notes.ui.listnotes;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.maulin.notes.data.NoteDataSource;
import com.maulin.notes.data.NoteRepository;
import com.maulin.notes.models.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maulin on 19/9/16.
 */
public class ListNotesPresenter {

    private final ListNotesContract.ListNotesView mListNotesView;
    private final NoteRepository mNoteRepository;

    public ListNotesPresenter(NoteRepository noteRepository,ListNotesContract.ListNotesView listNotesView) {
        mListNotesView=listNotesView;
        mNoteRepository=noteRepository;
    }

    public void displayNotes() {
        mNoteRepository.getNotes(new NoteDataSource.GetNotesCallBack() {
            @Override
            public void onNotesLoaded(ArrayList<Note> notes) {
                mListNotesView.displayNotes(notes);
            }

            @Override
            public void noNotesAvaliable() {
                mListNotesView.noNotesAvaliable();
            }
        });
    }
}
