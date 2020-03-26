package ch.epfl.sqltest;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class UserWithFriends {
    @Embedded
    public User usr;
    @Relation(
            parentColumn = "userID",
            entityColumn = "userID",
            associateBy = @Junction(FriendsCrossRef.class)
    )
    public List<User> friends;

}

@Entity(primaryKeys = {"playlistId", "songId"})
class FriendsCrossRef {
    public String friendID;
    public String friendID2;
}
