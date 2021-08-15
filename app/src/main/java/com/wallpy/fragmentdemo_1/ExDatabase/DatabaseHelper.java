package com.wallpy.fragmentdemo_1.ExDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
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

    Context context;
    String dbname;
    private static String dbpath= " ";

 //   static String DB_NAME="EngFont1.db";
    //public static final String TABLE_NAME=" Life ";
//        Table Colum
    public static final String ID="_id";
    public static final String NAME="NAME";
    public static  final  String DESC="DECRIPTION";

    SQLiteDatabase database;
    DatabaseHelper databaseHelper;

    public DatabaseHelper(@Nullable Context mcontext, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(mcontext, name, factory, version);
        this.context=mcontext;
        dbname="EngFont1.db";
        dbpath = "/data/data/" +"com.wallpy.fragmentdemo_1.ExDatabase" + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CheckDatabase() {

        this.getReadableDatabase();

        try{
            String path=dbpath+dbname;

            SQLiteDatabase.openDatabase(path,null,0);

        }catch (Exception e){ }

        CopyDatabase();

    }


    public void CopyDatabase(){
        try{
            InputStream io=context.getAssets().open(dbname);
            String oufilename= dbpath + dbname;
            OutputStream outputStream= new FileOutputStream(oufilename);

            int lenth;

            byte[] buffer =new byte[1024];

            while((lenth=io.read(buffer))>0){
                outputStream.write(buffer,lenth,0);
            }

            io.close();
            outputStream.flush();
            outputStream.close();

        }catch (Exception e){

        }

    }

    public void OpenDatabase(){
        String path=dbpath + dbname;
        SQLiteDatabase.openDatabase(path,null,0);
    }





//    public Cursor fetch1() {
//        String[] columns = new String[]{ID,NAME,DESC};
//
//        Cursor cursor1 = database.rawQuery(TABLE_NAME,columns);
////        query(TABLE_NAME,columns,
////                null,null,null,null,null);
//        if (cursor1 != null) {
//            cursor1.moveToFirst();
//        }
//        return cursor1;
//    }

//    public DatabaseHelper open() throws SQLException {
//        databaseHelper = new DatabaseHelper(mContext,"EngFont.db",null,1);
//        return this;
//    }

    public DatabaseHelper open() throws SQLException{
        databaseHelper=new DatabaseHelper(context,dbname,null,1);
        database= databaseHelper.getReadableDatabase();
        return this;
    }
    public void close(){
        databaseHelper.close();
    }

}
