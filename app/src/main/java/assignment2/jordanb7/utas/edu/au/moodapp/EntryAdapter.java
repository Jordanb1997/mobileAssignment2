package assignment2.jordanb7.utas.edu.au.moodapp;

import android.app.Service;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class EntryAdapter extends ArrayAdapter<Entry> {
    private int mLayoutResourceID;

    public EntryAdapter (Context context, int resource, List<Entry> objects)
    {
        super(context, resource, objects);
        this.mLayoutResourceID = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(mLayoutResourceID, parent, false);

        Entry p = this.getItem(position);
        TextView textView = row.findViewById(android.R.id.text1);
        textView.setText(p.getDate()+": "+p.getTitle()+ ":" + p.getText());
        return row;
    }
}
