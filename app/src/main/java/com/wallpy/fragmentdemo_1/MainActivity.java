package com.wallpy.fragmentdemo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wallpy.fragmentdemo_1.Loading.LodingAnimation;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //actionbar hide
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        //statusbar hide
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        Timer tm=new Timer();
//
//        tm.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                startActivity(new Intent(MainActivity.this, home.class));
//                finish();
//            }
//        },2000);

        progressBar=findViewById(R.id.prolod);
        textView=findViewById(R.id.numper);

        progressBar.getProgressDrawable().setColorFilter(Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();

    }

    public void progressAnimation() {
        LodingAnimation animation=new LodingAnimation(this,progressBar,textView,0f,100f);
        animation.setDuration(8000);
        progressBar.setAnimation(animation);


    }
}