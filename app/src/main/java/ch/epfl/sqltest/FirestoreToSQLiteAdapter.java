package ch.epfl.sqltest;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class FirestoreToSQLiteAdapter {

    private static final FirebaseFirestore remoteHost = FirebaseFirestore.getInstance();


    // owner is "shaima@abc.com" and sender is "amro@abc.com"
    public static void fetchFirestoreDataIntoSQLite(String owner, String sender)
    {
        Map<String, Object> hm;
        // shaima will be replaced by the current user in reality
        // even though the message is "helloooo amr" it is acutually sent to shaima
        // similarly if shaima wants to send something she will put it in the amro@abc.com's document
        remoteHost.collection("Chats").document(owner).collection(sender).document("Messages").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                MainActivity.cr.insertMessageFromRemote(task.getResult().getData());
                //System.out.println("PLEASE WORK!! " +task.getResult().getData());
            }
        });
        //catch(Exception e) {
         //   System.out.println("  WHYYYYYYYYYY     ");
         //   System.out.println(e.getMessage());
    //}


    }
}
