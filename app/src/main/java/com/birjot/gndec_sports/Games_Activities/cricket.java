package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class cricket extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_cricket);

        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.webcric1);
        WebView webone = (WebView) findViewById(R.id.webcric2);


        String text =  "A clay pitch is laid in the track and field stadium with 50 yards boundary for Intramural and Extramural activity. Two hard pitches of chips under nets for practice session is available for students.";
        String textone =  "Rental charge is Rs.5000/- per day.";



        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

        webone.loadData("<p style=\" text-align: justify\">"+ textone +"</p>", "text/html", "UTF-8");
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
