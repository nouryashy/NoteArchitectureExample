package com.example.notearchitectureexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> mNotes = new ArrayList<>();

//    public NoteAdapter(List<Note> notes, Context context) {
//        mContext = context;
//        mNotes = notes;
//    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.NoteBind(mNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void setNotes(List<Note> notes) {
        this.mNotes = notes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;
        private TextView mPriority;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.text_view_title);
            mDescription = itemView.findViewById(R.id.text_view_description);
            mPriority = itemView.findViewById(R.id.text_view_priority);

        }

        public void NoteBind(Note note) {
            mTitle.setText(note.getTitle());
            mDescription.setText(note.getDescription());
            mPriority.setText(String.valueOf(note.getPriority()));
        }
    }
}
