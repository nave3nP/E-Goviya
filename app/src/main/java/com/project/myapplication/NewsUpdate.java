package com.project.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class NewsUpdate extends AppCompatActivity {

    EditText editTitle,editDescription;
    FirebaseFirestore db;
    Button postBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_update);

        db = FirebaseFirestore.getInstance();
        editTitle = findViewById(R.id.titleEdit);
        editDescription = findViewById(R.id.description);
        postBtn = findViewById(R.id.post);

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = editTitle.getText().toString();
                String Description = editDescription.getText().toString();

                Map<String,Object> news = new HashMap<>();
                news.put("Title",Title);
                news.put("Description",Description);

                db.collection("news")
                        .add(news)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(NewsUpdate.this, "Added Successfully", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(NewsUpdate.this, "Adding Failed", Toast.LENGTH_LONG).show();
                            }
                        });

            }
        });
    }
}