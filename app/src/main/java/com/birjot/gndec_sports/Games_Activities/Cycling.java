package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class Cycling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_cycling);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.cycleweb);
        String text =  " College provide Cycles and students practice at PAU Velodrome, Ludhiana. ";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
