package com.birjot.gndec_sports.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.birjot.gndec_sports.Fragments.Records;
import com.birjot.gndec_sports.Fragments.intro1;
import com.birjot.gndec_sports.Fragments.lookformeetnews;
import com.birjot.gndec_sports.Model.ViewPagerAdapter;
import com.birjot.gndec_sports.R;

import java.util.Timer;
import java.util.TimerTask;

public class Athletics extends AppCompatActivity {

    ViewPager viewPager;

    private Button newsath, resultsath, recordsath;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        submitPost3();

        setTitle("ATHLETIC MEET");

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }

        setContentView(R.layout.activity_athletics);

        viewPager= (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);


/*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


        newsath=(Button) findViewById(R.id.newsath);
        recordsath=(Button) findViewById(R.id.recordsath);
        resultsath=(Button) findViewById(R.id.resultsath);

        recordsath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitPost1();

            }
        });

        resultsath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitPost2();

            }
        });

        newsath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                submitPost3();

            }
        });



    }
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    public void records(View view){

        Intent intent = new Intent(this,Developers.class);
        startActivity(intent);
        }

        private void submitPost1(){
            Fragment fragment = null;
            fragment = new Records();


            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameath, fragment);
                ft.commit();

        }}

    private void submitPost2() {
        Toast.makeText(this, "working1", Toast.LENGTH_SHORT).show();

        Fragment fragment = null;
        fragment = new intro1();


        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameath, fragment);
            ft.commit();

        }
    }

    private void submitPost3(){

        Fragment fragment = null;
        fragment = new lookformeetnews();

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameath, fragment);
            ft.commit();

        }


    }
    }


