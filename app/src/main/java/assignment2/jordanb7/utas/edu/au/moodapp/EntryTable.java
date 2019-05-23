package assignment2.jordanb7.utas.edu.au.moodapp;

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

}
