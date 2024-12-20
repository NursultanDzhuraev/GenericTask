package dao.impl;

import dao.GenericDao;
import db.DateBase;
import enam.Gender;
import models.Animal;
import models.Person;

import java.util.Comparator;
import java.util.List;

public class PersonDaoImpl implements GenericDao<Person> {
    private final DateBase dateBase = new DateBase();

    @Override
    public String add(List<Person> people) {
        dateBase.peopleList.addAll(people);
        return "Successful!";
    }

    @Override
    public Person getById(Long id) {
        for (Person person : dateBase.peopleList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> getAll() {
        return dateBase.peopleList;
    }

    @Override
    public List<Person> sortByName(int number) {
        dateBase.peopleList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (number == 1) return o1.getName().compareTo(o2.getName());
                else return o2.getName().compareTo(o1.getName());
            }
        });

        return null;
    }

    @Override
    public List<Person> filterByGender(int number) {
        for (Person person : dateBase.peopleList) {
            if (number == 1) {
                if (person.getGender().equals(Gender.FEMALE))
                    System.out.println(person);
            } else if (number == 2) {
                if (person.getGender().equals(Gender.MALE))
                    System.out.println(person);
            }
        }
        return null;
    }

    @Override
    public List<Person> clear() {
        dateBase.peopleList.clear();
        return dateBase.peopleList;
    }
}
