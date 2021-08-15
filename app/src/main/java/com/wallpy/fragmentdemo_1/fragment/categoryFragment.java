package com.wallpy.fragmentdemo_1.fragment;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wallpy.fragmentdemo_1.ExDatabase.DatabaseHelper;
import com.wallpy.fragmentdemo_1.ListTools.MYAdapter;
import com.wallpy.fragmentdemo_1.ListTools.ListData;
import com.wallpy.fragmentdemo_1.R;

import java.util.ArrayList;

public class categoryFragment extends Fragment {
    DatabaseHelper dbh;
    Context mContext;

    static String DB_NAME1="EngFont.db";

    private RecyclerView recyclerView;
    private ArrayList<ListData> listData;
    private MYAdapter MYAdapter;
    private Cursor cursor;


    public categoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=  inflater.inflate(R.layout.fragment_category, container, false);

        dbh=new DatabaseHelper(mContext,"EngFont1.db",null,1);

        try{
            dbh.CheckDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            dbh.OpenDatabase();
        }catch (Exception e){
            e.printStackTrace();
        }

        final String[] from=new String[]{
                DatabaseHelper.ID,DatabaseHelper.NAME,DatabaseHelper.DESC
        };

        final int[] to=new int[]{
            R.id.name_list,R.id.desc_list
        };

      //  dbh.OpenDatabase();
//        cursor=dbh.fetch1();

        recyclerView=view.findViewById(R.id.rv_1);
        listData=new ArrayList<>();
        listData.add(new ListData("name ","BCA bechalor computer apppliction"));
        MYAdapter=new MYAdapter(listData,mContext,cursor,from,to,0);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(MYAdapter);

        return view;
    }
}