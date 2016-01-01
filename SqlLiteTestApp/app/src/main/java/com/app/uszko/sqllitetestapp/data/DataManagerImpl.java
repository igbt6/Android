package com.app.uszko.sqllitetestapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.app.uszko.sqllitetestapp.ModuleDbHelper;
import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by igbt6 on 22.12.2015.
 */
public class DataManagerImpl implements DataManager {

    private static String LOG_TAG = DataManagerImpl.class.getName();
    private SQLiteDatabase mDb;
    private ModuleDao moduleDao;
    private ModuleVariableDao moduleVariableDao;
    private Context mContext;

    public DataManagerImpl(Context context) {
        mContext= context;

        mDb= ModuleDbHelper.getInstance(mContext).getWritableDatabase();
        moduleDao= new ModuleDao(mDb);
        moduleVariableDao= new ModuleVariableDao(mDb);
    }


    public SQLiteDatabase getDatabase(){
        return mDb;
    }



    //wrappers for DAO obiects.
    @Override
    public Module getModule(long moduleId) {
        Module module = moduleDao.get(moduleId);
        if(module!=null){
            module.getModuleVariablesList().addAll(moduleVariableDao.getAllByModuleId(module.getId()));
        }
        return module;
    }

    @Override
    public List<Module> getAllModules() {
        return moduleDao.getAll();
    }

    @Override
    public Module getModuleByName(String name) {
        Module module = moduleDao.getByName(name);
        if(module!=null){
            module.getModuleVariablesList().addAll(moduleVariableDao.getAllByModuleId(module.getId()));
        }
        return module;
    }

    @Override
    public long saveModule(Module module) {
        long modRowId=0L;
        try{
            mDb.beginTransaction();
            modRowId= moduleDao.save(module);
            //in case if we have some data there connected to a given module
            List<ModuleVariable> varList = null;//moduleVariableDao.getAllByModuleId(module.getId());  TODO
            long modVarRowId=0L;
            if(varList==null){
                for(ModuleVariable mVar: module.getModuleVariablesList()){
                    modVarRowId= moduleVariableDao.save(mVar);
                }
            }
            else{
                //some module variables existed in data base - handle it here
            }
            mDb.setTransactionSuccessful();
        } catch (SQLiteException e){
            Log.e(LOG_TAG, "Saving module failed", e);
        }
        finally {
            mDb.endTransaction();
        }
        return modRowId;
    }

    @Override
    public boolean deleteModule(long moduleId) {

        boolean result = false;
        try{
            mDb.beginTransaction();
            Module module = moduleDao.get(moduleId);

            if(module!=null){
                for(ModuleVariable mVar: module.getModuleVariablesList()){
                    moduleVariableDao.delete(mVar);
                }
                moduleDao.delete(module);
            }
            mDb.setTransactionSuccessful();
            result = true;
        } catch (SQLiteException e) {
            Log.e(LOG_TAG, "Deleting module Failed", e);
        } finally {
            mDb.endTransaction();
        }
        return result;
    }
    //TODO same as above, i won't be using it in the demo app
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
