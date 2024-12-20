package dao;

import java.util.List;

public interface GenericDao <T>{
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(int number);
    List<T> filterByGender(int number);
    List<T> clear();
}
