package dev.jdk.daos;

import java.util.List;

public interface GenericDAO <T> {
    //READ
    T getById(int id);

    List<T> getAll();

    // CREATE
    T create(T t);

    // UPDATE
    void update(T tUpdated);

    // DELETE
    void delete(int id);
}
