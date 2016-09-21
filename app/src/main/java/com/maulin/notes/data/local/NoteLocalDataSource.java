package com.maulin.notes.data.local;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import com.maulin.notes.data.NoteDataSource;
import com.maulin.notes.data.provider.NoteListCollumns;
import com.maulin.notes.data.provider.NotesProvider.NoteLists;
import com.maulin.notes.data.provider.generated.NotesProvider;
import com.maulin.notes.models.Note;

import java.util.ArrayList;

/**
 * Created by mcd on 21/9/16.
 */
public class NoteLocalDataSource implements NoteDataSource {

    private final ContentResolver mContentResolver;

    public NoteLocalDataSource(ContentResolver contentResolver) {
        mContentResolver=contentResolver;
    }

    @Override
    public void getNotes(final GetNotesCallBack callBacks) {
        final ArrayList<Note> notes=new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Cursor cursor=mContentResolver
                        .query(NoteLists.NOTE_LISTS,null,null,null,null);
                if(cursor!=null) {
                    if(cursor.moveToFirst()) {
                        do {
                            int id=cursor.getInt(cursor.getColumnIndex(NoteListCollumns._ID));
                            String title=cursor.getString(cursor.getColumnIndex(NoteListCollumns.TITLE));
                            String note_message=cursor.getString(cursor.getColumnIndex(NoteListCollumns.note));
                            Note note=new Note();
                            note.setId(id);
                            note.setTitle(title);
                            note.setNotes(note_message);
                            notes.add(note);
                        } while (cursor.moveToNext());
                        callBacks.onNotesLoaded(notes);
                    } else {
                        callBacks.noNotesAvaliable();
                    }
                    cursor.close();
                }
            }
        }).start();
    }

    @Override
    public void getNote(long id, GetNoteCallBack callBack) {

    }
}
