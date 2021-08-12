package com.wallpy.fragmentdemo_1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallpy.fragmentdemo_1.ExDatabase.DatabaseHelper;
import com.wallpy.fragmentdemo_1.R;

public class categoryFragment extends Fragment {
    DatabaseHelper dbh;
    Context mContext;

    public categoryFragment() {
        // Required empty public constructor


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_category, container, false);

        dbh=new DatabaseHelper(mContext,"EngFont.db",null,1);

        try{
            dbh.checkdb();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            dbh.OpenDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }






    return view;
    }
}