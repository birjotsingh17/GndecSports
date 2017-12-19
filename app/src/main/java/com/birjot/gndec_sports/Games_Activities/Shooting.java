package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class Shooting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setTitle("Facilities");
        setContentView(R.layout.activity_shooting);

        WebView web = (WebView) findViewById(R.id.trackweb);
        String text =   "The Stadium is an open-air, grassy turf  stadium  comprising 400m 8 lane standard track with cricket pitch at the center and is used primarily for track and field events along with cricket . The stadium has a pavilion with stairs and can seat 1,500 in the main grandstand. The facility is used for Training, practice and competitions. University Inter-college Athletic Meet and the College Athletic Meet is hosted annually. The pitch facility is also used to conduct Inter-college Cricket Championship and Cricket Intramurals from time to time. The stadium is a popular location for Punjabi songs and commercial shoots. It has flood lights for illumination at night  and provides amenities such as players retiring room, washrooms, changing rooms, media balcony etc. The pavilion building has department offices, stores, guest rooms, tabletennis room, billiard room and a gymnasium.";

        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");
    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
