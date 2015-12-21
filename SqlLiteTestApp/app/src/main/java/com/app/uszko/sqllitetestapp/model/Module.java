package com.app.uszko.sqllitetestapp.model;

import java.util.ArrayList;

/**
 * Created by igbt6 on 20.12.2015.
 */
public class Module extends ModelBase {

    private String mName;
    private String mIconUrl;
    private ArrayList<ModuleVariable> mModuleVariablesList;
    public Module(long id, String name, String icon){

        mName =name;
        mId =id;
        mIconUrl = icon;
        mModuleVariablesList = new ArrayList<>();

    }
    public Module(){
        mModuleVariablesList = new ArrayList<>();
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public ArrayList<ModuleVariable> getModuleVariablesList() {
        return mModuleVariablesList;
    }

    public void setModuleVariablesList(ArrayList<ModuleVariable> mModuleVariablesList) {
        this.mModuleVariablesList = mModuleVariablesList;
    }

    public String getIconUrl() {
        return mIconUrl;
    }

    public void setIconUrl(String mIconUrl) {
        this.mIconUrl = mIconUrl;
    }


    @Override
    public String toString() {
        String moduleStr= new String();
        moduleStr+= "MODULE: "+ String.valueOf(mId)+ " "+ mName +" "+ mIconUrl + '\n';
        for(ModuleVariable var : mModuleVariablesList){
            moduleStr+=" "+var.toString();
        }
        return moduleStr;
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
