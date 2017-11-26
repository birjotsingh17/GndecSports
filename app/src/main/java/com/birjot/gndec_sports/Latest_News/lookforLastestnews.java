package com.birjot.gndec_sports.Latest_News;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class lookforLastestnews extends Fragment {

    private ArrayList<newsupload> nloads;

    private RecyclerView recyclerView1;

    private RecyclerView.Adapter adapter;

    protected RecyclerView.LayoutManager mLayoutManager;

    private DatabaseReference mDatabase;

    //progress dialog
    private ProgressDialog progressDialog;

    public lookforLastestnews() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_lookfor_lastestnews, container, false);
        rootView.setTag(TAG);



        recyclerView1 = (RecyclerView) rootView.findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView1.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(getActivity());

        nloads = new ArrayList<>();

        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference("news");

       /* mDatabase.orderByKey();*/

        //adding an event listener to fetch values
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
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
                recyclerView1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });


        return rootView;
/*
        return inflater.inflate(R.layout.fragment_posts, container, false);*/
    }







       /* recyclerView1 = (RecyclerView)getView().findViewById(R.id.recyclerView1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        new GetDataFromFirebase().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("news");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<String> values = (ArrayList<String>) dataSnapshot.getValue();
                adapter = new NewsAdapter(getContext(),nloads);

                //adding adapter to recyclerview
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lookfor_lastestnews, container, false);

    }*/

}
