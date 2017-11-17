package com.birjot.gndec_sports.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.birjot.gndec_sports.Model.GamesAdapter;
import com.birjot.gndec_sports.Model.GamesModel;
import com.birjot.gndec_sports.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Games extends Fragment {

    ArrayList<GamesModel> userlist;
    GamesAdapter adapter1;
    RecyclerView recyclerView;


   /* void initview(){



    }*/

    public Games() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.Recycle);

        GamesModel u1 = new GamesModel(R.drawable.basket,"BASKETBALL");
        GamesModel u2 = new GamesModel(R.drawable.cricket,"CRICKET");
        GamesModel u3 = new GamesModel(R.drawable.football,"FOOTBALL");
        GamesModel u4 = new GamesModel(R.drawable.basket,"HANDBALL");
        GamesModel u5 = new GamesModel(R.drawable.cricket,"BADMINTON");
        GamesModel u6 = new GamesModel(R.drawable.football,"ATHLETICS");



        userlist = new ArrayList<GamesModel>();
        userlist.add(u1);
        userlist.add(u2);
        userlist.add(u3);
        userlist.add(u4);
        userlist.add(u5);
        userlist.add(u6);


        adapter1= new GamesAdapter(getActivity(),R.layout.gamedesign,userlist);



       /* RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter1);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        //initview();



        return inflater.inflate(R.layout.fragment_games2, container, false);
    }

}
