package com.example.septimatechapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Categories extends basicMenu {

//    public Button RXNT, FeedScrewDrive;

    public Button RXNT, Videos, btn_Thumbs, btn_UniCapTrack, btn_UniAuto,
            btn_UniGuideRail, btn_MultiLane, btn_EasyAdjst, btn_StorageSys, FeedScrewDrive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories_main);

        RXNT = (Button) findViewById(R.id.RXNT);
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
                            startActivity(new Intent(getApplicationContext(), Oem.class));
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

        Videos = (Button) findViewById(R.id.Videos);
        Videos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), videos.class));
            }
        });

        btn_Thumbs = (Button) findViewById(R.id.Thumbs);
        btn_Thumbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Thumbs.class));
            }
        });

        btn_UniCapTrack = (Button) findViewById(R.id.UniCap);
        btn_UniCapTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), unisionCapTrucks.class));
            }
        });

        btn_UniAuto = (Button) findViewById(R.id.UnisonAuto);
        btn_UniAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), unisionAutomation.class));
            }
        });

        btn_UniGuideRail = (Button) findViewById(R.id.Unison);
        btn_UniGuideRail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), unisionGuideRails.class));
            }
        });

        btn_EasyAdjst = (Button) findViewById(R.id.EasyAdj);
        btn_EasyAdjst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), easyAdjustRails.class));
            }
        });

        btn_MultiLane = (Button) findViewById(R.id.MultiLane);
        btn_MultiLane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), multiLane.class));
            }
        });
        btn_StorageSys = (Button) findViewById(R.id.SmartStorage);
        btn_StorageSys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), smart_storage.class));
            }
        });
        FeedScrewDrive = (Button) findViewById(R.id.FeedScrew);
        FeedScrewDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), feedscrews_drivesystems.class));
            }
        });
    }
}