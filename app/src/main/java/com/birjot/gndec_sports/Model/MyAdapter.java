package com.birjot.gndec_sports.Model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.birjot.gndec_sports.Activities.Upload;
import com.birjot.gndec_sports.Games_Activities.BasketBall;
import com.birjot.gndec_sports.Activities.Upload;
import com.birjot.gndec_sports.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by birjot on 6/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {




    private Context context;
    private ArrayList<Upload> uploads;

    public MyAdapter(Context context, ArrayList<Upload> uploads) {
        this.uploads = uploads;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Upload upload = uploads.get(position);

        holder.textViewName.setText(upload.getName());

        Glide.with(context).load(upload.getUrl()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"xy"+upload.getName(), Toast.LENGTH_LONG).show();

              Intent intent = new Intent(context, BasketBall.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout1);

        }
    }







}
