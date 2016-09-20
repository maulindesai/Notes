package com.maulin.notes.ui.listnotes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maulin.notes.models.Note;
import com.maulin.notes.ui.R;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    private final ArrayList<Note> mNotes;

    public NotesAdapter(ArrayList<Note> mNotes) {
        this.mNotes=mNotes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_notes,parent);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_note_title.setText(mNotes.get(position).getTitle());
        holder.tv_note.setText(mNotes.get(position).getNotes());
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_note;
        TextView tv_note_title;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_note_title= (TextView) itemView.findViewById(R.id.tv_note_title);
            tv_note=(TextView) itemView.findViewById(R.id.tv_note);
        }
    }
}