package com.maulin.notes.data.provider;

import net.simonvt.schematic.annotation.Database;
import net.simonvt.schematic.annotation.Table;

/**
 * Created by maulin on 20/9/16.
 */
@Database(version = NoteDatabase.VERSION)
public class NoteDatabase {
    public static final int VERSION=1;
    @Table(NoteListCollumns.class)
    public static final String NOTE_LISTS="note_lists";
}
