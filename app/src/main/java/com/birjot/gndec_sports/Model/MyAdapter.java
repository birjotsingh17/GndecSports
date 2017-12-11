package com.birjot.gndec_sports.Model;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.birjot.gndec_sports.Activities.HomeActivity;
import com.birjot.gndec_sports.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

/**
 * Created by birjot on 6/11/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {




    ProgressDialog mProgressDialog;
    private Context context;
    private ArrayList<Upload> uploads;
    protected DatabaseReference mDatabase;

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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Upload upload = uploads.get(position);

        Log.d("app", "Upload: "+upload);

        holder.textViewName.setText(upload.getDescription());

        Glide.with(context).load(upload.getUrl()).into(holder.imageView);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* showDialog(upload);*/




              /*  Intent intent = new Intent(context, delete.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("keyName",""+upload.getUrl());
                context.startActivity(intent);*/

            }

        });
    }

    void showDialog(final Upload upload){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Delete: " );
        builder.setMessage("Are you Sure ?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                del(upload);


            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.create().show();
    }






    public void del(final Upload upload) {

        showCaptionProgressDialog("Deleting...");

        // String xyx = getIntent().getExtras().getString("keyName");

        // String storageUrl = "1510554381738.jpg";
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("uploads")
                .child(upload.getKey())
                .child(upload.getName());
        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // File deleted successfully
                //Log.d(TAG, "onSuccess: deleted file");
                Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();

                mDatabase = FirebaseDatabase.getInstance().getReference();
                DatabaseReference globalRef = mDatabase.child("uploads").child(upload.getKey());

                DatabaseReference globalRef1 = mDatabase.child("extramural").child(upload.getKey());
                Log.d("app", "onSuccess: "+globalRef.toString());
                //DatabaseReference userPdfRef = mDatabase.child(getString(R.string.DB_user_pdfs)).child(pdf.getUid()).child(upload.getKey());
                deleteOnFirebaseDB(globalRef);
                deleteOnFirebaseDB(globalRef1);
                // deletePdfOnFirebaseDB(userPdfRef);



            /*    Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);*/
                hideProgressDialog();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {


                hideProgressDialog();
                Toast.makeText(context, exception.getMessage(), Toast.LENGTH_SHORT).show();
                // Uh-oh, an error occurred!
                // Log.d(TAG, "onFailure: did not delete file");
            }
        });


        //Toast.makeText(this,"file : " + xyx, Toast.LENGTH_LONG).show();

    }


    public void deleteOnFirebaseDB(DatabaseReference Ref){
        Ref.removeValue();
        this.notifyDataSetChanged();
        hideProgressDialog();
    }





    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }


    public void showCaptionProgressDialog(String caption) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(context);
            mProgressDialog.setMessage(caption);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
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
