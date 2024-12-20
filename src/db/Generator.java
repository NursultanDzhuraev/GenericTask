package db;

public class Generator {
    private static Long personId=1L;
    private static Long animalId=1L;
    public static Long setPersonId(){
        return    personId++;
    }
    public static Long setAnimalId(){
        return     animalId++;
    }
}
