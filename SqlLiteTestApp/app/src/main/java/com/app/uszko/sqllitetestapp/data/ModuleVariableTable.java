package com.app.uszko.sqllitetestapp.data;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by igbt6 on 20.12.2015.
 */
public final class ModuleVariableTable {

    public static final  String TABLE_NAME= "module_variable";

    public static final class  ModuleVariableColumns implements BaseColumns {
        public static final String NAME= "module_variable_name";
        public static final String ICON_URL= "icon_url";
        public static final String EQUATION ="equation";
        public static final String UNIT="unit";

        public static final String MODULE_ID = "module_id"; //Foreign key

    }

    public static void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE "+ ModuleVariableTable.TABLE_NAME+" (");
        sb.append(BaseColumns._ID+" INTEGER, ");
        sb.append( ModuleVariableColumns.MODULE_ID +" INTEGER NOT NULL, ");

        sb.append(ModuleVariableColumns.NAME+" TEXT NOT NULL PRIMARY KEY, ");
        sb.append(ModuleVariableColumns.ICON_URL+" TEXT, ");
        sb.append(ModuleVariableColumns.EQUATION+" TEXT, ");
        sb.append(ModuleVariableColumns.UNIT+" TEXT, ");
        sb.append("FOREIGN KEY(" + ModuleVariableColumns.MODULE_ID + ") REFERENCES " + ModuleTable.TABLE_NAME + "("
                + BaseColumns._ID + ")");
        sb.append(");");
        db.execSQL(sb.toString());
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ModuleVariableTable.TABLE_NAME);
        ModuleVariableTable.onCreate(db);
    }

}
