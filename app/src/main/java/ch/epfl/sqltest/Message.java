package ch.epfl.sqltest;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;

import java.util.Date;

@Entity(primaryKeys = {"text", "chat_id"}, foreignKeys = {
        @ForeignKey(
                entity = Chat.class,
                parentColumns = "chat_id",
                childColumns = "chat_id"
        )})
public class Message {

    public Date date;
    @NonNull
    public String text;

    private int chat_id;

    public Message(Date date, String content)
    {
        this.date = date;
        this.text = content;
    }
    public Message(){}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Date getDate()
    {
        return date;
    }
    public String getText()
    {
        return text;
    }
    public int getChat_id() {
        return chat_id;
    }
}
