package com.example.septimatechapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.google.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.firebase.ui.FirebaseRecyclerAdapter;


public class videos extends AppCompatActivity {

    RecyclerView MrecyclerView;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videos);

        MrecyclerView = findViewById(R.id.recyclerview);
        MrecyclerView.setHasFixedSize(true);
        MrecyclerView.setLayoutManager(new LinearLayoutManager(this));

        database= FirebaseDatabase.getInstance();
        Toast.makeText(videos.this, "check1", Toast.LENGTH_SHORT).show();
        reference = FirebaseDatabase.getInstance().getReference("Products/Categories/video");
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<memberclass,ViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<memberclass, ViewHolder>(
                        memberclass.class,
                        R.layout.row,
                        ViewHolder.class,
                        reference
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, memberclass memberclass, int i) {
                        viewHolder.setVideo(getApplication(),memberclass.getTitle(),memberclass.getUrl());
                    }
                };
        MrecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}