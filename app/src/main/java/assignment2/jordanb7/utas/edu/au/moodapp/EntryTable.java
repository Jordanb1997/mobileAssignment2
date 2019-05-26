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
    //public static final String KEY_IMAGE = "image";


    public static Entry createFromCursor(Cursor c)
    {
        if (c == null || c.isAfterLast() || c.isBeforeFirst())
        {
            return null;
        }
        else
        {
           Entry p = new Entry();
            p.setEntryID(c.getInt(c.getColumnIndex(KEY_ENTRY_ID)));
            p.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
            p.setDate(c.getInt(c.getColumnIndex(KEY_DATE)));
            p.setMood(c.getString(c.getColumnIndex(KEY_MOOD)));
            p.setText(c.getString(c.getColumnIndex(KEY_TEXT)));
            return p;
        }
    }

    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME
            + " (" + KEY_ENTRY_ID + " integer primary key autoincrement, "
            + KEY_TITLE + " , "
            + KEY_DATE + " , "
            + KEY_MOOD + " , "
            + KEY_TEXT + " "
            /*+ KEY_IMAGE + " string not null "*/
            +");";
    public static void insert(SQLiteDatabase db, Entry e)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, e.getTitle());
        values.put(KEY_DATE, e.getDate());
        values.put(KEY_MOOD, e.getMood());
        values.put(KEY_TEXT, e.getText());
        //values.put(KEY_IMAGE, e.getImage());
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
                Entry p = createFromCursor(c);
                results.add(p);
                //increment the cursor
                c.moveToNext();
            }
        }
        return results;
    }
    public static void update(SQLiteDatabase db, Entry e)
    {
        ContentValues values = new ContentValues();
        values.put(KEY_ENTRY_ID, e.getEntryID());
        values.put(KEY_TITLE, e.getTitle());
        values.put(KEY_DATE, e.getDate());
        values.put(KEY_MOOD, e.getMood());
        values.put(KEY_TEXT, e.getText());
        db.update(TABLE_NAME, values, KEY_ENTRY_ID+"= ?",
                new String[]{ ""+e.getEntryID() });
    }

    public static void delete(SQLiteDatabase db, Entry e)
    {
        db.delete(TABLE_NAME, KEY_ENTRY_ID+"= ?",new String[]{""+e.getEntryID() } );
    }
}
