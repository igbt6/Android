package com.app.uszko.sqllitetestapp.model;


/**
 * Created by igbt6 on 17.12.2015.
 */

public class ModuleVariable extends ModelBase implements Comparable<ModuleVariable> {

    private String mName;
    private String mEquation;
    private String mUnit;
    private String mIconUrl;


    private long mModuleId;
    public ModuleVariable(long modId,String name, String equation, String unit, String icon){

        mName =name;
        mEquation =equation;
        mUnit =unit;
        mIconUrl =icon;
        mModuleId=modId;
    }

    public ModuleVariable(){

    }

    public long getModuleId() {
        return mModuleId;
    }

    public void setModuleId(long mModuleId) {
        this.mModuleId = mModuleId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getEquation() {
        return mEquation;
    }

    public void setEquation(String mEquation) {
        this.mEquation = mEquation;
    }

    public String getUnit() {
        return mUnit;
    }

    public void setUnit(String mUnit) {
        this.mUnit = mUnit;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String mIconUrl) {
        this.mIconUrl = mIconUrl;
    }



    @Override
    public String toString() {
        return "VARIABLE: "+ mName + " "+mEquation +" "+mUnit+" "+ mIconUrl + '\n';
    }

    @Override
    public int compareTo(ModuleVariable another) {
        if(another ==null){
            return -1;
        }
        if(mName==null){
            return  -1;
        }
        return mName.compareTo(another.mName);
    }

    /* //shall be overwritten
        @Override
        public int hashCode(){
            return 0;
        }

        @Override
        public boolean equals(Object obj){
            return true
        }
    */
}
