
package com.example.fitnessapp.Functions.FoodRecipe.foodrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;

public class FoodrecipeActivity extends AppCompatActivity {


    TextView tvrecipename, tvrecpingre, tvinstruc;
    Toolbar toolbar;
    ImageView imageView;
    Glide glide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h11);


        String recipetitle = getIntent().getExtras().getString("title");
        String ingredients = getIntent().getExtras().getString("ingredients");
        String instruction = getIntent().getExtras().getString("instructions");
        String imagess = getIntent().getExtras().getString("images");


        toolbar = findViewById(R.id.h11_toolbar);
        tvrecipename = findViewById(R.id.tv_recipename);
        tvrecpingre = findViewById(R.id.tv_ingredients);
        tvinstruc = findViewById(R.id.tv_instruction);
        imageView = findViewById(R.id.tv_image);


        //Set Each Values
        tvrecipename.setText(recipetitle);
        tvrecpingre.setText(ingredients);
        tvinstruc.setText(instruction);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), FoodreicpeFunction.class)));


        //Set Image
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        glide.with(this).load(imagess).apply(requestOptions).into(imageView);




    }






}

