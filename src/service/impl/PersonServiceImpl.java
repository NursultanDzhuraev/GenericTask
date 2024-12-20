package service.impl;

import dao.GenericDao;
import dao.impl.PersonDaoImpl;
import models.Person;
import service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
   private final PersonDaoImpl personDao = new PersonDaoImpl();
    @Override
    public String add(List<Person> people) {
        personDao.add(people);
        return "Successful!";
    }

    @Override
    public Person getById(Long id) {
        return personDao.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Person> sortByName(int number) {
        return personDao.sortByName(number);
    }

    @Override
    public List<Person> filterByGender(int number) {
        return personDao.filterByGender(number);
    }

    @Override
    public List<Person> clear() {
        return personDao.clear();
    }
}
