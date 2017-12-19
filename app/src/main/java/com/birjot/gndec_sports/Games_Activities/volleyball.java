package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class volleyball extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_volleyball);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.webvolley1);
        WebView webone = (WebView) findViewById(R.id.webvolley2);

        String text = "Two outdoor courts with food lights are used for intramural and extramural activity by both boys and girls.";
        String textone =  " Rental charges for both the courts is Rs.2000/- per day without lights and Rs.5000/- per day with lights. ";


        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

        webone.loadData("<p style=\" text-align: justify\">"+ textone +"</p>", "text/html", "UTF-8");

    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
