package com.birjot.gndec_sports.Model;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.birjot.gndec_sports.Activities.Graphs;
import com.birjot.gndec_sports.Activities.SignUpActivity;
import com.birjot.gndec_sports.Games_Activities.Badminton;
import com.birjot.gndec_sports.Games_Activities.BasketBall;
import com.birjot.gndec_sports.Games_Activities.Cycling;
import com.birjot.gndec_sports.Games_Activities.Football;
import com.birjot.gndec_sports.Games_Activities.Handball;
import com.birjot.gndec_sports.Games_Activities.Hockey;
import com.birjot.gndec_sports.Games_Activities.Kabadi;
import com.birjot.gndec_sports.Games_Activities.LawnTennis;
import com.birjot.gndec_sports.Games_Activities.Shooting;
import com.birjot.gndec_sports.Games_Activities.Swimming;
import com.birjot.gndec_sports.Games_Activities.billiards;
import com.birjot.gndec_sports.Games_Activities.chess;
import com.birjot.gndec_sports.Games_Activities.cricket;
import com.birjot.gndec_sports.Games_Activities.gym;
import com.birjot.gndec_sports.Games_Activities.volleyball;
import com.birjot.gndec_sports.R;

import java.util.ArrayList;

/**
 * Created by birjot on 13/11/17.
 */

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.ViewHolder> {


    Context context;
    int resource;
    ArrayList<GamesModel> userList;


    public GamesAdapter(Context context, int resource, ArrayList<GamesModel> userList){
        this.context = context;
        this.resource = resource;
        this.userList = userList;
    }


    @Override
    public GamesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(resource,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }



  /*  @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }*/

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d("app", "onBindViewHolder: position "+position);

        final GamesModel user = userList.get(position);

        holder.txtName.setText(user.getName());
        holder.img.setImageResource(user.getIcon());



        // onclick recyclerview :: https://www.youtube.com/watch?v=dmIfFIHnKsk
        holder.constraintLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

               // Toast.makeText(context, "you clicked" +user,Toast.LENGTH_LONG).show();


                switch (position) {
                    case 0:
                        Intent intent = new Intent(context, gym.class);
                        context.startActivity(intent);

                        break;
                    case 1:
                        Intent intent1 = new Intent(context, volleyball.class);
                        context.startActivity(intent1);

                        break;

                    case 2:
                        Intent intent2 = new Intent(context, Hockey.class);
                        context.startActivity(intent2);

                        break;

                    case 3:
                        Intent intent3 = new Intent(context, LawnTennis.class);
                        context.startActivity(intent3);

                        break;

                    case 4:
                        Intent intent4 = new Intent(context, billiards.class);
                        context.startActivity(intent4);

                        break;

                    case 5:
                        Intent intent5 = new Intent(context, Football.class);
                        context.startActivity(intent5);

                        break;

                    case 6:
                        Intent intent6 = new Intent(context, BasketBall.class);
                        context.startActivity(intent6);

                        break;
                    case 7:
                        Intent intent7 = new Intent(context, cricket.class);
                        context.startActivity(intent7);

                        break;

                    case 8:
                        Intent intent8 = new Intent(context, Swimming.class);
                        context.startActivity(intent8);

                        break;

                    case 9:
                        Intent intent9 = new Intent(context, chess.class);
                        context.startActivity(intent9);

                        break;

                    case 10:
                        Intent intent10 = new Intent(context, Handball.class);
                        context.startActivity(intent10);

                        break;

                    case 11:
                        Intent intent11 = new Intent(context, Cycling.class);
                        context.startActivity(intent11);

                        break;

                    case 12:
                        Intent intent12 = new Intent(context, Badminton.class);
                        context.startActivity(intent12);

                        break;

                    case 13:
                        Intent intent13 = new Intent(context, Kabadi.class);
                        context.startActivity(intent13);

                        break;

                    case 14:
                        Intent intent14 = new Intent(context, Shooting.class);
                        context.startActivity(intent14);

                        break;
                }

            }
        });

    }


    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtName;
        ImageView img;
        public ConstraintLayout constraintLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);

            img=(ImageView) itemView.findViewById(R.id.imageView4);

            txtName=(TextView) itemView.findViewById(R.id.textView5);

            constraintLayout = (ConstraintLayout) itemView.findViewById(R.id.constr);
        }
    }

   /* Context context;
    int resource;
    ArrayList<GamesModel> userList;


    public GamesAdapter(Context context, int resource, ArrayList<GamesModel> objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        userList = objects;*/



    }

/*
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = null;

        //view should point to list_item
        view = LayoutInflater.from(context).inflate(resource,parent,false);

        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        TextView txtName = (TextView)view.findViewById(R.id.textViewName);

        GamesModel gm = userList.get(position);
        imageView.setBackgroundResource(gm.getIcon());
        txtName.setText(gm.getName());


        return view;
    }*/



