package ch.epfl.sqltest;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ChatMessageRelation {
    @Embedded
    public Chat chat;
    @Relation(
            parentColumn = "chat_id",
            entityColumn = "chat_id"
    )
    public List<Message> chatContent;
}
