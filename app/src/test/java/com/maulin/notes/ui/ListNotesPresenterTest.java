package com.maulin.notes.ui;

import com.maulin.notes.data.NoteDataSource;
import com.maulin.notes.data.NoteRepository;
import com.maulin.notes.models.Note;
import com.maulin.notes.ui.listnotes.ListNotesContract;
import com.maulin.notes.ui.listnotes.ListNotesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;

import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.verify;

/**
 * Created by maulin on 19/9/16.
 */
public class ListNotesPresenterTest {

    @Mock
    ListNotesContract.ListNotesView mListViews;

    @Mock
    NoteRepository mNoteRepository;

    private ListNotesPresenter mListNotePresenter;
    private ArgumentCaptor<NoteDataSource.GetNotesCallBack> mArgumentCapator;
    private ArrayList<Note> mNotes;


    @Before
    public void setupPresenter(){
        mNotes=createDummyNotes();
        mArgumentCapator=ArgumentCaptor.forClass(NoteDataSource.GetNotesCallBack.class);
        MockitoAnnotations.initMocks(this);
        mListNotePresenter=new ListNotesPresenter(mNoteRepository,mListViews);
    }

    private ArrayList<Note> createDummyNotes() {
        ArrayList<Note> notes=new ArrayList<>();
        Note note=new Note();
        note.setId(1);
        note.setTitle("hello");
        note.setNotes("hello hi");
        notes.add(note);
        note.setId(2);
        note.setNotes("g");
        note.setTitle("gf");
        notes.add(note);
        return notes;
    }

    @Test
    public void notesDisplayed_isItDisplayed() {
        mListNotePresenter.displayNotes();
        verify(mNoteRepository).getNotes(mArgumentCapator.capture());
        mArgumentCapator.getValue().onNotesLoaded(mNotes);
        verify(mListViews).displayNotes(mNotes);
    }

    @Test
    public void noNoteDisplayed_noNotesAvaliable() {
        mListNotePresenter.displayNotes();
        verify(mNoteRepository).getNotes(mArgumentCapator.capture());
        mArgumentCapator.getValue().noNotesAvaliable();
        verify(mListViews).noNotesAvaliable();
    }
}
