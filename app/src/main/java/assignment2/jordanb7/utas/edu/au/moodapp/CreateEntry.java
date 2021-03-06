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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CreateEntry extends AppCompatActivity {
    Calendar cal;
    DatePickerDialog date;
    String strDate;
    int i;
    boolean dateSelected = false;

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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mood_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        moods.setAdapter(adapter);


        final Button datePicker = findViewById(R.id.date_picker_btn);
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cal = Calendar.getInstance();
                int day = cal.get(Calendar.DAY_OF_MONTH);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);


                date = new DatePickerDialog(CreateEntry.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mday, int dmonth, int myear) {
                    }
                },year,month,day);
                date.show();

                SimpleDateFormat formatted = new SimpleDateFormat("dd MM yyyy");
                strDate = formatted.format(cal.getTime());

                dateSelected = true;
            }
        });




        Button fin = findViewById(R.id.journal_done_btn);

        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Entry p = new Entry();

                p.setTitle(title.getText().toString());
                p.setText(journal.getText().toString());
                p.setMood(moods.getSelectedItem().toString());
                if(dateSelected == false )
                {
                    DateFormat df = new SimpleDateFormat("dd MM yyyy, HH:mm");
                    String currentDate = df.format(Calendar.getInstance().getTime());
                    p.setDate(currentDate);
                }
                else {

                    p.setDate(strDate);
                }
                EntryTable.insert(db,p);

                Intent m = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(m);
            }
        });



    }
}
