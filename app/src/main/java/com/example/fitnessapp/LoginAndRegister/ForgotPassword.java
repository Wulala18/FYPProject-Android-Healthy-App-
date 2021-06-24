package com.example.fitnessapp.LoginAndRegister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button UserPass;
    LinearLayout linearLayout;
    FirebaseAuth fauth;
    EditText edit_email;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        fauth = FirebaseAuth.getInstance();
        linearLayout = findViewById(R.id.forgot_snackbar);
       UserPass = findViewById(R.id.reset_btn);
        edit_email = findViewById(R.id.pss_reset);


        UserPass.setOnClickListener(v -> fauth.sendPasswordResetEmail(edit_email.getText().toString().trim()).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
               Toast.makeText(this, "The reset passwords link has sent to your email", Toast.LENGTH_SHORT).show();

            } else {
                Snackbar.make(getCurrentFocus(),task.getException().getMessage(), BaseTransientBottomBar.LENGTH_SHORT).show();
            }
        }));
        }

            public void btn_forback(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }


}


