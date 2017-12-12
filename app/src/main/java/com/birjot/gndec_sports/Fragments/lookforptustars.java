package com.birjot.gndec_sports.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.birjot.gndec_sports.Model.MyAdapter;
import com.birjot.gndec_sports.Model.Upload;
import com.birjot.gndec_sports.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class lookforptustars extends Fragment {


    protected RecyclerView.LayoutManager mLayoutManager;

    private RecyclerView recyclerView3;

    //adapter object
    private RecyclerView.Adapter adapter;

    //database reference
    private DatabaseReference mDatabase;

    //progress dialog
    private ProgressDialog progressDialog;

    //list to hold all the uploaded images


    public lookforptustars() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lookforptustars, container, false);
        rootView.setTag(TAG);




        recyclerView3 = (RecyclerView) rootView.findViewById(R.id.recyclerViewptu);
        recyclerView3.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView3.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(getActivity());

        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference("ptustars");

       /* mDatabase.orderByKey();*/

        //adding an event listener to fetch values
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {


                ArrayList<Upload> uploads = new ArrayList<Upload>();
                //dismissing the progress dialog
                progressDialog.dismiss();

                //iterating through all the values in database
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploads.add(upload);
                }
                Collections.reverse(uploads);
                //creating adapter
                adapter = new MyAdapter(getContext(), uploads);

                //adding adapter to recyclerview
                recyclerView3.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });


        return rootView;
        // Inflate the layout for
    }

}
