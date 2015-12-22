package com.app.uszko.sqllitetestapp.data;

import android.os.Environment;

/**
 * Created by igbt6 on 21.12.2015.
 */
public final class DataConstants {

    private static final String APP_PACKAGE_NAME ="com.app.uszko.sqllitetestapp";
    public static final String DB_NAME= "modules.db";
    public static final String DB_PATH =Environment.getDataDirectory() + "/data/" + DataConstants.APP_PACKAGE_NAME + "/databases/"+ DataConstants.DB_NAME;
}
