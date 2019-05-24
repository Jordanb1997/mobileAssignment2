package assignment2.jordanb7.utas.edu.au.moodapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EntriesFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //TextView lblTitle = findViewById(R.id.lblEnteredText);


        return inflater.inflate(R.layout.frag_entries,container,false);
    }
}
