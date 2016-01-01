package com.app.uszko.sqllitetestapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;

import com.app.uszko.sqllitetestapp.model.Module;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 20.12.2015.
 */
public class ModuleDao implements Dao<Module> {

    private static final String INSERT= "insert into "+ModuleTable.TABLE_NAME+"("+ModuleTable.ModuleColumns._ID+", "+ ModuleTable.ModuleColumns.NAME+", "+
            ModuleTable.ModuleColumns.ICON_URL+") values(?, ?, ?)";

    private SQLiteDatabase mDb;
    private SQLiteStatement mInsertStatement;


    public ModuleDao(SQLiteDatabase db){
        mDb=db;
        mInsertStatement= mDb.compileStatement(INSERT);
    }
    @Override
    public long save(Module entity) {
        mInsertStatement.clearBindings();
        mInsertStatement.bindLong(1, entity.getId());
        mInsertStatement.bindString(2, entity.getName());
        mInsertStatement.bindString(3, entity.getIconUrl());
        return mInsertStatement.executeInsert();
    }

    @Override
    public void update(Module entity) {
        final ContentValues values = new ContentValues();
        values.put(ModuleTable.ModuleColumns._ID, entity.getId());
        values.put(ModuleTable.ModuleColumns.NAME, entity.getName());
        values.put(ModuleTable.ModuleColumns.ICON_URL, entity.getIconUrl());
        mDb.update(ModuleTable.TABLE_NAME, values, BaseColumns._ID + " = ?", new String[]{String
                .valueOf(entity.getId())});
    }

    @Override
    public void delete(Module entity) {
        if(entity.getId()>0){
            mDb.delete(ModuleTable.TABLE_NAME,BaseColumns._ID +" = ?",new String[] { String.valueOf(entity.getId()) });
        }
    }

    @Override
    public Module get(long id) {
        Module module=null;
        Cursor c= mDb.query(ModuleTable.TABLE_NAME, new String[]{ModuleTable.ModuleColumns._ID,ModuleTable.ModuleColumns.NAME,ModuleTable.ModuleColumns.ICON_URL},
                        ModuleTable.ModuleColumns._ID + " = ?", new String[] { String.valueOf(id) }, null, null, null, "l");
        if(c.moveToFirst()){
            module = this.buildModuleFromCursor(c);
        }
        if(!c.isClosed()){
            c.close();
        }
        return module;
    }

    @Override
    public List<Module> getAll() {
        List<Module> list = new ArrayList<>();

        Cursor c= mDb.query(ModuleTable.TABLE_NAME, new String[]{ModuleTable.ModuleColumns._ID,ModuleTable.ModuleColumns.NAME,ModuleTable.ModuleColumns.ICON_URL},
                null,null, null, null, ModuleTable.ModuleColumns.NAME, null);

        if(c.moveToFirst()){
            do{
                Module module = this.buildModuleFromCursor(c);
                if(module!=null)
                    list.add(module);
            }
            while(c.moveToNext());
        }
        if (!c.isClosed()) {
            c.close();
        }
        return list;
    }


    public Module getByName(String name) {
        long movieId = 0L;
        String sql = "select _id from " + ModuleTable.TABLE_NAME + " where upper(" +  ModuleTable.ModuleColumns.NAME + ") = ? limit 1";
        Cursor c = mDb.rawQuery(sql, new String[] { name.toUpperCase() });
        if (c.moveToFirst()) {
            movieId = c.getLong(0);
        }
        if (!c.isClosed()) {
            c.close();
        }
        //can we do this better : )?
        return this.get(movieId);
    }



    private Module buildModuleFromCursor(Cursor c) {
        Module movie = null;
        if (c != null) {
            movie = new Module();
            movie.setId(c.getLong(0));
            movie.setName(c.getString(1));
            movie.setIconUrl(c.getString(2));
        }
        return movie;
    }
}
