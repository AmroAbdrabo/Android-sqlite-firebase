package ch.epfl.sqltest;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.Date;
import java.util.List;

@Dao
public interface ChatAccessor {
    //final static Date today = new Date();

    @Query("SELECT message.text FROM message WHERE message.chat_id IN " +
            "(SELECT chat.chat_id FROM chat WHERE chat.`from` = :sender AND chat.`to` = :owner)")
    public List<String> getChatToOwnerFromSender(String owner, String sender);

    @Query("SELECT message.text FROM message WHERE message.chat_id IN " +
            "(SELECT chat.chat_id FROM chat WHERE chat.`from` = :owner AND chat.`to` = :receiver)")
    public List<String> getChatFromOwnerToReceiver(String owner, String receiver);

    @Insert
    public void sendMessage(Message m);

    @Insert
    public void addUser(User usr);

    @Insert
    public void addChat(Chat c);

}
