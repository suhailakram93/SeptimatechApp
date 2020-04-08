package com.example.septimatechapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Categories extends basicMenu {

    public Button RXNT, FeedScrewDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_main);
        RXNT = (Button) findViewById(R.id.RXNT);
        FeedScrewDrive = (Button) findViewById(R.id.FeedScrew);
        FeedScrewDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), feedscrews_drivesystems.class));
                startActivity(new Intent(Categories.this, feedscrews_drivesystems.class));
            }
        });

        RXNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu categorymenu = new PopupMenu(Categories.this, RXNT);
                categorymenu.getMenuInflater().inflate(R.menu.categorymenu, categorymenu.getMenu());

                categorymenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.RXNT) {
                            startActivity(new Intent(getApplicationContext(), Rxnt.class));
                            // Toast.makeText(HomePage.this, "1. RXNT", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.OEM) {
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(Categories.this, "2. OEM", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.CapHanding) {
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(Categories.this, "3. Cap Handling", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.LabelHandling) {
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(Categories.this, "4. Label Handling", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.SpecialApp) {
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(Categories.this, "5. Special Application", Toast.LENGTH_SHORT).show();
                        }
                        categorymenu.dismiss();

                        return true;
                    }

                });
                categorymenu.show();
            }
        });


    }
}
