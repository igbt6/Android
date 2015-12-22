package com.app.uszko.sqllitetestapp.data;

import java.util.List;

/**
 * Created by igbt6 on 20.12.2015.
 */
public interface Dao<T> {
    long save (T type);

    void update(T type);

    void delete(T type);

    T get(long id);
    List<T> getAll();

}
