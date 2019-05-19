package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class NewEntryFrag extends Fragment {
    private Button btn;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_new_entry,container, false);

        Button btnMood = (Button) v.findViewById(R.id.mood_btn);
        btnMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MoodPicker.class);
                startActivity(i);

            }
        });
        Button btnEntry = (Button) v.findViewById(R.id.entry_btn);
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CreateEntry.class);
                startActivity(i);

            }
        });
        return v;
    }
}