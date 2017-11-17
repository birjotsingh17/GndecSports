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
import com.birjot.gndec_sports.Games_Activities.BasketBall;
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
                        Intent intent = new Intent(context, BasketBall.class);
                        context.startActivity(intent);

                        break;
                    case 1:
                        Intent intent1 = new Intent(context, BasketBall.class);
                        context.startActivity(intent1);

                        break;

                    case 2:
                        Intent intent2 = new Intent(context, BasketBall.class);
                        context.startActivity(intent2);

                        break;

                    case 3:
                        Intent intent3 = new Intent(context, BasketBall.class);
                        context.startActivity(intent3);

                        break;

                    case 4:
                        Intent intent4 = new Intent(context, BasketBall.class);
                        context.startActivity(intent4);

                        break;

                    case 5:
                        Intent intent5 = new Intent(context, SignUpActivity.class);
                        context.startActivity(intent5);

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



