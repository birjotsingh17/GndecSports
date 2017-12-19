package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class BasketBall extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_basket_ball);

        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.basketweb);

        WebView web1 = (WebView) findViewById(R.id.basketweb2);
        String text =  " Two cemented Basketball courts (One with flood lights). Intramural and Extra mural are regularly conducted for boys and girls";
        String text1 ="Rental charges for both the courts is Rs.2000/- per day without lights and Rs.5000/- per day with lights.";
        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
        web1.loadData("<p style=\" text-align: justify\">"+ text1 +"</p>", "text/html", "UTF-8");
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
