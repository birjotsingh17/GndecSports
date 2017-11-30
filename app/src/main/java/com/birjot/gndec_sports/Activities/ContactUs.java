package com.birjot.gndec_sports.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.birjot.gndec_sports.R;

public class ContactUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        setContentView(R.layout.activity_contact_us);
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}

