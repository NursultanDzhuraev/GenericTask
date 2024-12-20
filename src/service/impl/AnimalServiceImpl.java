package service.impl;

import dao.impl.AnimalDaoImpl;
import models.Animal;
import service.GenericService;

import java.util.List;

public class AnimalServiceImpl implements GenericService<Animal> {
   private final AnimalDaoImpl adminDao = new AnimalDaoImpl();
    @Override
    public String add(List<Animal> animals) {
        return adminDao.add(animals);
    }

    @Override
    public Animal getById(Long id) {
        return adminDao.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return adminDao.getAll();
    }

    @Override
    public List<Animal> sortByName(int number) {
        return adminDao.sortByName(number);
    }

    @Override
    public List<Animal> filterByGender(int number) {
        return adminDao.filterByGender(number);
    }

    @Override
    public List<Animal> clear() {
        return adminDao.clear();
    }
}
