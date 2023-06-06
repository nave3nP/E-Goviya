package com.project.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class News extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<NewsContainer> newsArrayList;
    MyAdapter myAdapter;
    FirebaseFirestore db;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Getting Data...");
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        newsArrayList = new ArrayList<NewsContainer>();
        myAdapter = new MyAdapter(News.this,newsArrayList);

        EventChangeListener();
        recyclerView.setAdapter(myAdapter);
    }

    private void EventChangeListener() {
        db.collection("news")
        .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                if (error != null){
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();
                    Toast.makeText(News.this, "Firebase Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                for(DocumentChange dc : value.getDocumentChanges()){
                    if(dc.getType()==DocumentChange.Type.ADDED || dc.getType()==DocumentChange.Type.REMOVED){
                        newsArrayList.add(dc.getDocument().toObject(NewsContainer.class));
                    }

                    myAdapter.notifyDataSetChanged();
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();
                }


            }
        });
    }
}