package com.example.fitnessapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fitnessapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.eazegraph.lib.charts.PieChart;


public class CaloriesFrag extends Fragment {

    Spinner spinner;
    TextView heighttv, weighttv, trackcalortv, agettv, lostweight, gainweight;
    FirebaseAuth fAuth;
    FirebaseFirestore mFirestore;
    DocumentReference documentReference;
    FirebaseUser user;
    double tmpcurrentclaories, tmplossweight, tmpgainweight;
    String tmpgender,calweight,calheight,calage;
    ArrayAdapter arrayAdapter;
    static final String[] methodscalorie = {"Progress","BMR Result", "Sedentary: less/no exercise", "Light Exercise: 1-3times", "Moderate Exercise: 4-5times", "Daily Exercise"};



    public CaloriesFrag() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress, container, false);


        spinner = view.findViewById(R.id.spinnercalorie);
        lostweight = view.findViewById(R.id.reduceweightcalories);
        gainweight = view.findViewById(R.id.gainweightcalories);
        heighttv = view.findViewById(R.id.heightcm);
        weighttv = view.findViewById(R.id.weightcm);
        agettv = view.findViewById(R.id.AGEcm);
        trackcalortv = view.findViewById(R.id.targetcalories);


        fAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        String Userid = user.getUid();

        //Spinner
         arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.springlayout, methodscalorie);
         arrayAdapter.setDropDownViewResource(R.layout.spingdropdown);
         spinner.setAdapter(arrayAdapter);



        documentReference = mFirestore.collection("Users").document(Userid);
        documentReference.addSnapshotListener((value, error) -> {
            if(value.exists())
            {

                heighttv.setText(value.getString("Height"));
                weighttv.setText(value.getString("Weight"));
                agettv.setText(value.getString("Age"));
                tmpgender = (String)value.get("Gender");




                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:

                                break;
                            case 1:
                                BMRcalorietarget();

                                break;
                            case 2:
                                Sedentarycalorietarget();
                                break;
                            case 3:
                                Lightcalorietarget();
                                break;
                            case 4:
                                Moderatecalorietarget();
                                break;
                            case 5:
                                Activecalorietarget();
                                break;

                        }
                    }



                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }


                });


            }
            else {
                Log.d("tag", "onEvent: Document do not exists");
            }
        });







        return view;
    }




    private void BMRcalorietarget() {



        if(tmpgender.equalsIgnoreCase("Male"))
        {
            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (10*(calweights) + 6.25 * (calheights) + 5) - 5 * (calages) ;

            trackcalortv.setText(String.valueOf(tmpcurrentclaories));
            tmplossweight = tmpcurrentclaories * 0;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories * 0;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));

        }
        else if(tmpgender.equalsIgnoreCase("Female"))
        {

            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (10*(calweights) + 6.25 * (calheights)) - 5 * (calages) - 161 ;

            trackcalortv.setText(String.valueOf(tmpcurrentclaories));
            tmplossweight = tmpcurrentclaories * 0;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories * 0;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));
        }

    }



   private void Sedentarycalorietarget() {





        if(tmpgender.equals("Male"))
        {
            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = ((10*(calweights) + 6.25 * (calheights) + 5) - 5 * (calages)) * 1.2 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));


        }
        else if(tmpgender.equals("Female"))
        {

            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (((10*(calweights) + 6.25 * (calheights)) - 5 * (calages)) - 161) * 1.2 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));
        }

    }

    private void Lightcalorietarget() {
        if(tmpgender.equals("Male"))
        {
            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = ((10*(calweights) + 6.25 * (calheights) + 5) - 5 * (calages)) * 1.375 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));


        }
        else if(tmpgender.equals("Female"))
        {

            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (((10*(calweights) + 6.25 * (calheights)) - 5 * (calages)) - 161) * 1.375 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));
        }

    }


    private void Moderatecalorietarget() {

        if(tmpgender.equals("Male"))
        {
            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = ((10*(calweights) + 6.25 * (calheights) + 5) - 5 * (calages)) * 1.55 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));


        }
        else if(tmpgender.equals("Female"))
        {

            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (((10*(calweights) + 6.25 * (calheights)) - 5 * (calages)) - 161) * 1.55 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));
        }

    }

    private void Activecalorietarget() {
        if(tmpgender.equals("Male"))
        {
            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = ((10*(calweights) + 6.25 * (calheights) + 5) - 5 * (calages)) * 1.9 ;

            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));


        }
        else if(tmpgender.equals("Female"))
        {

            calheight = heighttv.getText().toString();
            calweight = weighttv.getText().toString();
            calage = agettv.getText().toString();

            int calages = Integer.parseInt(calage);
            double calheights = Double.parseDouble(calheight);
            double calweights = Double.parseDouble(calweight);
            tmpcurrentclaories = (((10*(calweights) + 6.25 * (calheights)) - 5 * (calages)) - 161) * 1.9 ;
            trackcalortv.setText(String.valueOf(Math.round(tmpcurrentclaories)));
            tmplossweight = tmpcurrentclaories - 500;
            lostweight.setText(String.valueOf(Math.round(tmplossweight)));
            tmpgainweight = tmpcurrentclaories + 500;
            gainweight.setText(String.valueOf(Math.round(tmpgainweight)));
        }

    }



}