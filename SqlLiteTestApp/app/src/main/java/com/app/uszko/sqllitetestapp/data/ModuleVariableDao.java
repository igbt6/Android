package com.app.uszko.sqllitetestapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.provider.BaseColumns;
import com.app.uszko.sqllitetestapp.model.ModuleVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by igbt6 on 20.12.2015.
 */
public class ModuleVariableDao implements Dao<ModuleVariable> {

    private static final String INSERT= "insert into "+ModuleVariableTable.TABLE_NAME+"("+ModuleVariableTable.ModuleVariableColumns._ID+", "+ModuleVariableTable.ModuleVariableColumns.MODULE_ID+", "+ ModuleVariableTable.ModuleVariableColumns.NAME+", "+
            ModuleVariableTable.ModuleVariableColumns.ICON_URL+", "+ModuleVariableTable.ModuleVariableColumns.EQUATION+", "+ModuleVariableTable.ModuleVariableColumns.UNIT+") values(?, ?, ?, ?, ?, ?)";
    private SQLiteDatabase mDb;
    private SQLiteStatement mInsertStatement;


    public ModuleVariableDao(SQLiteDatabase db){
        mDb=db;
        mInsertStatement= mDb.compileStatement(INSERT);
    }
    @Override
    public long save(ModuleVariable entity) {
        mInsertStatement.clearBindings();
        mInsertStatement.bindLong(1, entity.getId());//entity.getId());
        mInsertStatement.bindLong(2, entity.getModuleId());
        mInsertStatement.bindString(3, entity.getName());
        mInsertStatement.bindString(4, entity.getIconUrl());
        mInsertStatement.bindString(5, entity.getEquation());
        mInsertStatement.bindString(6, entity.getUnit());
        return mInsertStatement.executeInsert();
    }

    @Override
    public void update(ModuleVariable entity) {
        final ContentValues values = new ContentValues();
        values.put(ModuleVariableTable.ModuleVariableColumns._ID, entity.getId());
        values.put(ModuleVariableTable.ModuleVariableColumns.MODULE_ID, entity.getModuleId());
        values.put(ModuleVariableTable.ModuleVariableColumns.NAME, entity.getName());
        values.put(ModuleVariableTable.ModuleVariableColumns.ICON_URL, entity.getIconUrl());
        values.put(ModuleVariableTable.ModuleVariableColumns.EQUATION, entity.getEquation());
        values.put(ModuleVariableTable.ModuleVariableColumns.UNIT, entity.getUnit());
        mDb.update(ModuleVariableTable.TABLE_NAME, values, BaseColumns._ID + " = ?", new String[]{String.valueOf(entity.getId())});
    }

    @Override
    public void delete(ModuleVariable entity) {
        if(entity.getId()>0){
            mDb.delete(ModuleVariableTable.TABLE_NAME,BaseColumns._ID +" = ?",new String[] { String.valueOf(entity.getId()) });
        }
    }

    @Override
    public ModuleVariable get(long id) {
        ModuleVariable modVar= null;
        Cursor c = mDb.query(ModuleVariableTable.TABLE_NAME,new String[]{ModuleVariableTable.ModuleVariableColumns._ID,ModuleVariableTable.ModuleVariableColumns.MODULE_ID,ModuleVariableTable.ModuleVariableColumns.NAME,
                        ModuleVariableTable.ModuleVariableColumns.ICON_URL,ModuleVariableTable.ModuleVariableColumns.EQUATION,ModuleVariableTable.ModuleVariableColumns.UNIT},
                ModuleVariableTable.ModuleVariableColumns._ID + " = ?", new String[] { String.valueOf(id) }, null, null, null, "1"); //1 limit
        if(c.moveToFirst()){
            modVar= this.buildModuleVariableFromCursor(c);
        }
        if(!c.isClosed())
            c.close();
        return modVar;
    }

    @Override
    public List<ModuleVariable> getAll() {
        List<ModuleVariable> list = new ArrayList<>();

        Cursor c= mDb.query(ModuleVariableTable.TABLE_NAME, new String[]{ModuleVariableTable.ModuleVariableColumns._ID,ModuleVariableTable.ModuleVariableColumns.MODULE_ID,ModuleVariableTable.ModuleVariableColumns.NAME,
                ModuleVariableTable.ModuleVariableColumns.ICON_URL,ModuleVariableTable.ModuleVariableColumns.EQUATION,ModuleVariableTable.ModuleVariableColumns.UNIT},
                null,null, null, null, ModuleVariableTable.ModuleVariableColumns.NAME, null);
        if(c.moveToFirst()){
            do{
                ModuleVariable modVar = this.buildModuleVariableFromCursor(c);
                if(modVar!=null)
                    list.add(modVar);
            }
            while(c.moveToNext());
        }
        if (!c.isClosed()) {
            c.close();
        }
        return list;
    }


    public List<ModuleVariable> getAllByModuleId(long moduleId){
        List<ModuleVariable> list = new ArrayList<>();
        Cursor c= mDb.query(ModuleVariableTable.TABLE_NAME, new String[]{ModuleVariableTable.ModuleVariableColumns._ID,ModuleVariableTable.ModuleVariableColumns.MODULE_ID,ModuleVariableTable.ModuleVariableColumns.NAME,
                        ModuleVariableTable.ModuleVariableColumns.ICON_URL,ModuleVariableTable.ModuleVariableColumns.EQUATION,ModuleVariableTable.ModuleVariableColumns.UNIT},
                ModuleVariableTable.ModuleVariableColumns.MODULE_ID + " = ?", new String[] { String.valueOf(moduleId) }, null, null, null, null);
        if(c.moveToFirst()){
            do{
                ModuleVariable modVar = this.buildModuleVariableFromCursor(c);
                if(modVar!=null)
                    list.add(modVar);
            }
            while(c.moveToNext());
        }
        if (!c.isClosed()) {
            c.close();
        }
        return list;
    }

    private ModuleVariable buildModuleVariableFromCursor(Cursor c){
        ModuleVariable modVar = null;
        if(c!=null) {
            modVar = new ModuleVariable();
            modVar.setId(c.getLong(0));
            modVar.setModuleId(c.getLong(1));
            modVar.setName(c.getString(2));
            modVar.setIconUrl(c.getString(3));
            modVar.setEquation(c.getString(4));
            modVar.setUnit(c.getString(5));
        }
        return modVar;

    }
}



