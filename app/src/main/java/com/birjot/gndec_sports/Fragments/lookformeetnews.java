package com.birjot.gndec_sports.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.birjot.gndec_sports.Model.NewsAdapter;
import com.birjot.gndec_sports.Model.newsupload;
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
public class lookformeetnews extends Fragment {


    private RecyclerView recyclerView2;

    private RecyclerView.Adapter adapter;

    protected RecyclerView.LayoutManager mLayoutManager;

    private DatabaseReference mDatabase;

    //progress dialog
    private ProgressDialog progressDialog;



    public lookformeetnews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_lookformeetnews, container, false);
        rootView.setTag(TAG);



        recyclerView2 = (RecyclerView) rootView.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView2.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(getActivity());



        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference("meet_news");

       /* mDatabase.orderByKey();*/

        //adding an event listener to fetch values
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                ArrayList<newsupload> nloads= new ArrayList<newsupload>();
                //dismissing the progress dialog
                progressDialog.dismiss();

                //iterating through all the values in database
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    newsupload newload = postSnapshot.getValue(newsupload.class);
                    nloads.add(newload);
                }
                Collections.reverse(nloads);

                //creating adapter
                adapter = new NewsAdapter(getContext(), nloads);

                //adding adapter to recyclerview
                recyclerView2.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });


        return rootView;
        // Inflate the layout for this fragment

    }

}
