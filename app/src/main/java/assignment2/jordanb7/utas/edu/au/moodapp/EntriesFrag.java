package assignment2.jordanb7.utas.edu.au.moodapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EntriesFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.frag_entries,container,false);

        Database databaseConnection = new Database(getActivity());
        final SQLiteDatabase db = databaseConnection.open();

        final ArrayList<Entry> entries = EntryTable.selectAll(db);

        ListView entriesList = getView().findViewById(R.id.entriesList);
        EntryAdapter EntryListAdapter = new EntryAdapter(getView().getContext(),android.R.layout.simple_list_item_1,entries);
        entriesList.setAdapter(EntryListAdapter);

        return fragView;
    }

}
