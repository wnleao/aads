package exercises.chapter03;

import java.util.LinkedList;
import java.util.Optional;

public class Ex06AnimalShelter {

  public static void main(String[] args) {
    AnimalShelter shelter = new AnimalShelter();
    shelter.enqueue(new Dog("Bob"));
    shelter.enqueue(new Dog("Joe"));
    shelter.enqueue(new Dog("Pintado"));
    shelter.enqueue(new Cat("Tapioca"));
    shelter.enqueue(new Cat("Romeu"));
    shelter.enqueue(new Dog("Djow"));
    
    System.out.println(shelter);

    System.out.println(shelter.dequeueCat());
    System.out.println(shelter.dequeueAny());
    System.out.println(shelter.dequeueCat());
    System.out.println(shelter.dequeueDog());
    System.out.println(shelter.dequeueAny());
  }

}

class AnimalShelter {
  
  private LinkedList<Animal> list = new LinkedList<>();

  public void enqueue(Animal animal) {
    list.add(animal);
  }

  public Optional<Animal> dequeueAny() {
    return list.isEmpty() ? Optional.empty() : Optional.of(list.remove());
  }

  public Optional<Cat> dequeueCat() {
    return dequeue(Cat.class);
  }

  public Optional<Dog> dequeueDog() {
    return dequeue(Dog.class);
  }

  private <T extends Animal> Optional<T> dequeue(Class<T> clazz) {
    int index = firstIndexOf(clazz);
    return index >= 0 ? Optional.of(clazz.cast(list.remove(index))) : Optional.empty();   
  }

  private <T extends Animal> int firstIndexOf(Class<T> clazz) {
    int i = 0;
    for (Animal a : list) {
      if (clazz.isInstance(a)) {
        return i;
      }  
      i++;
    }
    return -1;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(Animal a : list) {
      if (sb.length() > 0) {
        sb.append(", ");
      }
      sb.append(a);
    }
    return sb.toString();
  }

}

abstract class Animal {
  private final String name;
  public Animal(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  @Override
  public String toString() {
    return "[" + getClass() + ": " + getName() + "]";
  }
}

class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }
}

class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }
}
