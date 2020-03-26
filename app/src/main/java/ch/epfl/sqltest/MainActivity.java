package ch.epfl.sqltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        User user1 = new User("amro@abc.com", "amro", "last");
        User user2 = new User("shaima@abc.com", "shaima", "rashed");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirestoreToSQLiteAdapter.fetchFirestoreDataIntoSQLite("", "");
            }
        });
    }

}
