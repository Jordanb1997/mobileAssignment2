package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class EntriesFrag extends Fragment {
    Intent expand;
    ListView entriesList;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.frag_entries,container,false);

        Database databaseConnection = new Database(getActivity());
        final SQLiteDatabase db = databaseConnection.open();

        final ArrayList<Entry> entries = EntryTable.selectAll(db);

        for(int i = 0; i < entries.size(); i++)
        {
            Entry p = entries.get(i);
            Log.d("entryfrag", p.getEntryID() + ":" + p.getTitle() + ":" + p.getText());
        }

        expand = new Intent(getActivity(), EntryView.class);


        final ListView entriesList = fragView.findViewById(R.id.entriesList);
        EntryAdapter EntryListAdapter = new EntryAdapter(fragView.getContext(),android.R.layout.simple_list_item_1,entries);


        entriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final Entry p = entries.get(i);

               // Intent n = new Intent(getActivity(), EntryView.class);
                //n.putExtra("TITLE", entriesList.getItemIdAtPosition(i));
                //startActivity(n);

                expand.putExtra("TITLE", p.getTitle());
                expand.putExtra("DATE", p.getDate());
                expand.putExtra("JOURNAL", p.getText());
                expand.putExtra("MOOD", p.getMood());
                startActivity(expand);
            }
        });

        entriesList.setAdapter(EntryListAdapter);









        return fragView;
    }



}
