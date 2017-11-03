package com.birjot.gndec_sports.Activities;


import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import com.birjot.gndec_sports.R;

/**
 * Created by birjot on 31/10/17.
 */

public class Progressdialog extends AppCompatActivity {

//    Progressdialog mProgressDialog;
    ProgressDialog mProgressDialog;

    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showStorageProgressDialog(String caption) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(caption);
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }



}
