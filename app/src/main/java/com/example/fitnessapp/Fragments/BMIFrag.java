package com.example.fitnessapp.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class BMIFrag extends Fragment {

    LinearLayout layout;
    TextView heighttv, weighttv;
    TextView resulttv, wordresult, commenttv, tips1, tips2, tips3;
    ImageView tips1image, tips2image, tips3image;
    LottieAnimationView lottieAnimationView;
    FirebaseUser user;
    FirebaseAuth fAuth;
    FirebaseFirestore mFirestore;
    DocumentReference documentReference;



   public BMIFrag()
   {

   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {





        View view = inflater.inflate(R.layout.bmlresult, container, false);

        heighttv = view.findViewById(R.id.heightvalue);
        weighttv = view.findViewById(R.id.weightvalue);
        lottieAnimationView = view.findViewById(R.id.bmisplash);
        layout = view.findViewById(R.id.containerL);
        resulttv = view.findViewById(R.id.bmiValueTV);
        wordresult = view.findViewById(R.id.bmiLabelTV);
        commenttv = view.findViewById(R.id.commentTV);
        tips1image = view.findViewById(R.id.advice1IMG);
        tips2image = view.findViewById(R.id.advice2IMG);
        tips3image = view.findViewById(R.id.advice3IMG);
        tips1 = view.findViewById(R.id.advice1TV);
        tips2 = view.findViewById(R.id.advice2TV);
        tips3 = view.findViewById(R.id.advice3TV);



        //Firebase Stuff//
        fAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        String Userid = user.getUid();


        documentReference = mFirestore.collection("Users").document(Userid);

        documentReference.addSnapshotListener((value, error) -> {
            if(value.exists())
            {

                heighttv.setText(value.getString("Height"));
                weighttv.setText(value.getString("Weight"));
                calculateBMIResult();


            }
            else {
                Log.d("tag", " Document do not exists");
            }
        });

      /* btn.setOnClickListener(v -> {




            String hh = heighttx.getText().toString();
            String ww = weighttx.getText().toString();



            if(!TextUtils.isEmpty(hh)  && !TextUtils.isEmpty(ww)) {

                //Get the user values from the widget reference
                float height = Float.parseFloat(hh) / 100;
                float weight = Float.parseFloat(ww);


                if (weight > 0 && weight < 600 && height >= 0.50 && height < 30.50) {

                    float bmiValue = calculateBMI(weight, height);
                    Intent intent = new Intent(getActivity(), BMIResult.class);
                    intent.putExtra("Result", bmiValue);
                    startActivity(intent);




                } else {


                    Snackbar.make(view, "Missing values or Incorrect input", BaseTransientBottomBar.LENGTH_SHORT).show();

                }
            }



        });

       */

        return view;
    }

    private void calculateBMIResult() {

      

       String hh = heighttv.getText().toString();
       String ww = weighttv.getText().toString();

        double height = Double.parseDouble((hh)) / 100;
        double weight = Double.parseDouble((ww));
        double bmiValue = calculateBMI(weight, height);

        if (weight > 0 && weight < 600 && height >= 0.50 && height < 30.50)
        {


            resulttv.setText(String.valueOf(Math.round(bmiValue)));

            if (bmiValue < 18.5) {

                lottieAnimationView.setAnimation(R.raw.warning);
                layout.setBackgroundColor(Color.parseColor("#ffcc00"));
                wordresult.setText("Oh Oh, You have an UnderWeight!");
                commenttv.setText("Here are some advices to help you increase your weight");
                tips1image.setImageResource(R.drawable.nowater);
                tips1.setText("Don't drink water before meals");
                tips2image.setImageResource(R.drawable.bigmeal);
                tips2.setText("Use bigger plates");
                tips3.setText("Get quality sleep");

                resulttv.setText(String.valueOf(Math.round(bmiValue)));




            } else if (bmiValue > 26) {

                lottieAnimationView.setAnimation(R.raw.fire);
                lottieAnimationView.setRepeatCount(100);
                layout.setBackgroundColor(Color.parseColor("#ec1313"));
                wordresult.setText("Warning ,You are obese!!!");
                commenttv.setText("Here are some advices to help you reduce your weight");
                tips1image.setImageResource(R.drawable.nowater);
                tips1.setText("Drink water a half hour before meals");
                tips2image.setImageResource(R.drawable.bigmeal);
                tips2.setText("Eat more servings of vegetables and fruits");
                tips3.setText("Drink coffee or tea and Avoid sugary food");


                resulttv.setText(String.valueOf(Math.round(bmiValue)));





            }
        }
    }


    //Formula BMI
    private Double calculateBMI (Double weight, Double height) {
        return (weight / (height * height));
    }


}







