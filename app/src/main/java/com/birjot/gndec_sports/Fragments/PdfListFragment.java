package com.birjot.gndec_sports.Fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.birjot.gndec_sports.Model.Pdf;
import com.birjot.gndec_sports.Model.PdfAdapter;
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
public class PdfListFragment extends Fragment {

    private RecyclerView recyclerpdf;

    private RecyclerView.Adapter adapter;

    protected RecyclerView.LayoutManager mLayoutManager;

    private DatabaseReference mDatabase;

    //progress dialog
    private ProgressDialog progressDialog;

    public PdfListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_pdf_list, container, false);
        rootView.setTag(TAG);



        recyclerpdf = (RecyclerView) rootView.findViewById(R.id.recyclerpdf);
        recyclerpdf.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(getActivity());

        recyclerpdf.setLayoutManager(mLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(getActivity());



        //displaying progress dialog while fetching images
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference("Pdfs");

       /* mDatabase.orderByKey();*/

        //adding an event listener to fetch values
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                ArrayList<Pdf> nloads= new ArrayList<Pdf>();
                //dismissing the progress dialog
                progressDialog.dismiss();

                //iterating through all the values in database
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Pdf newload = postSnapshot.getValue(Pdf.class);
                    nloads.add(newload);
                }
                Collections.reverse(nloads);

                Log.d("app", "nload: "+nloads);

                //creating adapter
                adapter = new PdfAdapter(getContext(), nloads);

                //adding adapter to recyclerview
                recyclerpdf.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });


        return rootView;

        //return inflater.inflate(R.layout.fragment_pdf_list, container, false);
    }

}
