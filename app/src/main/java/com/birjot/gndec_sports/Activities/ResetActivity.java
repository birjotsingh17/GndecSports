package com.birjot.gndec_sports.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ResetActivity extends Progressdialog {

    EditText txtmail;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setContentView(R.layout.activity_reset);



        txtmail = (EditText) findViewById(R.id.editTextmail);

        btnReset = (Button) findViewById(R.id.btnReset);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResetClicked();
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

    private void ResetClicked(){

        if(TextUtils.isEmpty(txtmail.getText().toString().trim())){
            txtmail.setError("Fields can't be empty");

        }

        else if (!emailValidator(txtmail.getText().toString())) {
            txtmail.setError("Please enter a valid Email address ");
        }
        else{
            authReset(txtmail.getText().toString().trim());
        }
    }

    public void authReset(String txtmail){
        showProgressDialog();

        FirebaseAuth auth = FirebaseAuth.getInstance();

        auth.sendPasswordResetEmail(txtmail)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                            showDialog();


                            // do something when mail was sent successfully.
                        } else {

                            Toast.makeText(ResetActivity.this, "Please try again..!", Toast.LENGTH_SHORT).show();
                            // ...
                        }

                        hideProgressDialog();
                    }
                });

    }


    void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Reset link sent to your email.");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Intent intent = new Intent(ResetActivity.this, SigninActivity.class);
                startActivity(intent);

            }
        });
       /* builder.setNegativeButton("Cancel", null);*/
        builder.create().show();
    }

   /* public void backclick(View view){
        Intent intent = new Intent(this, SigninActivity.class);
        startActivity(intent);
    }*/



   public boolean onSupportNavigateUp(){
       onBackPressed();
       return true;
   }

}
