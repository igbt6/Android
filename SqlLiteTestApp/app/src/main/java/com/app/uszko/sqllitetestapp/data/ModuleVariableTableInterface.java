package com.app.uszko.sqllitetestapp.data;

import android.provider.BaseColumns;

/**
 * Created by igbt6 on 18.12.2015.
 */
public interface ModuleVariableTableInterface {


    String NAME= "module_variable";

    String COLUMN_ID = BaseColumns._ID;
    String FK_MODULE= "fk_module";
    String COLUMN_NAME = "name";
    String COLUMN_EQUATION ="equation";
    String COLUMN_UNIT="unit";
    String COLUMN_ICON = "icon";

    String[] PROJECTION = new String[]{COLUMN_ID, COLUMN_NAME,COLUMN_EQUATION,
            COLUMN_UNIT,COLUMN_ICON};

    String CREATE = "CREATE TABLE " + NAME + " ("
            + COLUMN_ID + " TEXT PRIMARY KEY, "
            + FK_MODULE+ " REFERENCES "
      //      + ModuleTable.NAME + "(" + ModuleTable.COLUMN_ID + "), "
            + COLUMN_NAME + " TEXT NOT NULL, "
            + COLUMN_EQUATION + " TEXT NOT NULL, "
            + COLUMN_UNIT + " TEXT NOT NULL, "
            + COLUMN_ICON + ");";
}
