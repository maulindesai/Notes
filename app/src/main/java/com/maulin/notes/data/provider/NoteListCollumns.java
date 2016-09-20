package com.maulin.notes.data.provider;

import net.simonvt.schematic.annotation.AutoIncrement;
import net.simonvt.schematic.annotation.DataType;
import net.simonvt.schematic.annotation.PrimaryKey;

/**
 * Created by maulin on 20/9/16.
 */
public interface NoteListCollumns {
    @DataType(DataType.Type.INTEGER)
    @PrimaryKey
    @AutoIncrement
    String _ID="_id";

    @DataType(DataType.Type.TEXT)
    String TITLE="title";

    @DataType(DataType.Type.TEXT)
    String note="note";
}
