package com.example.fitnessapp.Functions.WorkoutCategories.ChestDetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.fitnessapp.Functions.WorkoutCategories.ArmDetails.CustomListView;
import com.example.fitnessapp.Functions.WorkoutCategories.WorkOut;
import com.example.fitnessapp.R;

public class ChestWorkout extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;

    String armlist [] = {"Pre-Workout","Wide Press-up" ,"Alternating Shuffle Press-up","Diamond Press-up","Incline-Pushup","Decline-Pushup"
    };
    int images [] = {R.drawable.preworkout,R.drawable.widepushup,R.drawable.shufflepushup,R.drawable.diamondpushup,R.drawable.onearmpushup, R.drawable.inclinepushup,R.drawable.declinepushup

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_workout);
        toolbar = findViewById(R.id.chest_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chest Workout");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), WorkOut.class)));


        listView = findViewById(R.id.chest);
        CustomListView customListView = new CustomListView(this, armlist, images);
        listView.setAdapter(customListView);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            if (position == 0) {
                Intent intent = new Intent(view.getContext(), Preworkout_chest.class);
                startActivity(intent);
            }
            if (position == 1) {
                Intent intent = new Intent(view.getContext(), widepushup.class);
                startActivity(intent);
            }
            if (position == 2) {
                Intent intent = new Intent(view.getContext(), aspi.class);
                startActivity(intent);
            }
            if (position == 3) {
                Intent intent = new Intent(view.getContext(), dpi.class);
                startActivity(intent);
            }

            if (position == 4) {
                Intent intent = new Intent(view.getContext(), inclinepushup.class);
                startActivity(intent);
            }
            if (position == 5) {
                Intent intent = new Intent(view.getContext(), declinepushup.class);
                startActivity(intent);
            }


        });
    }

}