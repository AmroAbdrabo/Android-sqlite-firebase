package ch.epfl.sqltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  AsyncResponse {

    public static ChatRepository cr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final User user1 = new User("amro@abc.com", "amro", "last");
        final User user2 = new User("shaima@abc.com", "shaima", "rashed");

        cr = new ChatRepository(this);

        cr.addUser(user1);
        cr.addUser(user2);
        Chat fromShaimaToAmro = new Chat();
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


    }


    @Override
    public void messageFetchFinished(List<String> output) {

        System.out.println("SENT TO AMROOO:    ");
        for (String el: output)
        {
            System.out.println(el);
        }

    }
}
