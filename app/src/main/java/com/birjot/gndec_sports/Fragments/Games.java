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

        GamesModel u1 = new GamesModel(R.drawable.weightlifting,"GYM");
        GamesModel u2 = new GamesModel(R.drawable.volleyball,"VOLLEYBALL");
        GamesModel u3 = new GamesModel(R.drawable.hockeyyyy,"HOCKEY");
        GamesModel u4 = new GamesModel(R.drawable.tennis,"LAWNTENNIS");
        GamesModel u5 = new GamesModel(R.drawable.billiard,"BILLIARDS");
        GamesModel u6 = new GamesModel(R.drawable.fffootball,"FOOTBALL");

        GamesModel u7 = new GamesModel(R.drawable.basketball,"BASKETBALL");
        GamesModel u8 = new GamesModel(R.drawable.cricket,"CRICKET");
        GamesModel u9 = new GamesModel(R.drawable.pool,"SWIMING");
        GamesModel u10 = new GamesModel(R.drawable.strategy,"CHESS");
  //      GamesModel u11 = new GamesModel(R.drawable.footballplayer,"HANDBALL");

        GamesModel u15 = new GamesModel(R.drawable.racetrak,"TRACK AND FIELD");
        GamesModel u12 = new GamesModel(R.drawable.bike,"CYCLING");
        GamesModel u13 = new GamesModel(R.drawable.bbbadminton,"BADMINTON");
        GamesModel u14 = new GamesModel(R.drawable.onlyk,"KABADDI");


        userlist = new ArrayList<GamesModel>();
        userlist.add(u1);
        userlist.add(u2);
        userlist.add(u3);
        userlist.add(u4);
        userlist.add(u5);
        userlist.add(u6);
        userlist.add(u7);
        userlist.add(u8);
        userlist.add(u9);
        userlist.add(u10);
        userlist.add(u15);
       // userlist.add(u11);
        userlist.add(u12);
        userlist.add(u13);
        userlist.add(u14);



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
