package DIY.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Visitor {
    public static void main(String[] args) {
        Pet pet = new Pet();
        PetVisitor adoptionService = new AdoptionService();
        PetVisitor vaccinationService = new VaccinationService();
        
        pet.add(new Dog("Rocky", "Aspin", "1 year and 6 months old"));
        pet.add(new Cat("Rick", "Domestic Shorthair", "3 months old"));

        System.out.println("=== ADOPTION SERVICE ===");
        pet.execute(adoptionService);
        System.out.println("=== VACCINATION SERVICE ===");
        pet.execute(vaccinationService);

    }
}

interface PetInterface{
    void execute(PetVisitor visitor);
}

interface PetVisitor{
    void apply(Dog dog);
    void apply(Cat cat);

}
class Dog implements PetInterface{
    String name;
    String breed;
    String age;
    
    @Override
    public void execute(PetVisitor visitor) {
        visitor.apply(this);
    }
    public Dog(String name, String breed, String age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

}
class Cat implements PetInterface{
    String name;
    String breed;
    String age;

    
    @Override
    public void execute(PetVisitor visitor) {
        visitor.apply(this);
    }
    
    public Cat(String name, String breed, String age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
}
class Pet{
    private List<PetInterface> pets = new ArrayList<>();
    public void add(PetInterface pet){
        pets.add(pet);
    }
    public void execute(PetVisitor visitor){
        for(var pet : pets){
            pet.execute(visitor);
        }
    }

}
class AdoptionService implements PetVisitor{

    @Override
    public void apply(Dog dog) {
        System.out.println("____ Pet Information ____");
        System.out.println("Name: " + dog.name + "\nBreed: " + dog.breed + "\nAge: " + dog.age + "\n");
    }

    @Override
    public void apply(Cat cat) {
        System.out.println("____ Pet Information ____");
        System.out.println("Name: " + cat.name + "\nBreed: " + cat.breed + "\nAge: " + cat.age + "\n");
    }

}
class VaccinationService implements PetVisitor{

    @Override
    public void apply(Dog dog) {
        System.out.println(dog.name + " has been successfully vaccinated!");
    }

    @Override
    public void apply(Cat cat) {
        System.out.println(cat.name + " has been successfully vaccinated!");
    }

}