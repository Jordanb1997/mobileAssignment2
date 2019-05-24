package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EntryTable {
    public static final String TABLE_NAME = "entries";
    public static final String KEY_ENTRY_ID = "entry_id";
    public static final String KEY_TITLE = "title";
    public static final String KEY_DATE = "date";
    public static final String KEY_MOOD = "mood";
    public static final String KEY_TEXT = "text";
    public static final String KEY_IMAGE = "image";

    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME
            + " (" + KEY_ENTRY_ID + " integer primary key autoincrement, "
            + KEY_TITLE + " string not null, "
            + KEY_DATE + " int not null, "
            + KEY_MOOD + " string not null, "
            + KEY_TEXT + " string not null, "
            + KEY_IMAGE + " string not null "
            +");";
    public static void insert(SQLiteDatabase db, Entry e)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, e.getTitle());
        values.put(KEY_DATE, e.getDate());
        values.put(KEY_MOOD, e.getMood());
        values.put(KEY_TEXT, e.getText());
        values.put(KEY_IMAGE, e.getImage());
        db.insert(TABLE_NAME, null, values);
    }
    public static ArrayList<Entry> selectAll(SQLiteDatabase db)
    {
        ArrayList<Entry> results = new ArrayList<Entry>();
        Cursor c = db.query(TABLE_NAME, null, null, null, null, null, null);

        //check for error
        if (c != null)
        {
            //make sure the cursor is at the start of the list
            c.moveToFirst();
            //loop through until we are at the end of the list
            while (!c.isAfterLast())
            {
                Entry e = createFromCursor(c);
                results.add(e);
                //increment the cursor
                c.moveToNext();
            }
        }
        return results;
    }


}
