package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class chess extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_chess);

        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.chessweb);
        String text =  " Regularly played by students in Sports  Complex. Both intramural and extramural activity is conducted from time to time.";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
