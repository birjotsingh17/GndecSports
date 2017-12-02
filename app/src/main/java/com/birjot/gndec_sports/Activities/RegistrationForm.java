package com.birjot.gndec_sports.Activities;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.net.nsd.NsdManager;
        import android.preference.PreferenceManager;
        import android.support.annotation.NonNull;
        import android.support.v4.content.SharedPreferencesCompat;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.birjot.gndec_sports.R;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

public class RegistrationForm extends AppCompatActivity {


    EditText edtFName , edtLName , edtEmail , edtURoll ;
    Button btnSubmit ;

    Spinner f1,f2,t1 ;
    DatabaseReference rootRef,demoRef,path;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        initview();

    }
    // initialization is done here
    public void initview()
    {
        rootRef = FirebaseDatabase.getInstance().getReference();
        demoRef = rootRef.child("Registration Form");
        edtFName = (EditText)findViewById(R.id.editTextFirstName);
        edtLName = (EditText)findViewById(R.id.editTextLastName);
        edtEmail = (EditText)findViewById(R.id.editTextEmail);
        edtURoll = (EditText)findViewById(R.id.editTextRollNo);
        f1 = (Spinner)findViewById(R.id.spinnerFieldEvent);
        f2 = (Spinner)findViewById(R.id.spinnerFieldEvent2);
        t1 = (Spinner)findViewById(R.id.spinnerTrackEvent);

        String[] Field1 = getResources().getStringArray(R.array.FieldEvents);

        ArrayAdapter<String> Field_adapter1 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Field1);
        f1.setAdapter(Field_adapter1);

        f1.getDrawingCacheBackgroundColor();



        String[] Field2 = getResources().getStringArray(R.array.FieldEvents);


        ArrayAdapter<String> Field_adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Field2);
        f2.setAdapter(Field_adapter2);

        String[] Track1 = getResources().getStringArray(R.array.TrackEvents);

        ArrayAdapter<String> Track_adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,Track1);
        t1.setAdapter(Track_adapter);

        btnSubmit = (Button)findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String FName = edtFName.getText().toString();
//                String LName  = edtLName.getText().toString();
//                String email = edtEmail.getText().toString();
//                String roll = edtURoll.getText().toString();
//                String Field1 = f1.getSelectedItem().toString();
//                String Field2 = f2.getSelectedItem().toString();
//                String Track1 = t1.getSelectedItem().toString();
////                path = demoRef.push() ;

                demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(!(dataSnapshot.hasChild(FirebaseAuth.getInstance().getCurrentUser().getUid()))){
                            String FName = edtFName.getText().toString();
                            String LName  = edtLName.getText().toString();
                            String email = edtEmail.getText().toString();
                            String roll = edtURoll.getText().toString();
                            String Field1 = f1.getSelectedItem().toString();
                            String Field2 = f2.getSelectedItem().toString();
                            String Track1 = t1.getSelectedItem().toString();
                            path = demoRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid());

                            path.child("FName").setValue(FName);
                            path.child("LName").setValue(LName);
                            path.child("email").setValue(email);
                            path.child("rollNo").setValue(roll);
                            path.child("FieldEvent1").setValue(Field1);
                            path.child("FieldEvent2").setValue(Field2);
                            path.child("Track Event1").setValue(Track1);

                            Toast.makeText(RegistrationForm.this, "Successfully Submitted ", Toast.LENGTH_SHORT).show();
                            System.out.println(FirebaseAuth.getInstance().getCurrentUser().getUid()) ;

                        }
                        else
                        {
                            Toast.makeText(RegistrationForm.this, "U are already here !!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });




            }
        });
    }


//        startActivity(new Intent(this, HomeActivity.class));
}








