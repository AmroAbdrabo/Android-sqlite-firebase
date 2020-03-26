package ch.epfl.sqltest;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;


public class UserChatRelation {

    @Embedded public User user;
    @Relation(
            parentColumn = "userID",
            entityColumn = "owner"
    )
    public List<Chat> chatList;

}
