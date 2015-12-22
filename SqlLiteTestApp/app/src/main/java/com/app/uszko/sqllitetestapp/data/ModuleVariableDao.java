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

    private static final String INSERT= "insert into "+ModuleVariableTable.TABLE_NAME+"("+ModuleVariableTable.ModuleVariableColumns._ID+", "+ ModuleVariableTable.ModuleVariableColumns.NAME+", "+
            ModuleVariableTable.ModuleVariableColumns.ICON_URL+", "+ModuleVariableTable.ModuleVariableColumns.EQUATION+") values(?, ?, ?,?)";
    private SQLiteDatabase mDb;
    private SQLiteStatement mInsertStatement;


    public ModuleVariableDao(SQLiteDatabase db){
        mDb=db;
        mInsertStatement= mDb.compileStatement(INSERT);
    }
    @Override
    public long save(ModuleVariable type) {
        mInsertStatement.clearBindings();
        mInsertStatement.bindLong(0, type.getId());
        mInsertStatement.bindLong(1,type.getModuleId());
        mInsertStatement.bindString(2, type.getName());
        mInsertStatement.bindString(3, type.getIconUrl());
        mInsertStatement.bindString(4, type.getEquation());
        mInsertStatement.bindString(5, type.getUnit());
        return mInsertStatement.executeInsert();
    }

    @Override
    public void update(ModuleVariable type) {
        final ContentValues values = new ContentValues();
        values.put(ModuleVariableTable.ModuleVariableColumns.MODULE_ID, type.getModuleId());
        values.put(ModuleVariableTable.ModuleVariableColumns.NAME, type.getName());
        values.put(ModuleVariableTable.ModuleVariableColumns.ICON_URL, type.getIconUrl());
        values.put(ModuleVariableTable.ModuleVariableColumns.EQUATION, type.getEquation());
        values.put(ModuleVariableTable.ModuleVariableColumns.UNIT, type.getUnit());
        mDb.update(ModuleVariableTable.TABLE_NAME, values, BaseColumns._ID + " = ?", new String[]{String.valueOf(type.getId())});
    }

    @Override
    public void delete(ModuleVariable type) {
        if(type.getId()>0){
            mDb.delete(ModuleVariableTable.TABLE_NAME,BaseColumns._ID +" = ?",new String[] { String.valueOf(type.getId()) });
        }
    }

    @Override
    public ModuleVariable get(long id) {
        ModuleVariable modVar= null;
        Cursor c = mDb.query(ModuleVariableTable.TABLE_NAME,new String[]{ModuleVariableTable.ModuleVariableColumns._ID,ModuleVariableTable.ModuleVariableColumns.MODULE_ID,ModuleVariableTable.ModuleVariableColumns.NAME,
                        ModuleVariableTable.ModuleVariableColumns.ICON_URL,ModuleVariableTable.ModuleVariableColumns.EQUATION,ModuleVariableTable.ModuleVariableColumns.UNIT},
                ModuleVariableTable.ModuleVariableColumns._ID + " = ?", new String[] { String.valueOf(id) }, null, null, null, "l");
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
                null,null, null, null, ModuleTable.ModuleColumns.NAME, null);
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
                ModuleVariableTable.ModuleVariableColumns.MODULE_ID + " = ?", new String[] { String.valueOf(moduleId) }, null, null, null, "l");
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



