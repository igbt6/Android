package com.app.uszko.sqllitetestapp;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.uszko.sqllitetestapp.data.DataConstants;
import com.app.uszko.sqllitetestapp.data.ModuleTable;
import com.app.uszko.sqllitetestapp.data.ModuleVariableTable;

/**
 * Created by igbt6 on 18.12.2015.
 */

public class ModuleDbHelper extends SQLiteOpenHelper {
    private final String LOG_TAG = ModuleDbHelper.class.getSimpleName();

    private static final int DB_VERSION = 1;
    private static ModuleDbHelper mInstance;
    private Context mContext;

    private ModuleDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext= context;

    }

    private ModuleDbHelper(final Context context) { //prevents external instance creation
        super(context, DataConstants.DB_NAME, null, DB_VERSION);
        mContext= context;
    }

    public static ModuleDbHelper getInstance(Context context){
        if(null==mInstance ){
            mInstance= new ModuleDbHelper(context);
        }
        return mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG_TAG,"Creating database onCreate "+DataConstants.DB_NAME);
        ModuleTable.onCreate(db);
        ModuleVariableTable.onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.i(LOG_TAG, "Creating database onOpen " + DataConstants.DB_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(LOG_TAG,"Creating database onUpgrade "+DataConstants.DB_NAME);
        ModuleTable.onUpgrade(db,oldVersion,newVersion);
        ModuleVariableTable.onUpgrade(db,oldVersion,newVersion);
    }
}
