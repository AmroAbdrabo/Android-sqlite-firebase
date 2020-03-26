package ch.epfl.sqltest;

import android.os.Build;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(primaryKeys = {"text", "chat_id"})
public class Message {

    public Date date;
    public String text;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String chat_id;
    public Date getDate()
    {
        return date;
    }
    public String getText()
    {
        return text;
    }

}
