package com.maulin.notes.ui;

import com.maulin.notes.data.NoteRepository;
import com.maulin.notes.models.Note;
import com.maulin.notes.ui.addNotes.AddNoteContract;
import com.maulin.notes.ui.addNotes.AddNotePresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mcd on 23/9/16.
 */
public class AddNotesPresenterTest {

    @Mock
    AddNoteContract.AddNoteView mAddNoteView;

    @Mock
    NoteRepository mNoteRepository;
    private AddNotePresenter addNotePresenter;
    private Note NOTE;

    Note generateDummyNote() {
       Note note=new Note();
        note.setId(3);
        note.setTitle("Notes added");
        note.setNotes("Nnnnnotes donee");
        return note;
    }

    @Before
    void setUpAddNotesPresenter() {
        MockitoAnnotations.initMocks(this);
        addNotePresenter=new AddNotePresenter(mNoteRepository);
        NOTE=generateDummyNote();
    }

    @Test
    void AddNote_isNoteAdded() {
        addNotePresenter.addNote(NOTE);
        verify(mNoteRepository).addNote(NOTE);
    }

    @Test
    void ErrorNote_isNoteErrorDisplay() {
        addNotePresenter.addNote(NOTE);
        //show error on note message editText
        when(mAddNoteView.getNoteMessage()).thenReturn("");
        when(mAddNoteView.getNoteTitle()).thenReturn("");
        verify(mAddNoteView).showNoteMessageError("Note Message Not Empty");
        verify(mAddNoteView).showNoteTitleError("Note Message Not Empty");
    }
}
