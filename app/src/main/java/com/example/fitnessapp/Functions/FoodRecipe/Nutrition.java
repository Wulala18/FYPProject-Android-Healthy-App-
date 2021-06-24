package com.example.fitnessapp.Functions.FoodRecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe.DIY_Show_Recipe;
import com.example.fitnessapp.Functions.FoodRecipe.FoodNutrtionSearch.healthyfood;
import com.example.fitnessapp.Functions.FoodRecipe.foodrecipes.FoodreicpeFunction;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;

public class Nutrition extends AppCompatActivity {


    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);

        toolbar = findViewById(R.id.nutrition_toolbar);

       setSupportActionBar(toolbar);
       getSupportActionBar().setTitle("Food Nutrition");
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
       getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(),Home.class)));

    }

    public void btn_healthyfood(View view) {
        startActivity(new Intent(getApplicationContext(), healthyfood.class));
    }

    public void btn_healthydrink(View view) {
        startActivity(new Intent(getApplicationContext(), FoodreicpeFunction.class));
    }

    public void btn_diyrecipe(View view) {
        startActivity(new Intent(getApplicationContext(), DIY_Show_Recipe.class));
    }
}