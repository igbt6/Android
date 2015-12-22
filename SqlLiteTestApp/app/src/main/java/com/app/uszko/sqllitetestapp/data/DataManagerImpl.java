package com.app.uszko.sqllitetestapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.app.uszko.sqllitetestapp.ModuleDbHelper;
import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;

import java.util.List;

/**
 * Created by igbt6 on 22.12.2015.
 */
public class DataManagerImpl implements DataManager {


    private SQLiteDatabase mDb;
    private ModuleDao moduleDao;
    private ModuleVariableDao moduleVariableDao;
    private Context mContext;

    DataManagerImpl(Context context){
        mContext= context;

        mDb= ModuleDbHelper.getInstance(mContext).getWritableDatabase();
        moduleDao= new ModuleDao(mDb);
        moduleVariableDao= new ModuleVariableDao(mDb);
    }


    public SQLiteDatabase getDatabase(){
        return mDb;
    }


    @Override
    public Module getModule(long moduleId) {
        return null;
    }

    @Override
    public List<Module> getAllModules() {
        return null;
    }

    @Override
    public Module getModuleByName(String name) {
        return null;
    }

    @Override
    public long saveModule(Module movie) {
        return 0;
    }

    @Override
    public boolean deleteModule(long movieId) {
        return false;
    }

    @Override
    public ModuleVariable getModuleVariable(long modVarId) {
        return null;
    }

    @Override
    public List<ModuleVariable> getAllModVariables() {
        return null;
    }

    @Override
    public List<ModuleVariable> getAllModVariablesByModuleId(long moduleId) {
        return null;
    }

    @Override
    public long saveModuleVariable(ModuleVariable modVar) {
        return 0;
    }

    @Override
    public void deleteModuleVariable(ModuleVariable modVar) {

    }
}
