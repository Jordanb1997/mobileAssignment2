package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.ClipData;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrackerFrag extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View f = inflater.inflate(R.layout.frag_tracker,container,false);

        Database databaseConnection = new Database(getActivity());
        final SQLiteDatabase db = databaseConnection.open();

        final ArrayList<Entry> entries = EntryTable.selectAll(db);

        ListView entriesList = f.findViewById(R.id.mood_list);
        EntryAdapter EntryListAdapter = new EntryAdapter(f.getContext(),android.R.layout.simple_list_item_1,entries);
        entriesList.setAdapter(EntryListAdapter);

        return f;
    }
}
