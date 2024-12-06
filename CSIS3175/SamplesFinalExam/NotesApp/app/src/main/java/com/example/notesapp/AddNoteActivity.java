package com.example.notesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddNoteActivity extends AppCompatActivity {
    String noteTitle;
    String noteDescription;
    long noteTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_note);

        EditText titleInput = findViewById(R.id.noteTitle);
        EditText descriptionInput = findViewById(R.id.noteDescription);
        Button saveNoteButton = findViewById(R.id.addNotePageButton);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        saveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteTitle = titleInput.getText().toString();
                noteDescription = descriptionInput.getText().toString();
                noteTime = System.currentTimeMillis();

                if (noteTitle.isEmpty() || noteDescription.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                Note note = new Note(noteTitle, noteDescription, noteTime);

                // Sample use of sharedPreferences
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("title", note.getTitle());
                editor.putString("description", note.getDescription());
                editor.putLong("date", note.getCreatedTime());
                editor.apply();

                Toast.makeText(AddNoteActivity.this, "Note Created", Toast.LENGTH_SHORT).show();
                finish();

                startActivity(new Intent(AddNoteActivity.this, MainActivity.class));

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}