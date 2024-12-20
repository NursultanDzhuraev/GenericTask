package dao.impl;

import dao.GenericDao;
import db.DateBase;
import enam.Gender;
import models.Animal;

import java.util.Comparator;
import java.util.List;

public class AnimalDaoImpl implements GenericDao<Animal> {
    private final DateBase dateBase = new DateBase();

    @Override
    public String add(List<Animal> animals) {
        dateBase.animalList.addAll(animals);
        return "Successful!";
    }

    @Override
    public Animal getById(Long id) {
        for (Animal animal : dateBase.animalList) {
            if (animal.getId().equals(id)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return dateBase.animalList;
    }

    @Override
    public List<Animal> sortByName(int number) {
        dateBase.animalList.sort(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (number == 1) return o1.getName().compareTo(o2.getName());
                else return o2.getName().compareTo(o1.getName());
            }
        });
        return null;
    }

    @Override
    public List<Animal> filterByGender(int number) {
        for (Animal animal : dateBase.animalList) {
            if (number == 1) {
                if (animal.getGender().equals(Gender.FEMALE))
                    System.out.println(animal);
            } else if (number == 2) {
                if (animal.getGender().equals(Gender.MALE))
                    System.out.println(animal);
            }
        }
        return null;
    }

    @Override
    public List<Animal> clear() {
        dateBase.animalList.clear();
        return dateBase.animalList;
    }
}
