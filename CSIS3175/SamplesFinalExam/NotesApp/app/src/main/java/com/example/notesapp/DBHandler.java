package com.example.notesapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "notesdb";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "mynotes";

    private static final String TITLE_COL = "title";

    private static final String DESCRIPTION_COL = "description";

    private static final String TIME_COL = "time";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                                            + TITLE_COL + " TEXT, "
                + DESCRIPTION_COL + " TEXT, "
                + TIME_COL + " INTEGER)";

        sqLiteDatabase.execSQL(query);
    }

    public void addNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(TITLE_COL, note.getTitle());
        values.put(DESCRIPTION_COL, note.getDescription());
        values.put(TIME_COL, note.getCreatedTime());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }



    public List<Note> getAllNotes(){
        List<Note> noteList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(cursor.getColumnIndex(TITLE_COL));
                String description = cursor.getString(cursor.getColumnIndex(DESCRIPTION_COL));
                long date = cursor.getLong(cursor.getColumnIndex(TIME_COL)); // Get timestamp

                noteList.add(new Note(title, description, date));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return noteList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
