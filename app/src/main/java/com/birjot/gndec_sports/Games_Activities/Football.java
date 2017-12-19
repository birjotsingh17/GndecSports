package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class Football extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setTitle("Facilities");

        setContentView(R.layout.activity_football);

        WebView web = (WebView) findViewById(R.id.footweb);

        WebView webone = (WebView) findViewById(R.id.footweb2);

        String text =   "One natural grass football field (Dimensions:110 yards by 70 yards). Intramural and Extramural are regularly conducted for boys.";
        String textone =  "Rental charges: 1500/- per day";

        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
        webone.loadData("<p style=\" text-align: justify\">"+ textone +"</p>", "text/html", "UTF-8");
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
