package com.birjot.gndec_sports.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.birjot.gndec_sports.R;

public class scholarshiplist extends AppCompatActivity implements AdapterView.OnItemClickListener {

    int pos ;
    String [] heading = {"PRINCIPAL S.TARA SINGH SCHOLARSHIP", "Er.MUKHPAL SINGH GILL SCHOLARSHIP", "PROF. SADHU SINGH SIDHU SCHOLARSHIP" , "PROF. SURINDER SINGH SCHOLARSHIP" ,
            "S.RESHAM SINGH SCHOLARSHIP" ,"CHITWANT COLLEGE RECORD BREAKER AWARD" , "CHITWANT PTU BEST ATHLETE AWARD" ,"CHITWANT PTU CAPTAIN AWARD" , "CHITWANT NATIONAL POSITION HOLDER AWARD" , "CHITWANT INTER-UNIVERSITY PARTICIPATION AWARD" , "CHITWANT INTER-UNIVERSITY POSITION HOLDER AWARD" };

    ListView listview ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scholarshiplist);
        listview = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>( scholarshiplist.this,android.R.layout.simple_list_item_1 ,heading);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        pos = i ;
        switch (pos)
        {
            case 0: {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(heading[0]);
                builder.setMessage("Principal S.Tara Singh scholarship of Rs 1000/- given by S. Bhagwant Singh , Managing DirectorSpun pipe Pvt Ltd,Faridabad is awared to the Best Athlete amoungst boys ,every year since 1967");
                builder.setPositiveButton("Ok",null);
                builder.create().show();
                break ;
            }
            case 1: {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle(heading[1]);
                builder1.setMessage("Late Pilot Officer Engineer Mukhpal Singh Gill scholarship of Rs 1000/- given by S. Harbhajan Singh Gill is awarded to the best athlete amongest Girls every year since 1994");
                builder1.setPositiveButton("Ok",null);
                builder1.create().show();

                break  ;
            }
            case 2: {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[2]);
                builder3.setMessage("Interest of Rs 10,000/- donated by Retd. Sadhu Singh Sidhu is awarded to the Second Best Athlete among boys and girls every year.");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break  ;

            }
            case 3:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[3]);
                builder3.setMessage("Interest of Rs 25,000/- donated by Retd. Late Prof. S.S Minhas is awarded to the best defender , best midfielder and best attacker of football , only if Football team gets anyone of the first three position in PTU , Inter coleege Championship");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break  ;
            }
            case 4:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[4]);
                builder3.setMessage("Interest of Rs 25,000/- donated by Retd. Late Prof. S.S Minhas is awarded to the best defender , best midfielder and best attacker of football , only if Football team gets anyone of the first three position in PTU , Inter coleege Championship");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 5:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[5]);
                builder3.setMessage("Momento/cash price worth Rs 300/- is awarded to each student who sets new record in college athletic events subjects to a maximum expenditure of Rs 2000/-");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 6:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[6]);
                builder3.setMessage("PTU Best Athlete shall be awarded Cash prize / Momento costing Rs 1,500/- to be shared equally in case of more than claimant");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 7:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[7]);
                builder3.setMessage("Cash Prize/Momento worth Rs 1,000/- is awarded to PTU Team Captain ");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 8:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[8]);
                builder3.setMessage("Rs 2,000/- is awarded to a position holder at National level Games/Individual Events");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 9:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[9]);
                builder3.setMessage("Cash Prize/ Momento worth rs 1,500/- to be awarded to a student participating in Inter University Game , approved by A.I.U.");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }
            case 10:
            {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle(heading[10]);
                builder3.setMessage("Cash Prize/ Momento worth rs 1,500/- to be awarded to a student participating and securing some position in Inter University Game , approved by A.I.U.");
                builder3.setPositiveButton("Ok",null);
                builder3.create().show();
                break ;

            }

    }
}
}