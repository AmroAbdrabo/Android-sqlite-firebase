package ch.epfl.sqltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  AsyncResponse {

    EditText a;
    TextView b;
    public static ChatRepository cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a = findViewById(R.id.editMessage);
        b = findViewById(R.id.textView);
        final User user1 = new User("amro@abc.com", "amro", "last");
        final User user2 = new User("shaima@abc.com", "shaima", "rashed");
        final IsFriendsWith friendPair = new IsFriendsWith(user1.email, user2.email);

        cr = new ChatRepository(this);
        cr.addUser(user1);
        cr.addUser(user2);
        cr.addFriend(user1, user2);

        final Chat fromShaimaToAmro = new Chat();
        fromShaimaToAmro.from = user2.email;
        fromShaimaToAmro.to = user1.email;
        cr.addChat(fromShaimaToAmro);

        Message m = new Message();
        m.setChat_id(fromShaimaToAmro.chat_id);
        m.setText("Hellllllooooo amr");
        m.setDate(new Date());

        cr.sendMessage("Hellllooo amr", fromShaimaToAmro.chat_id);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button_fetch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cr.getMessages(user1.email, user2.email);

            }
        });

        findViewById(R.id.button_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cr.sendMessage(a.getText().toString(), fromShaimaToAmro.chat_id);
                //cr.getMessages(user1.email, user2.email);

            }
        });


    }


    @Override
    public void messageFetchFinished(List<String> output) {


        System.out.println("SENT TO AMROOO:    ");
        String msg = "";
        for (String el: output)
        {
            msg += el;
            msg += "\n";
        }
        b.setText(msg);

    }
}
