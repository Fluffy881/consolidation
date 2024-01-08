package fr.dawan.genericite;

import java.util.List;

public interface DAO<T> {

    List<T> getAll();
    void insert(T obj);
}
