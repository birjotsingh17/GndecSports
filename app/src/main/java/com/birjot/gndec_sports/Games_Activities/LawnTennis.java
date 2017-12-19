package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class LawnTennis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_lawn_tennis);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.lawnweb);
        String text = "The Tennis courts are located near the main gate of the college and is a sport facility operated and managed by the Department of Physical Education & Sports at the Guru Nanak Dev Engg. College, Ludhiana. The centre has a total of 3 outdoor courts which provides a great playing option. The facility is free of cost and can be used in the mornings and evenings for the play.";

        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
