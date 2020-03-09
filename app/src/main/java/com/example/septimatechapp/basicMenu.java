package com.example.septimatechapp;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class basicMenu extends AppCompatActivity {
    Intent intentCategories, intentAboutUs, intentMain;




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                  //created menu option to go Report and View report
        getMenuInflater().inflate(R.menu.menu_main, menu);
        intentCategories = new Intent(this, Categories.class);
        intentAboutUs = new Intent(this, AboutUs.class);
        intentMain = new Intent(this, MainActivity.class);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item:" + item.getTitle(), Toast.LENGTH_SHORT).show();


        switch (item.getItemId()) {
            case R.id.productCate:
                startActivity(intentCategories);

                return true;

            case R.id.aboutUs:
                startActivity(intentAboutUs);
                return false;
            case R.id.logout:
                startActivity(intentMain);
            default:
                return super.onOptionsItemSelected(item);
        }


    }
}