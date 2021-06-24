package com.example.fitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BmiActivity extends AppCompatActivity {


    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tableLayout;

    BMIFrag bmiFrag;
    CaloriesFrag progressFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bml);
        toolbar = findViewById(R.id.bml_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("BMR/BMI/Calorie Calculator");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Home.class)));


        viewPager = findViewById(R.id.view_pager);
        tableLayout = findViewById(R.id.tab_layour);

        bmiFrag = new BMIFrag();
        progressFrag = new CaloriesFrag();

        tableLayout.setupWithViewPager(viewPager);

        //Switch Fragments In Between
        ViewPagerAdapter pagerAdap = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        pagerAdap.addFragment(progressFrag, "Calories Counter");
        pagerAdap.addFragment(bmiFrag, "BMI Result");
        viewPager.setAdapter(pagerAdap);


            //Design add icon and set title
        tableLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_fact_check_24);
        tableLayout.getTabAt(0).setText("Calories Counter");
        tableLayout.getTabAt(1).setIcon(R.drawable.bml);
        tableLayout.getTabAt(1).setText("BMI Result");










    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        List<Fragment> fragments = new ArrayList<>();
        List<String> fragmentTitle = new ArrayList<>();


        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }


        public void addFragment(Fragment fragment, String title)
        {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }



        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }
    }
}