package com.app.uszko.sqllitetestapp;

/**
 * Created by igbt6 on 11.11.2015.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.support.v4.content.ContextCompat;


/**
 * Util class provides convenient methods for common operations
 */
public class Util {


    public static int getModuleIconPathByUrl(Context context, String iconName){
        String iconUri= "drawable/"+ iconName;

        int iconResource= context.getResources().getIdentifier(iconUri, null, context.getPackageName());
        try{
            Drawable icon= ContextCompat.getDrawable(context, iconResource);
        }
        catch(Exception e){
            // default
            iconResource= R.drawable.ic_smile;
        }
        return iconResource;
    }


    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }


}
