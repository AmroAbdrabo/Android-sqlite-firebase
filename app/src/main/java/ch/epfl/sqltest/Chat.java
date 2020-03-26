package ch.epfl.sqltest;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "userID",
                childColumns = "to"
        ),
        @ForeignKey(
                entity = User.class,
                parentColumns = "userID",
                childColumns = "from"
        )
})
public class Chat {

    @PrimaryKey
    public int chat_id;
    public String to;
    public String from;

    public String owner;

}
