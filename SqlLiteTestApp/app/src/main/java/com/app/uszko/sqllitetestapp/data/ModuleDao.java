package com.app.uszko.sqllitetestapp.data;

import com.app.uszko.sqllitetestapp.model.Module;

import java.util.List;

/**
 * Created by igbt6 on 20.12.2015.
 */
public class ModuleDao implements Dao<Module> {
    @Override
    public boolean save(Module type) {
        return false;
    }

    @Override
    public void update(Module type) {

    }

    @Override
    public void delete(Module type) {

    }

    @Override
    public Module get(long id) {
        return null;
    }

    @Override
    public List<Module> getAll() {
        return null;
    }
}
