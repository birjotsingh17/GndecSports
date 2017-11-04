package com.birjot.gndec_sports.Activities;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.birjot.gndec_sports.Model.User;
import com.birjot.gndec_sports.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class SignUpActivity extends Progressdialog {



    //private TextView btnPickDate;
    private AutoCompleteTextView city;
    private EditText email, password, ph , university  ;
    private RadioButton male, female;
    private RadioGroup radioGroup;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private static String TAG, gender;
    private static int dayOfMonth,monthOfYear,year;

   /* private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        initViews();
        TAG = getString(R.string.tag);
        getGender();

        /*
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };*/
    }




    public void initViews() {
//        dbref
        mDatabase = FirebaseDatabase.getInstance().getReference();

//        auth
        mAuth = FirebaseAuth.getInstance();

        // university roll no
        university = (EditText) findViewById(R.id.university);

//        email
        email = (EditText) findViewById(R.id.email);

//        password
        password = (EditText) findViewById(R.id.password);

        // phone

        ph = (EditText) findViewById(R.id.ph);

//        radio buttons
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        male = (RadioButton) findViewById(R.id.male_radio_btn);
        female = (RadioButton) findViewById(R.id.female_radio_btn);

//        city
        city = (AutoCompleteTextView) findViewById(R.id.ac_city);
        city.setThreshold(1);
        String[] cities = getResources().getStringArray(R.array.india_cities);

        ArrayAdapter<String> city_adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, cities);
        city.setAdapter(city_adapter);

//        date
        //  btnPickDate = (TextView) findViewById(R.id.btn_date);



    }

    public void btnRegister(View v){
        if(validateForm()){
            showProgressDialog();
            mAuth.createUserWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "createUserWithEmail:success");
                                dbRegister(task.getResult().getUser());
                                updateUI(task.getResult().getUser());
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(SignUpActivity.this, ""+task.getException().getMessage(),
                                        Toast.LENGTH_LONG).show();
                            }

                            // [START_EXCLUDE]
                            hideProgressDialog();
                            // [END_EXCLUDE]
                        }
                    });

        }else{
            Toast.makeText(SignUpActivity.this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
        }
    }

    public void dbRegister(FirebaseUser fuser){
        User user = new User(
                university.getText().toString().trim(),
                usernameFromEmail(email.getText().toString().trim()),
                email.getText().toString().trim(),
                password.getText().toString().trim(),
                ph.getText().toString().trim(),
                gender,
                city.getText().toString().trim(),
                getRegToken()
        );
        Log.d(TAG, ""+user);
        mDatabase.child(getString(R.string.DB_Users))
                .child(fuser.getUid())
                .setValue(user);

    }




    public String getRegToken(){
        Log.d(TAG, "getRegToken: before token");
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "getRegToken: "+token);
        return token;
    }

    public String getGender(){

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.male_radio_btn:
                        gender = "male";
                        break;
                    case R.id.female_radio_btn:
                        gender = "female";
                        break;
                }

            }
        });
        return gender;
    }

    public void updateUI(FirebaseUser user){
        hideProgressDialog();

        if (user != null){
            startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
        }
    }

    public boolean validateForm(){
        if(TextUtils.isEmpty(email.getText().toString().trim()) || !email.getText().toString().trim().contains("@") ){
            Log.d(TAG, "validateForm: email");
            return false;
        }

        else if(TextUtils.isEmpty(password.getText().toString().trim())){
            Log.d(TAG, "validateForm: password");
            return false;
        }


        else if(TextUtils.isEmpty(city.getText().toString())){
            Log.d(TAG, "validateForm: city");
            return false;
        }
        else if(!male.isChecked() && !female.isChecked()){
            Log.d(TAG, "validateForm: radiobtn");
            return false;
        }
        else{
            return true;
        }
    }

    public String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }




}







/*
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }


    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            Log.d(TAG, "createUserWithEmail:onComplete:" + task.isSuccessful());

            // If sign in fails, display a message to the user. If sign in succeeds
            // the auth state listener will be notified and logic to handle the
            // signed in user can be handled in the listener.
            if (!task.isSuccessful()) {
                Toast.makeText(EmailPasswordActivity.this, R.string.auth_failed,
                        Toast.LENGTH_SHORT).show();
            }

            // ...
        }
    });




*/


