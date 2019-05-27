package assignment2.jordanb7.utas.edu.au.moodapp;

public class Entry {
    private int mEntryID;
    private String mTitle;
    private String mDate;
    private String mMood;
    private String mText;
    private String mImage;

    public int getEntryID() { return mEntryID; }
    public void setEntryID(int s) { this.mEntryID = s; }

    public String getTitle() { return mTitle; }
    public void setTitle(String s) { this.mTitle= s; }

    public String getDate() { return mDate; }
    public void setDate(String s) { this.mDate= s; }

    public String getMood() { return mMood; }
    public void setMood(String s) { this.mMood= s; }

    public String getText() { return mText; }
    public void setText(String s) { this.mText= s; }

    public String getImage() { return mImage; }
    public void setImage(String s) { this.mImage= s; }
}
