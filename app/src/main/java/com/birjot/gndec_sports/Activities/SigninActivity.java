package com.birjot.gndec_sports.Activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.birjot.gndec_sports.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SigninActivity extends Progressdialog {


    EditText txtEmail,txtPassword;
    Button btnSignIn;

    private FirebaseAuth mAuth;
   /* private FirebaseAuth.AuthStateListener mAuthListener;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        mAuth = FirebaseAuth.getInstance();


        txtEmail = (EditText) findViewById(R.id.EditTextEmail);
        txtPassword = (EditText) findViewById(R.id.EditTextPassword);
        btnSignIn = (Button) findViewById(R.id.ButtonSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignInClicked();
            }
        });

/*
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


/*
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }*/

    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }


    public void updateUI(FirebaseUser user){

        if(user != null){
            if(user.getEmail().contains("admin@mail.com")){
                startActivity(new Intent(SigninActivity.this, adminhome.class));
            }
            else{
                startActivity(new Intent(SigninActivity.this, HomeActivity.class));
            }
        }
    }





    private void SignInClicked(){

        if(TextUtils.isEmpty(txtEmail.getText().toString().trim())){
            txtEmail.setError("Fields can't be empty");

        }
        else if(TextUtils.isEmpty(txtPassword.getText().toString().trim())){
            txtPassword.setError("Fields can't be empty");
        }
        else if (!emailValidator(txtEmail.getText().toString())) {
            txtEmail.setError("Please enter a valid Email address ");
        }
        else{
            authSignIn(txtEmail.getText().toString().trim(), txtPassword.getText().toString().trim());
        }
    }



    public void authSignIn(String email, String password){
        showProgressDialog();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Toast.makeText(SigninActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hideProgressDialog();
                    }
                });
    }


    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String  email_pattern = "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+";
        pattern = Pattern.compile(email_pattern);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void onclick(View view) {
        startActivity(new Intent(SigninActivity.this, SignUpActivity.class));
    }


/*

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());

            // If sign in fails, display a message to the user. If sign in succeeds
            // the auth state listener will be notified and logic to handle the
            // signed in user can be handled in the listener.
            if (!task.isSuccessful()) {
                Log.w(TAG, "signInWithEmail:failed", task.getException());
                Toast.makeText(EmailPasswordActivity.this, R.string.auth_failed,
                        Toast.LENGTH_SHORT).show();
            }

            // ...
        }
    });

*/


}
