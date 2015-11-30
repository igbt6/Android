package com.app.uszko.viewpagertests;

import java.util.ArrayList;

/**
 * Created by igbt6 on 29.11.2015.
 */
public class DeviceModel {


    private String mName;
    private Integer mId;
    private ArrayList<DeviceParameterModel>  mParameters;

    DeviceModel(Integer devId,String name, ArrayList<DeviceParameterModel> devParams){
        mName=name;
        mId=devId;
        mParameters=devParams;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public Integer getId() {
        return mId;
    }

    public void setId(Integer mId) {
        this.mId = mId;
    }

    public ArrayList<DeviceParameterModel> getParameters() {
        return mParameters;
    }

    public void setParameters(ArrayList<DeviceParameterModel> mParameters) {
        this.mParameters = mParameters;
    }



    public static class DeviceParameterModel{

       private String mName;
       private Double mValue;

       DeviceParameterModel(String name, Double value){
           mName= name;
           mValue=value;
       }

       public String getName() {
           return mName;
       }

       public void setName(String mName) {
           this.mName = mName;
       }



       public Double getValue() {
           return mValue;
       }

       public void setValue(Double mValue) {
           this.mValue = mValue;
       }


   }
}
