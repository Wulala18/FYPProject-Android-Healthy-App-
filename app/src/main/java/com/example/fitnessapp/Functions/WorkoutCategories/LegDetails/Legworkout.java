package com.example.fitnessapp.Functions.WorkoutCategories.LegDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fitnessapp.Functions.WorkoutCategories.ArmDetails.CustomListView;
import com.example.fitnessapp.Functions.WorkoutCategories.WorkOut;
import com.example.fitnessapp.R;

public class Legworkout extends AppCompatActivity {


    Toolbar toolbar;
    ListView listView;

    String leglist [] = {"Pre-Workout","Squat" ,"Squat Jump","Side Lunge","Pistol Squat","Lunge"
    };
    int images [] = {R.drawable.preworkout,R.drawable.squat,R.drawable.squatjump,R.drawable.sidelunge,R.drawable.pistolsquat, R.drawable.lunge,R.drawable.calf,R.drawable.donkeykick

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legworkout);
        toolbar = findViewById(R.id.leg_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Leg Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), WorkOut.class)));

        listView = findViewById(R.id.leg);
        CustomListView customListView = new CustomListView(this, leglist, images);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener((parent, view, position, id) -> {
                if(position == 0)
                {
                    Intent intent = new Intent(view.getContext(), Preworkout_leg.class);
                    startActivity(intent);
                }
                if(position == 1)
                {
                    Intent intent = new Intent(view.getContext(),squat.class);
                    startActivity(intent);
                }
             if(position == 2)
            {
                Intent intent = new Intent(view.getContext(),squatjump.class);
                startActivity(intent);
            }
             if(position == 3)
             {
                 Intent intent = new Intent(view.getContext(),sidelunge.class);
                 startActivity(intent);

             }
            if(position == 4)
            {
                Intent intent = new Intent(view.getContext(),pistolsquat.class);
                startActivity(intent);

            }
            if(position == 5)
            {
                Intent intent = new Intent(view.getContext(),lunge.class);
                startActivity(intent);

            }



    });
    }


}