package ch.epfl.sqltest;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreToSQLiteAdapter {

    private static final FirebaseFirestore remoteHost = FirebaseFirestore.getInstance();
    public static void fetchFirestoreDataIntoSQLite(String owner, String receiver)
    {
        Map<String, Object> hm;
        remoteHost.collection("Chats").document("shaima@abc.com").collection("amro@abc.com").document("Messages").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                System.out.println("PLEASE WORK!! " +task.getResult().getData());
            }
        });
        //catch(Exception e) {
         //   System.out.println("  WHYYYYYYYYYY     ");
         //   System.out.println(e.getMessage());
    //}


    }
}
