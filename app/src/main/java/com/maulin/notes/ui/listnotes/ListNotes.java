package com.maulin.notes.ui.listnotes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maulin.notes.models.Note;
import com.maulin.notes.ui.R;
import com.maulin.notes.ui.listnotes.ListNotesContract.ListNotesView;

import java.util.ArrayList;

public class ListNotes extends AppCompatActivity implements ListNotesView{

    private RecyclerView rlNoteList;
    private ArrayList<Note> mNotes=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_notes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        rlNoteList= (RecyclerView) findViewById(R.id.rl_notes_list);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /**
         * set up recycler view with adapter
         */
        rlNoteList.setHasFixedSize(true);
        rlNoteList.setLayoutManager(new GridLayoutManager(this,3));
        rlNoteList.setAdapter(new NotesAdapter(mNotes));
    }

    @Override
    public void displayNotes(ArrayList<Note> notes) {
        mNotes=notes;
        rlNoteList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void noNotesAvaliable() {
        TextView textView=new TextView(this);
        textView.setText("No Item Avaliable");
        rlNoteList.addView(textView);
    }
}
