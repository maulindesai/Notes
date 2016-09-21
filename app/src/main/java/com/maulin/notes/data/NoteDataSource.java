package com.maulin.notes.data;

import com.maulin.notes.models.Note;

import java.util.ArrayList;

/**
 * Created by mcd on 21/9/16.
 */
public interface NoteDataSource {
    void getNotes(GetNotesCallBack callBacks);
    void getNote(long id,GetNoteCallBack callBack);

    interface GetNotesCallBack {
        void onNotesLoaded(ArrayList<Note> notes);
        void noNotesAvaliable();
    }

    interface GetNoteCallBack {
        void onNotesLoaded(Note note);
        void noNoteAvaliable();
    }

}
