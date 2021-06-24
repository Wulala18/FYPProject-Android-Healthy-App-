package com.example.fitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.fitnessapp.EditPassword;
import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class ProfileFrag extends Fragment {

    private static final String TAG = "ProfileFrag";
    private static final String USERS = "users";
    TextView username;
    TextInputEditText usernames,useremail,userheight,userweight,userage;
    RadioButton usermale,userfemale;
    Button updateprofile, updatepassowrd;
    FirebaseAuth fAuth;
    FirebaseFirestore mFirestore;
    DocumentReference documentReference;
    FirebaseUser user;
    ConstraintLayout constraintLayout;
    ProgressBar progressBar;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      //  String email = intent.getStringExtra(USERS);
         View view = inflater.inflate(R.layout.fragment_profile, container, false);
         constraintLayout = view.findViewById(R.id.constraintLayout2);
        useremail = view.findViewById(R.id.profileEmail);
        username= view.findViewById(R.id.profileName);
        usernames = view.findViewById(R.id.profileNamees);
        userheight = view.findViewById(R.id.profileHeight);
        userweight = view.findViewById(R.id.profileWeight);
        usermale = view.findViewById(R.id.pmale);
        userage = view.findViewById(R.id.profileage);
        userfemale = view.findViewById(R.id.pfemale);
        updateprofile =  view.findViewById(R.id.changeProfile);
        progressBar = view.findViewById(R.id.progressBar);
        updatepassowrd = view.findViewById(R.id.changePassword);










        //Firebase Stuff//
        fAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();
        String Userid = user.getUid();
        progressBar.setVisibility(View.GONE);






       documentReference = mFirestore.collection("Users").document(Userid);
        documentReference.addSnapshotListener((value, error) -> {
                if(value.exists())
                {

                    useremail.setText(value.getString("Email"));
                    username.setText(value.getString("Name"));
                    usernames.setText(value.getString("Name"));
                    userheight.setText(value.getString("Height"));
                    userweight.setText(value.getString("Weight"));
                    userage.setText(value.getString("Age"));

                    String tmpgender = (String) value.get("Gender");



                    if(tmpgender.equalsIgnoreCase("Male"))
                    {
                        usermale.setChecked(true);
                    }
                    else if(tmpgender.equalsIgnoreCase("Female"))
                    {
                        userfemale.setChecked(true);
                    }




                }
                else {
                    Log.d("tag", "onEvent: Document do not exists");
                }
        });



        updateprofile.setOnClickListener(view12 -> {
            String user_email = useremail.getText().toString().trim();
            String user_name = usernames.getText().toString().trim();
            String user_height = userheight.getText().toString();
            String user_weight = userweight.getText().toString();
            String user_age = userage.getText().toString();
            String user_gender = "";

            if(usermale.isChecked()){

                user_gender = "Male";


            }if(userfemale.isChecked())
            {
                user_gender = "Female";
            }

            String finalGender = user_gender;


            user.updateEmail(user_email).addOnSuccessListener(aVoid -> {


                documentReference = mFirestore.collection("Users").document(Userid);
                Map<String, Object> data = new HashMap<>();
                data.put("Email" , user_email);
                data.put("Name" , usernames.getText().toString().trim());
                data.put("Height" , userheight.getText().toString());
                data.put("Weight" , userweight.getText().toString());
                data.put("Age", userage.getText().toString());
                data.put("Gender", finalGender);


              documentReference.update(data).addOnSuccessListener(aVoid1 -> Snackbar.make(constraintLayout, "Profile Updated",BaseTransientBottomBar.LENGTH_SHORT).show());
                useremail.setText(user_email);
                username.setText(user_name);
                userheight.setText(user_height);
                userweight.setText(user_weight);
                userage.setText(user_age);



            }).addOnFailureListener(e -> Toast.makeText(getActivity(),e.getMessage(), Toast.LENGTH_SHORT).show());



        });




        updatepassowrd.setOnClickListener(view1 -> startActivity(new Intent(getActivity(), EditPassword.class)));



        progressBar.setVisibility(View.GONE);
        return view;

                                             }


}













