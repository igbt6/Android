package com.app.uszko.sqllitetestapp;

import android.app.Application;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.app.uszko.sqllitetestapp.data.DataManager;
import com.app.uszko.sqllitetestapp.data.DataManagerImpl;

/**
 * Created by igbt6 on 29.12.2015.
 */
public class MainApp extends Application {

    private ConnectivityManager mConnManager;

    private DataManager mDataManager;


    @Override
    public void onCreate() {
        super.onCreate();
        mConnManager= (ConnectivityManager)this.getSystemService(CONNECTIVITY_SERVICE);
        mDataManager = new DataManagerImpl(this);

    }

    public DataManager getDataManager(){
        return mDataManager;
    }

    public boolean isInternetConnectionAvailable(){
        NetworkInfo nInfo = mConnManager.getActiveNetworkInfo();
        if(nInfo!=null&&nInfo.getState()!=null){
            return  nInfo.getState().equals(NetworkInfo.State.CONNECTED);
        }
        return false;
    }
}
