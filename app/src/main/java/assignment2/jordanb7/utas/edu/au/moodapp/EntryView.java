package assignment2.jordanb7.utas.edu.au.moodapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class EntryView extends AppCompatActivity {
    Button share;
    Button delete;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.entry_view);

            Database databaseConnection = new Database(this);
            final SQLiteDatabase db = databaseConnection.open();

            final ArrayList<Entry> entries = EntryTable.selectAll(db);

            Intent a = getIntent();

            String m = a.getStringExtra("TITLE");
            //int d = a.getIntExtra("DATE");;
            String f = a.getStringExtra("JOURNAL");
            String md = a.getStringExtra("MOOD");

            final TextView eTitle = findViewById(R.id.lblTitle);
           // TextView eDate= findViewById(R.id.lblDate);
            TextView ej = findViewById(R.id.lblJournal);
            TextView mm = findViewById(R.id.lblMood);

            eTitle.setText(m);
            ej.setText(f);
            mm.setText(md);

            share = findViewById(R.id.share_btn);
            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent b = new Intent(Intent.ACTION_SEND);
                    b.setType("text/plain");
                    startActivity(Intent.createChooser(b,"share"));
                }
            });

            delete = findViewById(R.id.delete_btn);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Entry p = new Entry();

                    EntryTable.delete(db, p);

                    Intent m = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(m);

                }
            });





    }
}
