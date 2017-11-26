package com.birjot.gndec_sports.Latest_News;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.birjot.gndec_sports.R;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * Created by birjot on 26/11/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {



    private Context context;
    private ArrayList<newsupload> nloads;
    protected DatabaseReference mDatabase;


    public NewsAdapter(Context context, ArrayList<newsupload> nloads) {
        this.nloads = nloads;
        this.context = context;
    }




    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_news, parent, false);

        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        newsupload newss = nloads.get(position);
        holder.heading.setText(newss.getHeading());
        holder.datee.setText(newss.getDatee());
        holder.description.setText(newss.getDescription());


    }

    @Override
    public int getItemCount() {

        return nloads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView heading, description, datee;


        public ViewHolder(View itemView) {
            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.textnewsh);
            datee = (TextView) itemView.findViewById(R.id.textnewsdate);
            description = (TextView) itemView.findViewById(R.id.textnewsd);

        }
    }




}
