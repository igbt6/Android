package com.app.uszko.sqllitetestapp.data;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

/**
 * Created by igbt6 on 20.12.2015.
 */
public final class ModuleTable {

    public static final  String TABLE_NAME= "module";

    public static final class  ModuleColumns implements BaseColumns {
        public static final String NAME= "module_name";
        public static final String ICON_URL= "icon_url";

    }

    public static void onCreate(SQLiteDatabase db) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE "+ ModuleTable.TABLE_NAME+" (");
        sb.append(BaseColumns._ID+" INTEGER PRIMARY KEY, ");
        sb.append(ModuleColumns.NAME+" TEXT NOT NULL, ");
        sb.append(ModuleColumns.ICON_URL+" TEXT");
        sb.append(");");
        db.execSQL(sb.toString());
    }

    public static void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ModuleTable.TABLE_NAME);
        ModuleTable.onCreate(db);
    }

}
