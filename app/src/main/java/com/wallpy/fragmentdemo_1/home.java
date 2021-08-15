package com.wallpy.fragmentdemo_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wallpy.fragmentdemo_1.ExDatabase.DatabaseHelper;
import com.wallpy.fragmentdemo_1.ListTools.ListData;
import com.wallpy.fragmentdemo_1.fragment.categoryFragment;
import com.wallpy.fragmentdemo_1.fragment.favFragment;
import com.wallpy.fragmentdemo_1.fragment.settingFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class home extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    FrameLayout frameLayout;
    ArrayList<ListData> listDataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();

        }

        mBottomNavigationView = findViewById(R.id.bottomnb1);
        frameLayout = findViewById(R.id.frame1);

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame1, new categoryFragment());
        beginTransaction.commit();

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()) {

                    case R.id.categoryid:
                        transaction1.replace(R.id.frame1, new categoryFragment());
                        break;
                    case R.id.favid:
                        transaction1.replace(R.id.frame1, new favFragment());
                        break;
                    case R.id.settingid:
                        transaction1.replace(R.id.frame1, new settingFragment());
                        break;
                }
                transaction1.commit();
                return true;
            }
        });

        }

}