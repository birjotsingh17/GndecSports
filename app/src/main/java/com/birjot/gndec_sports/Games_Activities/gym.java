package com.birjot.gndec_sports.Games_Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

public class gym extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_gym);
        setTitle("Facilities");

        WebView web = (WebView) findViewById(R.id.gymweb);
        WebView webone = (WebView) findViewById(R.id.gyweb);

        WebView webon =(WebView) findViewById(R.id.gweb);

        String text =  "The Gymnasium/Multi exercise Hall is situated on the first floor of sports complex and consist of all types of strength conditioning apparatus. The state –of-the- art fitness center has something for everyone.";
        String textone =  "The equipments consist of smith machine, hack squat, cable cross, Olympic lifting platform, wall bars, three multi stations, seven single stations namely bicep curl, chest press, shoulder press, peck deck, seated rowing, leg press, lats pull down along with free weight section, free benches as well as stretching area for essential cooling down.";

        String texton = "\n" +
                "The student and staff members avail this facility on nominal charges of Rs 50/- per\n" +
                "month in the morning and evenings six day a week.";

        web.loadData("<p style=\" text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

        webone.loadData("<p style=\" text-align: justify\">"+ textone +"</p>", "text/html", "UTF-8");


        webon.loadData("<p style=\" text-align: justify\">"+ texton +"</p>", "text/html", "UTF-8");
    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }
}
