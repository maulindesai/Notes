package com.maulin.notes.ui.addNotes;

import com.maulin.notes.models.Note;

/**
 * Created by mcd on 23/9/16.
 */
public interface AddNoteContract {
    interface AddNoteContractPresenter {
        void addNote(Note note);
    }
    interface AddNoteView {
        void addNoteButtonClicked();
        String getNoteTitle();
        String getNoteMessage();
        void showNoteMessageError(String message);
        void showNoteTitleError(String message);
    }
}
