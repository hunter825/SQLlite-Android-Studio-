package com.example.rohit.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.NoCopySpan;

public class Secondclass extends SQLiteOpenHelper {


    public static final String DATA_BASENAME  = "DAATABASE";
    public static final String TABLE_NAME  = "TABLENAME";
    public static final String COL_ID  = "ID";
    public static final String COLO_NAME  = "NAME";
    public static final String COL_COUNTRY  = "COUNTRY";

    public Secondclass(Context context){

        super(context,DATA_BASENAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME +" (NAME TEXT,COUNTRY TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {



    }


    public boolean add(String name, String country)
    {

        SQLiteDatabase sqllite = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLO_NAME, name);
        contentValues.put(COL_COUNTRY, country);

        long result = sqllite.insert(TABLE_NAME, null, contentValues);


        if (result == -1)
            return false;
        else
            return true;
        }




    public Cursor viewdata() {

        SQLiteDatabase sql = this.getWritableDatabase();
        Cursor c = sql.rawQuery("select * from " + TABLE_NAME, null);
        return c;


    }
    public boolean  update(String name ,String country){

        SQLiteDatabase sqllite = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLO_NAME, name);
        contentValues.put(COL_COUNTRY, country);
        sqllite.update(TABLE_NAME,contentValues,"NAME  = ?",new String[] { name });
        return true;

}

         public Integer delete(String name ,String country)
         {

             ContentValues contentValues = new ContentValues();
             SQLiteDatabase sqllite = this.getWritableDatabase();
             return  sqllite.delete(TABLE_NAME,"NAME  = ?",new String[] { name });

         }

}


