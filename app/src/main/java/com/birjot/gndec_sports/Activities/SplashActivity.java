package com.birjot.gndec_sports.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.birjot.gndec_sports.R;
import com.google.firebase.auth.FirebaseAuth;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        if(FirebaseAuth.getInstance().getCurrentUser() !=null && FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()){
            handler.sendEmptyMessageDelayed(102,2000);
        }
        else{
            handler.sendEmptyMessageDelayed(101,2000);
        }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 101){
                startActivity(new Intent(SplashActivity.this, SigninActivity.class));
                finish();
            }
            else if(msg.what == 102){
                Log.d("Pdfsociety", "splash worked");
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        }
    };
}