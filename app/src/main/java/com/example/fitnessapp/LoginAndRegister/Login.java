package com.example.fitnessapp.LoginAndRegister;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private static final String message = "Welcome Back";

    EditText lusername, lpassword;
    Button flogin;
    TextView fregister, forgotpsss;
    FirebaseAuth fauth;
    LinearLayout layout;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        layout = findViewById(R.id.snack_login);
        lusername = findViewById(R.id.enter_id);
        lpassword = findViewById(R.id.enter_pass);
        flogin = findViewById(R.id.login_btn);
        forgotpsss = findViewById(R.id.forgotPassword);
        fregister = findViewById(R.id.signup);
        pd = new ProgressDialog(this);



        fauth = FirebaseAuth.getInstance();


        flogin.setOnClickListener(v -> {
            String ursid = lusername.getText().toString().trim();
            String password = lpassword.getText().toString().trim();

            if (TextUtils.isEmpty(ursid)) {
                lusername.setError("Email is Required!!!");
                lusername.requestFocus();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                lpassword.setError("Password is Required!!!");
                lpassword.requestFocus();
                return;
            }
            if (password.length() < 6) {
                lpassword.setError("Password length must be 6");
                return;
            }

            pd.setTitle("Logging in...");

            pd.show();


            //User authentication

            fauth.signInWithEmailAndPassword(ursid, password)
                    .addOnCompleteListener(task ->
                    {
                        if (task.isSuccessful())
                    {
                    if (fauth.getCurrentUser().isEmailVerified())
                    {



                        Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this, Home.class));
                    }
                    else
                        {
                      Snackbar.make(layout, "Did You Verify Your Email?", BaseTransientBottomBar.LENGTH_SHORT).show();

                    }

                }

                            else
                                {
                                    Snackbar.make(getCurrentFocus(),task.getException().getMessage(), BaseTransientBottomBar.LENGTH_SHORT).show();

                        pd.dismiss();
                }
            });
        });


        forgotpsss.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ForgotPassword.class)));






    }

    public void signup_btn(View view) {
        startActivity(new Intent(getApplicationContext(),SignUp.class));
    }


}