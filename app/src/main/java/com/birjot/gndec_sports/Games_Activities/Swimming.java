package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class Swimming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_swimming);
        setTitle("Facilities");
        WebView web = (WebView) findViewById(R.id.swimweb);
        String text =   "Swimming pool in our campus is environmental sustainable facility that serves athletic training, competition and leisure needs. It can accommodate 50-60 swimmers and has no diving facility. The facility has 25m x12m dimension with 4 ft. depth at the shallow end and 6 ft depth at the deeper end. The water is fresh with no chlorination as it is causes irritation to skin and eyes. The pool is cleaned every week thoroughly and is filled with fresh water. The used water is drained out to be used for irrigation purpose of   hockey and football grounds and lawns. The water in the swimming pool is maintained and disinfected with alum and bleaching powder. The amenity  include accessible washrooms and changing rooms and stores. ";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");


    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
