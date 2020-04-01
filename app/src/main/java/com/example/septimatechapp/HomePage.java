package com.example.septimatechapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.Toast;

public class HomePage extends basicMenu {
    public Button RXNT;
    String record = "";          //define string variable for record

    //    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_main);

        RXNT = (Button) findViewById(R.id.RXNT);
        RXNT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu categorymenu = new PopupMenu(HomePage.this, RXNT);
                categorymenu.getMenuInflater().inflate(R.menu.categorymenu, categorymenu.getMenu());

                categorymenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getItemId() == R.id.RXNT) {
                            startActivity(new Intent(getApplicationContext(), Rxnt.class));
                           // Toast.makeText(HomePage.this, "1. RXNT", Toast.LENGTH_SHORT).show();
                        } else if (item.getItemId() == R.id.OEM) {
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(HomePage.this, "2. OEM", Toast.LENGTH_SHORT).show();
                        }
                        else if(item.getItemId() == R.id.CapHanding){
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(HomePage.this,"3. Cap Handling",Toast.LENGTH_SHORT).show();
                        }
                        else if(item.getItemId() == R.id.LabelHandling){
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(HomePage.this,"4. Label Handling",Toast.LENGTH_SHORT).show();
                        }
                        else if(item.getItemId() == R.id.SpecialApp){
                            startActivity(new Intent(getApplicationContext(), productsadminupdate.class));
                            Toast.makeText(HomePage.this,"5. Special Application",Toast.LENGTH_SHORT).show();
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

//-----------------------------------------------------------------------
//        Spinner CarSpinner = (Spinner) findViewById(R.id.spinnerCat);

//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(HomePage.this,
//                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Categories));

//        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        CarSpinner.setAdapter(myAdapter);

//        CarSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) HomePage.this);
//        CarSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

//            @Override

//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                //use postion value
//                switch (position) {
//                    case 0:
//                        record = "1";
//                        break;
//                    case 1:
//                        record = "2";
//                        break;
//                    case 2:
//                        record = "3";
//                        break;
//                    case 3:
//                        record = "4";
//                        break;
//                    case 4:
//                        record = "5";
//                        break;
//                    case 5:
//                        record = "6";
//                        break;
//                    case 6:
//                        record = "7";
//                        break;
//                    case 7:
//                        record = "8";
//                        break;
//                    case 8:
//                        record = "9";
//                        break;
//                }
//                vpbutton.setOnClickListener((new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        if(record == "1"){
//                            Intent i = new Intent(HomePage.this,Categories.class);
//                            startActivity(i);
//                        }
//                    }
//                }));
//            }
//
//            @Override
//
//            public void onNothingSelected(AdapterView<?> parent) {

//            }


//        Toast.makeText(HomePage.this,"Click is working", Toast.LENGTH_LONG).show();
//        });