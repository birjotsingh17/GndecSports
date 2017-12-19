package com.birjot.gndec_sports.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.birjot.gndec_sports.R;

public class Developers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setTitle("GNDECsports");
        setContentView(R.layout.activity_developers);
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
