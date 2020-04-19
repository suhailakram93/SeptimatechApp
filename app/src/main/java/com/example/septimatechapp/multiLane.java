package com.example.septimatechapp;

import android.os.Bundle;
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

public class multiLane extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ModelProducts> postList;
    ProductAdapter adapterPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.rxnt);
        setContentView(R.layout.multi_lane);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(multiLane.this, 2);

        recyclerView.setLayoutManager(layoutManager);

        postList = new ArrayList<>();

        loadPosts();
    }

    private void loadPosts() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Products/Categories/5-Multi Lane Adjust");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                postList.clear();
                Toast.makeText(multiLane.this, "Multi Lane", Toast.LENGTH_SHORT).show();

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ModelProducts value = ds.getValue(ModelProducts.class);
                    postList.add(value);

                    adapterPost = new ProductAdapter(multiLane.this, postList);
                    //Toast.makeText(multiLane.this, "test", Toast.LENGTH_SHORT).show();

                    recyclerView.setAdapter(adapterPost);
                    //Toast.makeText(multiLane.this, "check", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //In case od error position
                Toast.makeText(multiLane.this, "" + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
