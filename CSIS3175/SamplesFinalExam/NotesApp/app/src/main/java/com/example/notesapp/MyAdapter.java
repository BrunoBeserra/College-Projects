package com.example.notesapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<Note> notesList;

    public MyAdapter(Context context, List<Note> notesList){
        this.context = context;
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        Log.d("MyAdapter", "Binding note at position " + position);
        Log.d("MyAdapter", "Note title: " + note.getTitle());

        holder.titleItem.setText(note.getTitle());
        holder.descriptionItem.setText(note.getDescription());

        // Format the timestamp to a readable date
        String formatedTime = DateFormat.getDateTimeInstance().format(note.getCreatedTime());
        holder.timeCreatedItem.setText(formatedTime);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleItem;
        TextView descriptionItem;
        TextView timeCreatedItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleItem = itemView.findViewById(R.id.titleItem);
            descriptionItem = itemView.findViewById(R.id.descriptionItem);
            timeCreatedItem = itemView.findViewById(R.id.timeCreatedItem);
        }
    }
    public void updateNotes(List<Note> newNotes) {
        this.notesList = newNotes;
        notifyDataSetChanged();
    }
}
