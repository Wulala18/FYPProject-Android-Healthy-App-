package com.example.fitnessapp.Functions.WorkoutCategories;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fitnessapp.Functions.WorkoutCategories.AbsDetails.Absworkout;
import com.example.fitnessapp.Functions.WorkoutCategories.ArmDetails.ArmWorkout;
import com.example.fitnessapp.Functions.WorkoutCategories.ChestDetails.ChestWorkout;
import com.example.fitnessapp.Functions.WorkoutCategories.LegDetails.Legworkout;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class WorkOut extends AppCompatActivity {

    Toolbar toolbar;
    ImageButton btnchest, btnarm, btnabs, btnlegs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_out);



        btnabs = findViewById(R.id.absworkout);
        btnarm = findViewById(R.id.armworkout);
        btnchest = findViewById(R.id.chestworkout);
        btnlegs = findViewById(R.id.legworkout);
        toolbar = findViewById(R.id.workout_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WorkOut Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Home.class)));




    }



    public void btn_chest(View view) {
        startActivity(new Intent(getApplicationContext(), ChestWorkout.class));
    }

    public void btn_arm(View view) {

        startActivity(new Intent(getApplicationContext(), ArmWorkout.class));

    }

    public void btn_abs(View view) {

        startActivity(new Intent(getApplicationContext(), Absworkout.class));

    }

    public void btn_leg(View view) {

        startActivity(new Intent(getApplicationContext(), Legworkout.class));

    }


}

