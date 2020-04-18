package com.example.septimatechapp;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class basicMenu extends AppCompatActivity {
    Intent intentCategories, intentAboutUs, intentMain;
    FirebaseAuth mauth;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {                  //created menu option to go Report and View report
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mauth = FirebaseAuth.getInstance();


        intentCategories = new Intent(this, Categories.class);
        intentAboutUs = new Intent(this, AboutUs.class);
        intentMain = new Intent(this, MainActivity.class);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this,  item.getTitle(), Toast.LENGTH_SHORT).show();


        switch (item.getItemId()) {
            case R.id.productCate:
                startActivity(intentCategories);

                return true;

            case R.id.aboutUs:
                startActivity(intentAboutUs);
                return false;
            case R.id.logout:
                mauth.signOut();
                checkUserStatus();

                //startActivity(intentMain);
            default:
                return super.onOptionsItemSelected(item);
        }


    } private void checkUserStatus(){
        FirebaseUser user= mauth.getCurrentUser();
        if(user!=null){
            //user signed in

        }
        else {
            startActivity(new Intent(basicMenu.this, MainActivity.class));
            finish();
        }
    }
}