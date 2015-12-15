package com.app.uszko.sqllitetestapp;


/**
 * Created by igbt6 on 17.12.2015.
 */

public class ModuleVariable {



    private String mName;
    private String mEquation;
    private String mUnit;
    private String mIcon;
    private Double mComputedValue;
    public ModuleVariable(String name, String equation, String unit, String icon){

        mName =name;
        mEquation =equation;
        mUnit =unit;
        mIcon =icon;
        mComputedValue=0.0;

    }
    //setters
    public void setName(String name){

        mName =name;
    }

    public void setEquation(String equation){

        mEquation =equation;
    }


    public void setUnit(String unit){

        mUnit =unit;
    }

    public void setIcon(String icon){

        mIcon =icon;
    }

    //getters
    public String getName( ){

        return mName;
    }

    public String getEquation( ){

        return mEquation;
    }

    public String getUnit(){

        return mUnit;
    }

    public String getIcon(){
        return mIcon;
    }


    public void setComputedValue(Double value){
        mComputedValue= value;
    }

    public Double getComputedValue(){
        return mComputedValue;
    }



    @Override
    public String toString() {
        return "VARIABLE: "+ mName + " "+mEquation +" "+mUnit+" "+mIcon+ '\n';
    }
}
