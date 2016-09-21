package com.maulin.notes.data;

import com.maulin.notes.data.local.NoteLocalDataSource;
import com.maulin.notes.data.remote.NoteRemoteDataSource;
import com.maulin.notes.models.Note;

import java.util.ArrayList;

/**
 * Created by mcd on 21/9/16.
 */
public class NoteRepository implements NoteDataSource {
    private final NoteRemoteDataSource mNoteRemoteDataSource;
    private final NoteLocalDataSource mNoteLocaDataSource;

    /**
     * repository constructor
     * @param noteLocalDataSource local
     * @param noteRemoteDataSource remote
     */
    public NoteRepository(NoteLocalDataSource noteLocalDataSource,
                          NoteRemoteDataSource noteRemoteDataSource) {
            mNoteLocaDataSource=noteLocalDataSource;
            mNoteRemoteDataSource=noteRemoteDataSource;
    }

    @Override
    public void getNotes(final GetNotesCallBack callBacks) {
        //no needed loaded by loader
        mNoteLocaDataSource.getNotes(new GetNotesCallBack() {
            @Override
            public void onNotesLoaded(ArrayList<Note> notes) {
                callBacks.onNotesLoaded(notes);
            }

            @Override
            public void noNotesAvaliable() {
                callBacks.noNotesAvaliable();
            }
        });
    }

    @Override
    public void getNote(long id, GetNoteCallBack callBack) {
        // no needed loaded by loader
    }
}
