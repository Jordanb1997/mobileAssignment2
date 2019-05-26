package assignment2.jordanb7.utas.edu.au.moodapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CreateEntry extends AppCompatActivity {
    Calendar cal;
    DatePickerDialog date;
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_entry);

        Database databaseConnection = new Database(this);
        final SQLiteDatabase db = databaseConnection.open();

        final ArrayList<Entry> entries = EntryTable.selectAll(db);

        final TextView title = findViewById(R.id.journal_title_input);

        final TextView journal = findViewById(R.id.journal_input);

        final Spinner moods = (Spinner) findViewById(R.id.mood);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mood_items, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        moods.setAdapter(adapter);


        Button fin = findViewById(R.id.journal_done_btn);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Entry p = new Entry();

                p.setTitle(title.getText().toString());
                p.setText(journal.getText().toString());
                p.setMood(moods.getSelectedItem().toString());

                EntryTable.insert(db,p);

                Intent m = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(m);
            }
        });



    }
}
