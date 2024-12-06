package com.example.notesapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DateFormat;

public class DataTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_data_test);

        // Sample of SharedPreferences
        TextView testTitle = (TextView) findViewById(R.id.test_title);
        TextView testDesc = (TextView) findViewById(R.id.test_desc);
        TextView testDate = (TextView) findViewById(R.id.test_date);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        testTitle.setText(sharedPref.getString("title", null));
        testDesc.setText(sharedPref.getString("description", null));
        long dateData = sharedPref.getLong("date", 0);
        String formatedTime = DateFormat.getDateTimeInstance().format(dateData);

        testDate.setText(formatedTime);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}