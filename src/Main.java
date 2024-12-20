import db.Generator;
import enam.Gender;
import models.Animal;
import models.Person;
import service.impl.AnimalServiceImpl;
import service.impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanStr = new Scanner(System.in);
    static Scanner scanNumber = new Scanner(System.in);

    public static void main(String[] args) {
        PersonServiceImpl personService = new PersonServiceImpl();
        AnimalServiceImpl animalService = new AnimalServiceImpl();
        while (true) {
            System.out.println("""
                    0 exit
                    1 method person
                    2 method animal
                    """);
            switch (validCommand()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    methodPerson(personService);
                }
                case 2 -> {
                    methodAnimal(animalService);
                }
                default -> System.out.println("Invalid commend!");
            }
        }

    }

    public static void methodPerson(PersonServiceImpl personService) {
        while (true) {
            menu();
            switch (validCommand()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    personService.add(listPerson());
                }
                case 2 -> {
                    System.out.print("Enter person id: ");
                    System.out.println(personService.getById(scanNumber.nextLong()));
                }
                case 3 -> {
                    System.out.println(personService.getAll());
                }
                case 4 -> {
                    System.out.print("Enter 1 or 2 :");
                    System.out.println(personService.sortByName(scanNumber.nextInt()));
                }
                case 5 -> {
                    System.out.print("Enter 1 or 2 :");
                    System.out.println(personService.filterByGender(scanNumber.nextInt()));
                }
                case 6 -> {
                    System.out.println(personService.clear());
                }
                default -> System.out.println("Invalid commend!");
            }
        }
    }

    public static void methodAnimal(AnimalServiceImpl animalService) {
        while (true) {
            menu();

            switch (validCommand()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    animalService.add(listAnimal());
                }
                case 2 -> {
                    System.out.print("Enter person id: ");
                    System.out.println(animalService.getById(scanNumber.nextLong()));
                }
                case 3 -> {
                    System.out.println(animalService.getAll());
                }
                case 4 -> {
                    System.out.print("Enter 1 or 2 :");
                    System.out.println(animalService.sortByName(scanNumber.nextInt()));
                }
                case 5 -> {
                    System.out.print("Enter 1 or 2 :");
                    System.out.println(animalService.filterByGender(scanNumber.nextInt()));
                }
                case 6 -> {
                    System.out.println(animalService.clear());
                }
                default -> System.out.println("Invalid commend!");
            }
        }
    }

    public static void menu() {
        System.out.print("""
                  0 exit
                  1  add 
                  2  getById
                  3  getAll()
                  4  sortByName
                  5  filterByGender
                  6  clear
                """);

    }

    public static int validCommand() {

        System.out.print("command: ");
        while (!scanNumber.hasNextInt()) {
            System.out.print("invalid command. Enter valid command: ");
            scanNumber.next();
        }
        return scanNumber.nextInt();
    }

    public static List<Person> listPerson() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(Generator.setPersonId(), "Aibek", 19, Gender.MALE));
        people.add(new Person(Generator.setPersonId(), "Aigul", 20, Gender.FEMALE));
        people.add(new Person(Generator.setPersonId(), "Ernis", 16, Gender.MALE));
        return people;
    }

    public static List<Animal> listAnimal() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(Generator.setAnimalId(), "Cat", 4, Gender.FEMALE));
        animals.add(new Animal(Generator.setAnimalId(), "Doc", 6, Gender.MALE));
        animals.add(new Animal(Generator.setAnimalId(), "Caw", 5, Gender.FEMALE));
        return animals;
    }
}