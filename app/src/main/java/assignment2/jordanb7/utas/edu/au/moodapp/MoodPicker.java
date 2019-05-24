package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MoodPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_picker);

        final String[] list_items = getResources().getStringArray(R.array.emoji);
        ArrayList<String> items = new ArrayList<>(Arrays.asList(list_items));

        final ArrayAdapter<String> myEmojiAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                items);

        ListView myList = findViewById(R.id.emoji_list);
        myList.setAdapter(myEmojiAdapter);

        Button btnEntry = (Button) findViewById(R.id.mood_done);
        btnEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MoodPicker.this, EntriesFrag.class);
                startActivity(i);

            }
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MoodPicker.this);

                builder.setMessage(list_items[i])
                        .setTitle("Items Tapped");

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
