package ch.epfl.sqltest;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreToSQLiteAdapter {

    private static final FirebaseFirestore remoteHost = FirebaseFirestore.getInstance();
    public static void fetchFirestoreDataIntoSQLite(String owner, String receiver)
    {
        Map<String, Object> hm;
        try { hm = remoteHost.collection("Chats").document("shaima@abc.com").get().getResult().getData();}
        catch(Exception e) {
            System.out.println("WHYYYY");
    }


    }
}
