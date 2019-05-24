package assignment2.jordanb7.utas.edu.au.moodapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database databaseConnection = new Database(this);
        final SQLiteDatabase db = databaseConnection.open();

        BottomNavigationView btmNav = findViewById(R.id.bottom_nav);
        btmNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                new EntriesFrag()).commit();

        Entry entry1 = new Entry();
        entry1.setTitle("hello world");
        entry1.setDate(11021968);
        entry1.setMood("sad");
        entry1.setText("yeet");
        entry1.setImage("doge.png");

        EntryTable.insert(db, entry1);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.entries_nav:
                            selectedFragment = new EntriesFrag();
                            break;
                        case R.id.new_nav:
                            selectedFragment = new NewEntryFrag();
                            break;
                        case  R.id.tracker_nav:
                            selectedFragment = new TrackerFrag();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedFragment).commit();

                    return true;
                }
            };
}
