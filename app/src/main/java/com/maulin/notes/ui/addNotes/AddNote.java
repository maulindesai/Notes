package com.maulin.notes.ui.addNotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maulin.notes.ui.R;

public class AddNote extends AppCompatActivity implements AddNoteContract.AddNoteView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    @Override
    public void addNoteButtonClicked() {

    }

    @Override
    public String getNoteTitle() {
        return null;
    }

    @Override
    public String getNoteMessage() {
        return null;
    }

    @Override
    public void showNoteMessageError(String message) {

    }

    @Override
    public void showNoteTitleError(String message) {

    }
}
