package ch.epfl.sqltest;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Junction;
import androidx.room.Relation;

import java.io.InputStreamReader;
import java.util.List;

@Entity(primaryKeys = {"friendID1", "friendID2"}, foreignKeys = {@ForeignKey(
        entity = User.class,
        parentColumns = "userID",
        childColumns = "friendID1"
),
        @ForeignKey(
                entity = User.class,
                parentColumns = "userID",
                childColumns = "friendID2"
        )})
public class IsFriendsWith {
    @NonNull
    private String friendID1;
    @NonNull
    private String friendID2;

    public IsFriendsWith(String friendID1, String friendID2)
    {
        if (friendID1.compareTo(friendID2) < 0)
        {
            this.friendID1 = friendID1;
            this.friendID2 = friendID2;
        }else{
            this.friendID2 = friendID1;
            this.friendID1 = friendID2;
        }
    }

    public IsFriendsWith()
    {}

    public String getFriendID1() {
        return friendID1;
    }

    public String getFriendID2() {
        return friendID2;
    }

    public void setFriendID1(String friendID1) {
        this.friendID1 = friendID1;
    }

    public void setFriendID2(String friendID2) {
        this.friendID2 = friendID2;
    }
}

