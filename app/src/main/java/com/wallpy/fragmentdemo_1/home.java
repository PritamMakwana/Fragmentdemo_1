package com.wallpy.fragmentdemo_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.wallpy.fragmentdemo_1.ExDatabase.DatabaseHelper;
import com.wallpy.fragmentdemo_1.fragment.categoryFragment;
import com.wallpy.fragmentdemo_1.fragment.favFragment;
import com.wallpy.fragmentdemo_1.fragment.settingFragment;

public class home extends AppCompatActivity {

    BottomNavigationView mBottomNavigationView;
    FrameLayout frameLayout;
    DatabaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();

        }

//        dbh=new DatabaseHelper(this,"EngFont.db",null,1);
//
//        try{
//            dbh.checkdb();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//        try{
//            dbh.OpenDatabase();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        mBottomNavigationView=findViewById(R.id.bottomnb1);
        frameLayout =findViewById(R.id.frame1);

        FragmentTransaction beginTransaction= getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.frame1,new categoryFragment());
        beginTransaction.commit();


            mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {

                @Override
                public void onNavigationItemReselected(@NonNull MenuItem item) {
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
                }

            });

        }

}