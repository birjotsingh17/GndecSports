package com.birjot.gndec_sports.Model;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.birjot.gndec_sports.R;
import com.birjot.gndec_sports.Services.MyDownloadService;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by birjot on 6/12/17.
 */

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.ViewHolder> {

    ProgressDialog mProgressDialog;

    private Context context;
    private ArrayList<Pdf> nloads;
    protected DatabaseReference mDatabase;
    StorageReference mStorageRef;
    static final int FINISHED_NOTIFICATION_ID = 1;

    public PdfAdapter(Context context, ArrayList<Pdf> nloads) {
        this.nloads = nloads;
        this.context = context;
        Log.d("app", "PdfAdapter: ");
    }


    @Override
    public PdfAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pdfresult, parent, false);

        PdfAdapter.ViewHolder viewHolder = new PdfAdapter.ViewHolder(itemView);
        Log.d("app", "onCreateViewHolder: ");
        return new PdfAdapter.ViewHolder(itemView);
//        return null;
    }

    @Override
    public void onBindViewHolder(PdfAdapter.ViewHolder holder, int position) {

        final Pdf newss = nloads.get(position);
        holder.heading.setText(newss.getPdfname());
        holder.datee.setText(newss.getUploaddate());
        holder.description.setText(newss.getDescription());
        Log.d("app", "onBindViewHolder: ");
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDialog(newss);

            }

        });


    }

    void showDialog(final Pdf newss){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Download this file ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                downld(newss);


            }
        });
        builder.setNegativeButton("No", null);
        builder.create().show();
    }

    public void downld(final Pdf newss){

      StorageReference mStorageRef = FirebaseStorage.getInstance().getReferenceFromUrl("gs://gndec-b48d5.appspot.com")
                .child("pdfupload")
                .child(newss.getPdfKey())
                .child(newss.getPdfname());
        final String downloadFileName = mStorageRef.getName();
       /* downloadFromPath(downloadFileName);*/
       final File rootPath = new File(Environment.getExternalStorageDirectory(), "GNDECsports");
        final File localopen = new File(rootPath,downloadFileName);
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }
        final File localFile = new File(rootPath,downloadFileName);
        mStorageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                //Log.d(TAG, "download:SUCCESS");
                Log.e("firebase ",";local tem file created  created " +localFile.toString());

               // showDownloadFinishedNotification(newss.getPdfname(),downloadFileName, (int) taskSnapshot.getTotalByteCount());

                // Mark task completed
                //taskCompleted();
                Toast.makeText(context, "Download Successful", Toast.LENGTH_SHORT).show();

                Uri path = Uri.fromFile(localopen);
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setDataAndType(path, "application/pdf");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);

                } catch (ActivityNotFoundException e) {
                   //setError("PDF Reader application is not installed in your device");
                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        Log.w(TAG, "download:FAILURE", exception);
                       // showDownloadFinishedNotification(pdfname,downloadPath, -1);
                        Toast.makeText(context, "Please check your internet connection", Toast.LENGTH_SHORT).show();
                        // Mark task completed
                        //taskCompleted();
                    }
                });
    };
/*
        String pdfNAME = newss.getPdfname().toString();
        String pdfkey = newss.getPdfKey().toString();

        context.startService(new Intent(context, MyDownloadService.class)
                        .putExtra("pdfname", pdfNAME)
                        .putExtra("pdfkey", pdfkey)
                        .setAction(MyDownloadService.ACTION_DOWNLOAD)
        );

        if(isFirstDownload()){
            showDownloadLocationAlert();
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(context.getString(R.string.isFirstDownload), false);
            editor.commit();
        }
        else {
            Toast.makeText(context, context.getString(R.string.progress_downloading), Toast.LENGTH_SHORT).show();
        }*/


  /*  private void showDownloadFinishedNotification(String Title,String downloadPath, int bytesDownloaded) {
        // Hide the progress notification
        //dismissProgressNotification();

        // Intent intent = new Intent(MyDownloadService.this, HomeActivity.class);
        File rootPath = new File(Environment.getExternalStorageDirectory(), context.getString(R.string.app_name));

        File localFile = new File(rootPath,downloadPath);
        // Download and get total bytes
        mStorageRef.getFile(localFile);

        MimeTypeMap mime = MimeTypeMap.getSingleton();
        String ext=localFile.getName().substring(localFile.getName().indexOf(".")+1);
        String type = mime.getMimeTypeFromExtension(ext);
        Intent openFile = new Intent(Intent.ACTION_VIEW, Uri.fromFile(localFile));
        openFile.setDataAndType(Uri.fromFile(localFile), type);

        openFile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, openFile, 0);



        boolean success = bytesDownloaded != -1;
        String caption = success ? context.getString(R.string.download_success) : context.getString(R.string.download_failure);
        showFinishedNotification(Title,caption, pendingIntent, success);
    }*/


  /*  protected void showFinishedNotification(String Title,String caption, PendingIntent pendingIntent, boolean success) {

        int icon = success ? R.drawable.ic_check_white_24 : R.drawable.ic_cross;

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(icon)
                .setContentTitle(Title)
                .setContentText(caption)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(FINISHED_NOTIFICATION_ID, builder.build());
    }*/
    public void del(final Pdf newss) {

        showCaptionProgressDialog("Deleting...");

        // String xyx = getIntent().getExtras().getString("keyName");

        // String storageUrl = "1510554381738.jpg";
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("pdfupload")
                .child(newss.getPdfKey())
                .child(newss.getPdfname());
        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                // File deleted successfully
                //Log.d(TAG, "onSuccess: deleted file");
                Toast.makeText(context, "deleted", Toast.LENGTH_SHORT).show();

                mDatabase = FirebaseDatabase.getInstance().getReference();
                DatabaseReference globalRef = mDatabase.child("Pdfs").child(newss.getPdfKey());
                Log.d("app", "onSuccess: "+globalRef.toString());
                //DatabaseReference userPdfRef = mDatabase.child(getString(R.string.DB_user_pdfs)).child(pdf.getUid()).child(upload.getKey());
                deleteOnFirebaseDB(globalRef);
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
        return nloads.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView heading, description, datee;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            heading = (TextView) itemView.findViewById(R.id.headpdf);
            datee = (TextView) itemView.findViewById(R.id.pdfdate);
            description = (TextView) itemView.findViewById(R.id.descpdf);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearlayoutpdf);
        }
    }
}
