package com.example.fitnessapp.Functions.WorkoutCategories.AbsDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fitnessapp.Functions.WorkoutCategories.WorkOut;
import com.example.fitnessapp.R;

public class Absworkout extends AppCompatActivity{


    Toolbar toolbar;
  ListView listView;

        String abslist [] = {"Pre-Workout","Jumping-Jacks" ,"Plank","Bicycle-Kicks","Mountain-Climbers","SIDE-PLANK(LEFT)","SIDE-PLANK(Right)"
        };

        int images [] = {R.drawable.preworkout,R.drawable.abs_jumping,R.drawable.abs_plank,R.drawable.abs_bicycle,R.drawable.abc_mc,
        R.drawable.abs_sideplankleft,R.drawable.abs_sideplankleft
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absworkout);
        toolbar = findViewById(R.id.abs_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Abs Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), WorkOut.class)));



        listView = findViewById(R.id.abs);
        CustomListView customListView = new CustomListView(this,abslist,images);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 0){
                Intent intent = new Intent(view.getContext(), Preworkout.class);
                startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(view.getContext(), Jumpingjack.class);
                startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(view.getContext(), Plank.class);
                startActivity(intent);
            }
            if(position == 3){
                Intent intent = new Intent(view.getContext(), BicycleKicks.class);
                startActivity(intent);
            }
            if(position == 4){
                Intent intent = new Intent(view.getContext(), MountainClimbers.class);
                startActivity(intent);
            }
            if(position == 5){
                Intent intent = new Intent(view.getContext(), sideplankleft.class);
                startActivity(intent);
            }
            if(position == 6){
                Intent intent = new Intent(view.getContext(), sideplankright.class);
                startActivity(intent);
            }

        });
    }


}


