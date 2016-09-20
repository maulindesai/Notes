package com.maulin.notes.ui.listnotes;

import com.maulin.notes.models.Note;

import java.util.ArrayList;

/**
 * Created by maulin on 19/9/16.
 */
public class ListNotesContract {
    public  interface ListNotesView {
        void displayNotes(ArrayList<Note> notes);
    }
}
