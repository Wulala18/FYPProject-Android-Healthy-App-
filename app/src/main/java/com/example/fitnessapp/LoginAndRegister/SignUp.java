package com.example.fitnessapp.LoginAndRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SignUp extends AppCompatActivity{


    TextInputEditText fname,femail,fpassword, fheight, fweight, fage;
    RadioButton malee, femalee;
    ConstraintLayout layout;
    Button fregister;
    TextView ftv;
    FirebaseAuth fauth;
    DocumentReference documentReference;
    FirebaseFirestore fstore;
    String UserID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        layout = findViewById(R.id.snackbar_bottom);
        fname = findViewById(R.id.txtname);
        femail = findViewById(R.id.txtEmail);
        fpassword = findViewById(R.id.txtPwd);
        fregister = findViewById(R.id.btnlogin);
        fheight = findViewById(R.id.txtHeight);
        fweight = findViewById(R.id.txtweight);
        ftv = findViewById(R.id.backtologin);
        fage = findViewById(R.id.txtage);
        malee = findViewById(R.id.Male);
        femalee = findViewById(R.id.female);
        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();





        fregister.setOnClickListener(v -> {

            String txt_email = femail.getText().toString().trim();
            String txt_password = fpassword.getText().toString().trim();
            String username = fname.getText().toString().trim();
            String uheight = fheight.getText().toString();
            String uweight = fweight.getText().toString();
            String uage = fage.getText().toString();
            String gender = "";

            if(malee.isChecked()){

                gender = "Male";


            }if(femalee.isChecked())
            {
                gender = "Female";
            }

            if (TextUtils.isEmpty(username)) {
                fname.setError("Name is Required.");
                fname.requestFocus();
                return;
            }

            if (TextUtils.isEmpty(txt_email)) {
                femail.setError("Email is Required.");
                fname.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(txt_password)) {
                fpassword.setError("Password is Required.");
                fname.requestFocus();
                return;
            }
            if (txt_password.length() < 6) {
                fpassword.setError("Password must be at least 6 characters/numbers");
                return;
            }
            if (TextUtils.isEmpty(uage)) {
                femail.setError("Age is Required.");
                fname.requestFocus();
                return;
            }

            if (TextUtils.isEmpty(uheight)) {
                fpassword.setError("Height is Required.");
                fname.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(uweight)) {
                fpassword.setError("Weight is Required.");
                fname.requestFocus();
                return;
            }

            //Register user in firebase

            String finalGender = gender;
            fauth.createUserWithEmailAndPassword(txt_email, txt_password)
                    .addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    fauth.getCurrentUser().sendEmailVerification()
                            .addOnCompleteListener(task1 -> {
                                if (task1.isSuccessful()) {

                              
                                    Snackbar.make(layout, "User Created Successful, Please Check Your Email For Verification", BaseTransientBottomBar.LENGTH_SHORT).show();

                                    UserID = fauth.getCurrentUser().getUid();
                                    documentReference = fstore.collection("Users").document(UserID);
                                    Map<String, String> user = new HashMap<>();
                                    user.put("Email", txt_email);
                                    user.put("Name", username);
                                   // user.put("Password", txt_password);
                                    user.put("Height", uheight);
                                    user.put("Weight", uweight);
                                    user.put("Age", uage);
                                    user.put("Gender", finalGender);


                                   documentReference.set(user).addOnCompleteListener(task2 -> {
                                           if(task2.isSuccessful())
                                           {
                                               startActivity(new Intent(getApplicationContext(), Login.class));


                                           }
                                   });

                                } else
                                {
                                    Snackbar.make(layout, "Opps...Something went wrong", BaseTransientBottomBar.LENGTH_SHORT ).show();

                                }
                            });
                }
                else
                    {
                        Snackbar.make(layout, "The email has been registered, Please try a new one", BaseTransientBottomBar.LENGTH_SHORT ).show();

                }
            });
        });


        ftv.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Login.class)));


}




}
