package com.app.uszko.sqllitetestapp.data;


import com.app.uszko.sqllitetestapp.model.Module;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;

import java.util.List;

/**
 * Created by igbt6 on 22.12.2015.
 */
public interface DataManager {
    // Module
    public Module getModule(long moduleId);

    public List<Module> getAllModules();

    public Module getModuleByName(String name);

    public long saveModule(Module module);

    public boolean deleteModule(long moduleId);


    // Module Variables
    public ModuleVariable getModuleVariable(long modVarId);

    public List<ModuleVariable> getAllModVariables();

    public List<ModuleVariable> getAllModVariablesByModuleId(long moduleId);

    public long saveModuleVariable(ModuleVariable modVar);

    public void deleteModuleVariable(ModuleVariable modVar);

}
