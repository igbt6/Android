package com.app.uszko.sqllitetestapp;

import android.provider.BaseColumns;

/**
 * Created by igbt6 on 18.12.2015.
 */
public interface ModuleTable {


    String NAME= "module";

    String COLUMN_ID = BaseColumns._ID;
    String COLUMN_NAME = "name";
    String COLUMN_ICON = "icon";

    String[] PROJECTION = new String[]{COLUMN_ID, COLUMN_NAME,
            COLUMN_ICON};

    String CREATE = "CREATE TABLE " + NAME + " ("
            + COLUMN_ID + " TEXT PRIMARY KEY, "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_ICON + ");";
}
