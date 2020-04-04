package com.example.septimatechapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class productsadminupdate extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String[] categories = {"1-RXNT and OEM Changeparts", "2-Feedscrews and Drive Systems", "3-Smart Storage System", "4-Easy Adjust Rails", "5-Multi Lane Adjust", "6-Unison Guide Rails", "7-Unison Automation", "8-Unison Cap Tracks", "Thumbs", "Videos", "New Category"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productsadminupdate);
        Spinner spin = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), "Selected category: " + categories[position], Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
