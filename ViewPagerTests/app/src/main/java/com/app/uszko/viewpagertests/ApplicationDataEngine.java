package com.app.uszko.viewpagertests;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 08.12.2015.
 */
public class ApplicationDataEngine {

    private static ApplicationDataEngine instance =null;
    private static  Object mutex= new Object();


    private List<DeviceModel> mDevices;


    private ApplicationDataEngine(){
        mDevices = new ArrayList<>();
    }

    public static ApplicationDataEngine getInstance(){
        if(instance==null){
            synchronized (mutex) {
                if(instance==null) {
                    instance = new ApplicationDataEngine();
                }
            }
        }
        return instance;
    }


    void addDevice(DeviceModel dev){

        if(!mDevices.contains(dev)){
            mDevices.add(dev);
        }
    }

    public List<DeviceModel> getDevices() {
        return mDevices;
    }

    public DeviceModel getDeviceByName(String name){
        for(DeviceModel dev:mDevices ){
            if (dev.getName().equals(name))
                return dev;
        }
        return null;
    }

    public DeviceModel getDeviceById(Integer id){
        for(DeviceModel dev:mDevices ){
            if (dev.getId().equals(id))
                return dev;
        }
        return null;
    }

}
