package com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DIY_Create_Recipe extends AppCompatActivity {

    private static final String TAG = "Recipe Created";


    Toolbar toolbar;
    String RecipeTitle, RecipeIngredients, RecipeInstructions, RecipeIDD;
    String tempID;
    EditText editname;
    TextInputEditText editingredient, editinstruction;
    Button sveBtn;
    FirebaseAuth Fauth;
    FirebaseFirestore firebaseFirestore;
    FirebaseUser User;
    ProgressDialog pd;
    Calendar cal = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_i_y__edit__recipe);

        editname = findViewById(R.id.edit_recipename);
        editingredient = findViewById(R.id.edit_ingredients);
        editinstruction = findViewById(R.id.edit_instruction);
        sveBtn = findViewById(R.id.svrecipe_Btn);
        pd = new ProgressDialog(this);
        toolbar = findViewById(R.id.editrecipe_toolbar);

        firebaseFirestore = FirebaseFirestore.getInstance();
        Fauth = FirebaseAuth.getInstance();
        User = Fauth.getCurrentUser();


        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("DIY Recipe");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DIY_Show_Recipe.class)));



        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            sveBtn.setText("Update");
            tempID = bundle.getString("tempID");
            RecipeIDD = bundle.getString("RecipeID");
            RecipeTitle = bundle.getString("RecipeTitle");
            RecipeIngredients = bundle.getString("RecipeIngredients");
            RecipeInstructions = bundle.getString("RecipeInstructions");
            editname.setText(RecipeTitle);
            editingredient.setText(RecipeIngredients);
            editinstruction.setText(RecipeInstructions);

        } else {
            sveBtn.setText("Save");
        }


        sveBtn.setOnClickListener(view -> {



            Bundle bundle1 = getIntent().getExtras();
            if (bundle1 != null) {
                String UserID = Fauth.getUid();
                String TitleRecipe = editname.getText().toString().trim();
                String IngredientsRecipe = editingredient.getText().toString().trim();
                String InstructionRecipe = editinstruction.getText().toString().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss.SS");
                String TimeStamp = sdf.format(cal.getTimeInMillis());


                updateRecipe(UserID, "id", TitleRecipe, IngredientsRecipe, InstructionRecipe, TimeStamp);

            } else {
                String UserID = Fauth.getUid();
                String id = UUID.randomUUID().toString();
                String TitleRecipe = editname.getText().toString().trim();
                String IngredientsRecipe = editingredient.getText().toString().trim();
                String InstructionRecipe = editinstruction.getText().toString().trim();
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy.HH:mm:ss.SS");
                String TimeStamp = sdf.format(cal.getTimeInMillis());


                saveRecipe(UserID, id, TitleRecipe, IngredientsRecipe, InstructionRecipe, TimeStamp);
            }




        });
    }


    private void updateRecipe(String userID, String id, String titleRecipe, String ingredientsRecipe, String instructionRecipe, String timeStamp) {

        DocumentReference doc = firebaseFirestore.collection("Users")
                        .document(userID)
                        .collection("FoodRecipes")
                        .document(tempID);

        DIYrecipe tempModel = new DIYrecipe(id, userID, titleRecipe, ingredientsRecipe, instructionRecipe, timeStamp);
        doc.delete();
        doc.set(tempModel).addOnCompleteListener(task -> Toast.makeText(DIY_Create_Recipe.this, "Recipe Updated", Toast.LENGTH_SHORT).show()).addOnFailureListener(e -> Toast.makeText(DIY_Create_Recipe.this, e.getMessage(), Toast.LENGTH_SHORT));
        finish();

    }

    private void saveRecipe(String userID, String id, String titleRecipe, String ingredientsRecipe, String instructionRecipe, String timeStamp) {





        firebaseFirestore.collection("Users")
                .document(userID)
                .collection("FoodRecipes")
                .add(new DIYrecipe(id, userID, titleRecipe, ingredientsRecipe, instructionRecipe, timeStamp));


        Toast.makeText(DIY_Create_Recipe.this, "Recipe Added Successful", Toast.LENGTH_SHORT).show();
        finish();

    }


}
