package com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DIY_Show_Recipe extends AppCompatActivity {


    private static final String TAG = "Activity";

    RecyclerView recyclerView;
    FirebaseFirestore firebaseFirestore;
    FirebaseAuth fAuth;
    DIYAdapter diyAdapter;
    FloatingActionButton floatingActionButton;
    SwipeRefreshLayout swipeRefreshLayout;
    List<DIYrecipe> list = new ArrayList<>();
    Toolbar toolbar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_i_y_recipe_);



        fAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        recyclerView = findViewById(R.id.recipe_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        swipeRefreshLayout = findViewById(R.id.swipelayout);
        floatingActionButton = findViewById(R.id.add_recipe);
        floatingActionButton.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), DIY_Create_Recipe.class)));

        toolbar = findViewById(R.id.recipe_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("D.I.Y Recipes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity( new Intent(getApplicationContext(), Nutrition.class)));


        getRecipeData();



      swipeRefreshLayout.setOnRefreshListener(() -> {

          list.clear();
            Toast.makeText(getApplicationContext(), "Please wait for a moment", Toast.LENGTH_LONG).show();

            // To keep animation for 4 seconds
            new Handler().postDelayed(() -> {

                getRecipeData();
                // Stop animation (This will be after 3 seconds)
                swipeRefreshLayout.setRefreshing(false);
            }, 4000); // Delay in millis
        });

        swipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(android.R.color.holo_blue_bright),
                getResources().getColor(android.R.color.holo_green_light),
                getResources().getColor(android.R.color.holo_orange_light),
                getResources().getColor(android.R.color.holo_red_light)
        );




    }




    private void getRecipeData() {

       String Userid = fAuth.getCurrentUser().getUid();



       firebaseFirestore.collection("Users")
                .document(Userid)
                .collection("FoodRecipes")
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .get()
                .addOnCompleteListener(task -> {



                    for (DocumentSnapshot snapshot : task.getResult()) {
                        String tempID = snapshot.getId();
                        DIYrecipe diYrecipe = new DIYrecipe(tempID,
                                snapshot.getString("User_ID"),
                                snapshot.getString("idd"),
                                snapshot.getString("titlerecipe"),
                                snapshot.getString("ingredientsrecipe"),
                                snapshot.getString("instructionrecipe"),
                                snapshot.getString("timestamp"));

                        list.add(diYrecipe);

                    }




                    diyAdapter = new DIYAdapter(this, list);
                    recyclerView.setAdapter(diyAdapter);

                }).addOnFailureListener(e -> Toast.makeText(DIY_Show_Recipe.this, "Something Went Wrong:(", Toast.LENGTH_SHORT).show());

        //Query query = recipeRef.orderBy("timestamp", Query.Direction.DESCENDING);

       /* FirestoreRecyclerOptions<DIYrecipe> options = new FirestoreRecyclerOptions.Builder<DIYrecipe>()
                .setQuery(query, DIYrecipe.class)
                .build();

        diyRecipeAdapter = new DIYRecipeAdapter(options);
        recyclerView = findViewById(R.id.recipe_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(diyRecipeAdapter);

*/

      /*  new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                final int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.LEFT)
                {
                 diyAdapter.updateFoodData(position);
                 diyAdapter.notifyDataSetChanged();
                }

                else
                {
                    diyRecipeAdapter.deleteItem(position);
                }


                diyRecipeAdapter.deleteItem(viewHolder.getAdapterPosition());
            }

        }).attachToRecyclerView(recyclerView);*/


    }

    public void deleteRecipeData(int index)
    {

        String Userid = fAuth.getCurrentUser().getUid();



        firebaseFirestore.collection("Users")
                         .document(Userid)
                         .collection("FoodRecipes")
                         .document((list.get(index).getDid()))
                         .delete()
                         .addOnCompleteListener(task -> {



                    Toast.makeText(DIY_Show_Recipe.this, "Deleting...", Toast.LENGTH_SHORT).show();


                }).addOnFailureListener(e -> Toast.makeText(DIY_Show_Recipe.this, "Try again...", Toast.LENGTH_SHORT).show());

    }










}
