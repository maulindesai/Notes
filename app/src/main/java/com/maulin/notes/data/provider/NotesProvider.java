package com.maulin.notes.data.provider;

import android.net.Uri;

import com.maulin.notes.models.Note;

import net.simonvt.schematic.annotation.ContentProvider;
import net.simonvt.schematic.annotation.ContentUri;
import net.simonvt.schematic.annotation.InexactContentUri;
import net.simonvt.schematic.annotation.TableEndpoint;

/**
 * Created by maulin on 20/9/16.
 */
@ContentProvider(authority = NotesProvider.AUTHORITY,database = NoteDatabase.class)
public class NotesProvider {
    public static final String AUTHORITY="com.maulin.notes.NotesProvider";

    static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    interface Path {
        String NOTE_LISTS = "notelists";
        String NOTE = "note";
    }

    private static Uri buildUri(String... paths) {
        Uri.Builder builder = BASE_CONTENT_URI.buildUpon();
        for (String path : paths) {
            builder.appendPath(path);
        }
        return builder.build();
    }

    @TableEndpoint(table = NoteDatabase.NOTE_LISTS) public static class NoteLists {
        @ContentUri(
                path = Path.NOTE_LISTS,
                type = "com.maulin.notes.dir/lists"
        )
        public static final Uri NOTE_LISTS= buildUri(Path.NOTE_LISTS);
    }

    @InexactContentUri(
            path =  Path.NOTE_LISTS+ "/#",
            name = "LIST_ID",
            type = "vnd.android.cursor.item/list",
            whereColumn = NoteListCollumns._ID,
            pathSegment = 1)
    public static Uri withId(long id) {
        return buildUri(Path.NOTE_LISTS,String.valueOf(id));
    }

    @TableEndpoint(table = NoteDatabase.NOTE_LISTS) public static class NoteAdd {
        @ContentUri(
                path = Path.NOTE,
                type = "com.maulin.notes/note"
        )
        public static final Uri NOTE=buildUri(Path.NOTE);
    }
}
