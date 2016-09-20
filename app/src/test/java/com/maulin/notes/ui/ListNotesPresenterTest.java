package com.maulin.notes.ui;

import com.maulin.notes.ui.listnotes.ListNotesContract;
import com.maulin.notes.ui.listnotes.ListNotesPresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by maulin on 19/9/16.
 */
public class ListNotesPresenterTest {

    @Mock
    ListNotesContract.ListNotesView mListViews;

    private ListNotesPresenter mListNotePresenter;

    @Before
    public void setupPresenter(){
        MockitoAnnotations.initMocks(this);
        mListNotePresenter=new ListNotesPresenter(mListViews);
    }

    @Test
    public void notesDisplayed_isItDisplayed() {
        mListNotePresenter.displayNotes();
       // verify(mListViews).displayNotes();
    }
}
