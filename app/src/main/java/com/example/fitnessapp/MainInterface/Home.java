package com.example.fitnessapp.MainInterface;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fitnessapp.Fragments.BmiActivity;
import com.example.fitnessapp.Fragments.HomeFrag;
import com.example.fitnessapp.Fragments.ProfileFrag;
import com.example.fitnessapp.Fragments.CaloriesFrag;
import com.example.fitnessapp.Fragments.contactUsFrag;
import com.example.fitnessapp.LoginAndRegister.Login;
import com.example.fitnessapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    FirebaseAuth firebaseAuth;
    FirebaseUser currentUser;
    Toolbar toolbar;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        toolbar = findViewById(R.id.toolbar);
        toolbar.hideOverflowMenu();
        navigationView = findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getInstance().getCurrentUser();
        fragmentManager = getSupportFragmentManager();

        fragmentTransaction = fragmentManager.beginTransaction();

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        updateNavHeader();






        //default homepage
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFrag()).commit();




    }

    //Show user
    private void updateNavHeader() {

        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView nav_name = headerView.findViewById(R.id.nav_user_name);


        nav_name.setText(currentUser.getEmail());
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.home2, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
       switch (item.getItemId())
       {

           case R.id.nav_home:

            getSupportActionBar().setTitle("Home");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFrag()).commit();
            break;

           case R.id.nav_profile:

            getSupportActionBar().setTitle("Profile");
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ProfileFrag()).commit();
            break;



           case R.id.nav_Calories:
               getSupportActionBar().setTitle("Calories Tracker");
               Intent intent = new Intent(this, BmiActivity.class);
               startActivity(intent);
               //getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProgressFrag()).commit();
               break;


           case R.id.nav_helpcenter:

            getSupportActionBar().setTitle("Help Center");
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new contactUsFrag()).commit();
            break;

           case R.id.nav_logout:
            firebaseAuth.signOut();
            Intent loginActivity = new Intent(getApplicationContext(), Login.class);
            startActivity(loginActivity);
            finish();


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }










}




