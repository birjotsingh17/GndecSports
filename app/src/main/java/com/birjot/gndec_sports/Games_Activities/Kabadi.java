package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class Kabadi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_kabadi);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.kabweb);
        String text =  " One ground for N/S Kabaddi is situated in the track and field stadium and is regularly used for technical and tactical training by college boys team. Intramural are very often conducted.";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
