package com.example.fitnessapp.Functions.WorkoutCategories.ArmDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.fitnessapp.Functions.WorkoutCategories.WorkOut;
import com.example.fitnessapp.R;

public class ArmWorkout extends AppCompatActivity{

    ListView listView;
    Toolbar toolbar;

    String armlist [] = {"Pre-Workout","Arm Circles" ,"Arm Shoulder Stretch","Plank","Superman","Push-up","Tricep Dips"
    };
    int images [] = {R.drawable.preworkout,R.drawable.armcircle,R.drawable.stretch,R.drawable.plank,R.drawable.superman,
            R.drawable.pushup,R.drawable.tricepdips
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_workout);
        toolbar = findViewById(R.id.arm_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(),WorkOut.class)));


        listView = findViewById(R.id.arm);
        CustomListView customListView = new CustomListView(this,armlist,images);
        listView.setAdapter(customListView);


        listView.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 0){
                Intent intent = new Intent(view.getContext(), Preworkout_arm.class);
                startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(view.getContext(), ArmCircle.class);
                startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(view.getContext(), armstretch.class);
                startActivity(intent);
            }
            if(position == 3){
                Intent intent = new Intent(view.getContext(), plank.class);
                startActivity(intent);
            }

            if(position == 4){
                Intent intent = new Intent(view.getContext(), superman.class);
                startActivity(intent);
            }
            if(position == 5){
                Intent intent = new Intent(view.getContext(), pushup.class);
                startActivity(intent);
            }
            if(position == 6)
            {
                Intent intent = new Intent(view.getContext(), tricepdips.class);
                startActivity(intent);
            }




        });
    }




}