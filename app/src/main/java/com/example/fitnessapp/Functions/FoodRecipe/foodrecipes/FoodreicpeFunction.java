
package com.example.fitnessapp.Functions.FoodRecipe.foodrecipes;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FoodreicpeFunction extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/Wulala18/holderjson/master/foodrecipe.json";
    JsonArrayRequest request;
    List<Foodrecipes> foodrecipes;
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodrecipess);



        foodrecipes = new ArrayList<>();
        toolbar = findViewById(R.id.recipes_toolbar);
        recyclerView = findViewById(R.id.recyclerviewclass);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Healthy Food Recipes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Nutrition.class)));
        jsonrequest();

    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, response -> {

            JSONObject jsonObject = null;

            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = response.getJSONObject(i);
                    Foodrecipes frs = new Foodrecipes();
                    frs.setId(jsonObject.getInt("id"));
                    frs.setName(jsonObject.getString("title"));
                    frs.setCalories(jsonObject.getString("calories"));
                    frs.setFat(jsonObject.getString("fat"));
                    frs.setProtein(jsonObject.getString("protein"));
                    frs.setSugar(jsonObject.getString("sugar"));
                    frs.setIngredients(jsonObject.getString("ingredients"));
                    frs.setInstructions(jsonObject.getString("instructions"));
                    frs.setImgg(jsonObject.getString("images"));


                    foodrecipes.add(frs);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setupreciperecyclerview(foodrecipes);

            }
        }, error -> Log.e("Volley", error.toString()));

        requestQueue = Volley.newRequestQueue(FoodreicpeFunction.this);
        requestQueue.add(request);

    }

    private void setupreciperecyclerview(List<Foodrecipes> fr) {


        RecyclerViewAdapterRecipe myadapter = new RecyclerViewAdapterRecipe(this, fr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }


}