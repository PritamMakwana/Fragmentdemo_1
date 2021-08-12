package com.wallpy.fragmentdemo_1.ExDatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    Context mContext;
    String dbname;
    String dbpath;


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.dbname=name;
        this.mContext=context;
        this.dbpath="/data/data"+"com.wallpy.fragmentdemo_1.ExDatabase"+"/databases/";

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void checkdb(){

        SQLiteDatabase checkDb=null;

        String filePath=dbpath+dbname;

        try{
            checkDb=SQLiteDatabase.openDatabase(filePath,null,0);

        }catch (Exception e){
            e.printStackTrace();
        }


        if(checkDb!=null){
            Toast.makeText(mContext,"Database alredy exits",Toast.LENGTH_SHORT).show();
        }
        else{
            CopyDatabase();
        }


    }

    private void CopyDatabase() {
        this.getReadableDatabase();


        try{
            InputStream ios= mContext.getAssets().open(dbname);
            OutputStream os= new FileOutputStream(dbpath+dbname);

            byte[] buffer=new byte[1024];

            int len;

            while ((len=ios.read(buffer))>0){
                os.write(buffer,0,len);
            }

            os.flush();
            ios.close();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("copydb","Database copid");
    }

    public void OpenDatabase(){

        String filepath=dbpath+dbname;

        SQLiteDatabase.openDatabase(filepath,null,0);

    }
}
