package ch.epfl.sqltest;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }
    public int chat_id;
    public Date getDate()
    {
        return date;
    }
    public String getText()
    {
        return text;
    }

}
