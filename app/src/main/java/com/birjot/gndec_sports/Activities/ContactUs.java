package com.birjot.gndec_sports.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.birjot.gndec_sports.R;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        setTitle("Contact Us");
        setContentView(R.layout.activity_contact_us);
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    public void openmail(View view){
        Intent emailintent = new Intent(Intent.ACTION_SEND);
        emailintent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"gndecsports@gmail.com"});
        emailintent.setType("text/plain");
        startActivity(emailintent);
    }
}

