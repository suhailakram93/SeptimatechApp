package com.example.septimatechapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Adminmain extends AppCompatActivity {
    Button updatemenu;
    Button del_btn;

//    DatabaseReference dbreff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmain);

//        dbreff = FirebaseDatabase.getInstance();

        updatemenu = findViewById(R.id.update);
        del_btn = findViewById(R.id.delete);
        updatemenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                   //Button redirected to Firebase - Storage
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://console.firebase.google.com/u/0/project/septimatech-capstone/storage/septimatech-capstone.appspot.com/files~2FCategories%20"));
                startActivity(viewIntent);
            }
        });

        del_btn.setOnClickListener(new View.OnClickListener() {         //Button redirected to Firebase - Database
            @Override
            public void onClick(View v) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("https://console.firebase.google.com/u/0/project/septimatech-capstone/database/septimatech-capstone/data"));
                startActivity(viewIntent);
            }
        });
//        updatemenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final PopupMenu popupMenu = new PopupMenu(Adminmain.this, updatemenu);
//                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
//
//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        if (item.getItemId() == R.id.feeds) {
//                            startActivity(new Intent(getApplicationContext(), feedsadmin.class));
//                            Toast.makeText(Adminmain.this, "Feeds", Toast.LENGTH_SHORT).show();
//                        } else if (item.getItemId() == R.id.products) {
//                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
//                            Toast.makeText(Adminmain.this, "Products", Toast.LENGTH_SHORT).show();
//                        }
//                        popupMenu.dismiss();
//                        return true;
//                    }
//
//                });
//                popupMenu.show();
//            }
//        });
    }
}
