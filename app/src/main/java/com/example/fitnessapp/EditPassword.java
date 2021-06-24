package com.example.fitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitnessapp.Fragments.ProfileFrag;
import com.example.fitnessapp.MainInterface.Home;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class EditPassword extends AppCompatActivity {

    public static final String TAG = "TAG";
    ConstraintLayout constraintLayout;
    TextInputEditText newPassword;
    Button saveBtn, backbtn;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseUser user;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        constraintLayout = findViewById(R.id.con_resetpss);
        newPassword = findViewById(R.id.new_password);
        saveBtn = findViewById(R.id.savenewpassword);
        backbtn = findViewById(R.id.backtoprofile);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = fAuth.getCurrentUser();



        saveBtn.setOnClickListener(view -> {
            String new_password = newPassword.getText().toString().trim();

            user.updatePassword(new_password).addOnCompleteListener(task -> {

                if (task.isSuccessful()) {

                    Snackbar.make(constraintLayout, "Password has been Updated" , BaseTransientBottomBar.LENGTH_SHORT).show();

                } else {
                    Log.d(TAG, "Password Update Failed");
                }


            });
        });




        backbtn.setOnClickListener(v -> EditPassword.super.onBackPressed());


    }
}


