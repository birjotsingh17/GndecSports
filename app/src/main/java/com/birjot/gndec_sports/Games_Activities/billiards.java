package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class billiards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_billiards);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.billweb);
        String text =  "One traditional table with balls and cues is installed in the room. Billiard is regularly played by staff and students in the group of four per hour.";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
