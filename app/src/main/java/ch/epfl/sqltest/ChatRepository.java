package ch.epfl.sqltest;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ChatRepository {

    private ChatDatabase chatDB;
    private Activity contextActivity;
    private List<String> messages;
    private boolean messagesFetched;
    public ChatRepository(Activity contextActivity) {
        chatDB = Room.inMemoryDatabaseBuilder(contextActivity.getApplicationContext(), ChatDatabase.class).build();
        this.contextActivity = contextActivity;
        messagesFetched = false;
    }

    public void sendMessage(String content, int chat_id) {

        Message m = new Message();
        m.setText(content);
        m.setDate(new Date());
        m.chat_id = chat_id;
        sendMessage(m);
    }

    @SuppressLint("StaticFieldLeak")
    private void sendMessage(final Message message) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                chatDB.daoAccess().sendMessage(message);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void addChat(final Chat c) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                chatDB.daoAccess().addChat(c);
                return null;
            }
        }.execute();
    }

    @SuppressLint("StaticFieldLeak")
    public void addUser(final User usr) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                chatDB.daoAccess().addUser(usr);
                return null;
            }
        }.execute();
    }


    @SuppressLint("StaticFieldLeak")
    public void getMessages(final String id_owner, final String id_rec) {

        new AsyncTask<Void, Void, List<String>>() {

            @Override
            protected List<String> doInBackground(Void... voids) {
                messagesFetched = false;
                List<String> msgList = new LinkedList<>();
                msgList.addAll(chatDB.daoAccess().getChatFromOwnerToReceiver(id_owner, id_rec));
                msgList.addAll(chatDB.daoAccess().getChatToOwnerFromSender(id_owner, id_rec));
                return msgList;
            }

            @Override
            protected void onPostExecute(List<String> ls)
            {
                ((AsyncResponse)contextActivity).messageFetchFinished(ls);
            }
        }.execute();

       // msgList.addAll(chatDB.daoAccess().getChatFromOwnerToReceiver(id_owner, id_rec));
       // msgList.addAll(chatDB.daoAccess().getChatToOwnerFromSender(id_owner, id_rec));
        //return msgList;//chatDB.daoAccess().getChatFromOwnerToReceiver(id_owner, id_rec).addAll(chatDB.daoAccess().getChatToOwnerFromSender(id_owner, id_rec));
    }


}
