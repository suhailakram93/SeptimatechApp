package com.example.septimatechapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Oem extends AppCompatActivity {
    RecyclerView recyclerView;
    List<ModelProducts> postList;
    ProductAdapter adapterPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oem);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview1);
        GridLayoutManager layoutManager = new GridLayoutManager(Oem.this, 2);

        recyclerView.setLayoutManager(layoutManager);

        postList = new ArrayList<>();

        loadPosts();
    }

    private void loadPosts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Products/Categories/1-RXNT and OEM Changeparts/2- OEM");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear();
                Toast.makeText(Oem.this, "test", Toast.LENGTH_SHORT).show();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ModelProducts value = ds.getValue(ModelProducts.class);
                    postList.add(value);

                    adapterPost = new ProductAdapter(Oem.this, postList);
                    Toast.makeText(Oem.this, "OEM", Toast.LENGTH_SHORT).show();

                    recyclerView.setAdapter(adapterPost);
                    Toast.makeText(Oem.this, "check", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //In case od error position
                Toast.makeText(Oem.this, "" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}