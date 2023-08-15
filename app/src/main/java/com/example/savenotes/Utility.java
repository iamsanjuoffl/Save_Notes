package com.example.savenotes;

import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;

public class Utility {
    static void showToast(Context context,String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
    static CollectionReference getCollectionReferenceForNotes(){
        FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("notes").document(currentUser.getUid()).collection("my_notes");
    }

    static String timestampToString(Timestamp timestamp){
       String s= new SimpleDateFormat("dd/MM/yyyy").format(timestamp.toDate());
       return s;
    }
}
