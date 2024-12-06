package com.example.notesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView notesRecyclerView;
    MyAdapter noteAdapter;
    List<Note> notesList;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        notesList = new ArrayList<>();

        loadNotes();

        // Set button action
        Button addNoteBt = (Button) findViewById(R.id.bt_app);
        addNoteBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });

        // RecyclerView to get data from list
        notesRecyclerView = findViewById(R.id.rv_app);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        noteAdapter = new MyAdapter(this, notesList);
        notesRecyclerView.setAdapter(noteAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void loadNotes(){
        // Retrieve Data from SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Get the number of saved notes
        int notesCount = sharedPreferences.getInt("notes_count", 0);

        // Clear previous list and load notes
        notesList.clear();
        for (int i = 0; i < notesCount; i++) {
            String title = sharedPreferences.getString("note_title_" + i, null);
            String description = sharedPreferences.getString("note_description_" + i, null);
            long date = sharedPreferences.getLong("note_date_" + i, -1);
            // String formatedTime = DateFormat.getDateTimeInstance().format(date);

            if (title != null && description != null && date != -1) {
                Note note = new Note(title, description, date);
                notesList.add(note);
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Retrieve the new note from SharedPreferences
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String title = sharedPreferences.getString("title", null);
        String description = sharedPreferences.getString("description", null);
        long date = sharedPreferences.getLong("date", -1);

        if (title != null && description != null && date != -1) {
            Note note = new Note(title, description, date);
            notesList.add(note);

            // Save the updated list to SharedPreferences
            saveNotes();

            // Update the adapter
            noteAdapter.notifyDataSetChanged();

            // Clear the temporary SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("title");
            editor.remove("description");
            editor.remove("date");
            editor.apply();
        }
    }

    private void saveNotes() {
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Save the number of notes
        editor.putInt("notes_count", notesList.size());

        // Save each note's details
        for (int i = 0; i < notesList.size(); i++) {
            Note note = notesList.get(i);
            editor.putString("note_title_" + i, note.getTitle());
            editor.putString("note_description_" + i, note.getDescription());
            editor.putLong("note_date_" + i, note.getCreatedTime());
        }
        editor.apply();
    }
}