// Visitor.ts

interface PetInterface {
    execute(visitor: PetVisitor): void;
  }
  
  interface PetVisitor {
    apply(dog: Dog): void;
    apply(cat: Cat): void;
  }
  
  class Dog implements PetInterface {
    name: string;
    breed: string;
    age: string;
  
    constructor(name: string, breed: string, age: string) {
      this.name = name;
      this.breed = breed;
      this.age = age;
    }
  
    execute(visitor: PetVisitor): void {
      visitor.apply(this);
    }
  }
  
  class Cat implements PetInterface {
    name: string;
    breed: string;
    age: string;
  
    constructor(name: string, breed: string, age: string) {
      this.name = name;
      this.breed = breed;
      this.age = age;
    }
  
    execute(visitor: PetVisitor): void {
      visitor.apply(this);
    }
  }
  
  class Pet {
    private pets: PetInterface[] = [];
  
    add(pet: PetInterface): void {
      this.pets.push(pet);
    }
  
    execute(visitor: PetVisitor): void {
      for (const pet of this.pets) {
        pet.execute(visitor);
      }
    }
  }
  
  class AdoptionService implements PetVisitor {
    apply(dog: Dog): void {
      console.log("____ Pet Information ____");
      console.log("Name: " + dog.name + "\nBreed: " + dog.breed + "\nAge: " + dog.age + "\n");
    }
  
    apply(cat: Cat): void {
      console.log("____ Pet Information ____");
      console.log("Name: " + cat.name + "\nBreed: " + cat.breed + "\nAge: " + cat.age + "\n");
    }
  }
  
  class VaccinationService implements PetVisitor {
    apply(dog: Dog): void {
      console.log(dog.name + " has been successfully vaccinated!");
    }
  
    apply(cat: Cat): void {
      console.log(cat.name + " has been successfully vaccinated!");
    }
  }
  
  (function main(): void {
    const pet = new Pet();
    const adoptionService = new AdoptionService();
    const vaccinationService = new VaccinationService();
  
    pet.add(new Dog("Rocky", "Aspin", "1 year and 6 months old"));
    pet.add(new Cat("Rick", "Domestic Shorthair", "3 months old"));
  
    console.log("=== ADOPTION SERVICE ===");
    pet.execute(adoptionService);
    console.log("=== VACCINATION SERVICE ===");
    pet.execute(vaccinationService);
  })();
  