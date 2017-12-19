package com.birjot.gndec_sports.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.birjot.gndec_sports.R;

public class commitee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }


        setContentView(R.layout.activity_commitee);


        setTitle("GNDECsports");
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
