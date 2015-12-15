package com.app.uszko.sqllitetestapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by igbt6 on 18.12.2015.
 */
public class ModuleDbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME= "modules";
    private static final int DB_VERSION= 1;
    private static final String DB_SUFFIX = ".db";
    private static ModuleDbHelper mInstance;

    public ModuleDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private ModuleDbHelper(Context context) { //prevents external instance creation
        super(context, DB_NAME+DB_SUFFIX, null, DB_VERSION);
    }

    private static ModuleDbHelper getInstance(Context context){
        if(null==mInstance ){
            mInstance= new ModuleDbHelper(context);
        }
        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
