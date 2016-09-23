package com.maulin.notes.ui.addNotes;

import com.maulin.notes.data.NoteRepository;
import com.maulin.notes.models.Note;

/**
 * Created by mcd on 23/9/16.
 */
public class AddNotePresenter implements AddNoteContract.AddNoteContractPresenter{

    private final NoteRepository mNoteRepositroy;

    public AddNotePresenter(NoteRepository noteRepository) {
        mNoteRepositroy=noteRepository;
    }

    @Override
    public void addNote(Note note) {

    }
}
