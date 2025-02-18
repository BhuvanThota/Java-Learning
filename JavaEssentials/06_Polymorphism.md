
## Polymorphism

- Poly : Many :: Morphism : Forms
- The ability of java objects to change form

```java
class Animal{
    public void move(){
        System.out.println("Animal moving");
    }
}

public void moveAnimal(Animal animal){
    animal.move();
}

Animal animal = new Animal();
moveAnimal(animal);


// For a subclass like lion
class Lion extends Animal{
    @Override
    public void move(){
        System.out.println("Lion walking");
    }
}

public void moveLion(Lion lion){
    lion.move();
}

Lion lion = new Lion();
moveLion(Lion);
```

- Both the "**moveAnimal() & moveLion()**" methods do the same operation of calling the "**move()**" method for the respective object instance.
- In this case the Lion class inherits Animal class so java considers "**moveAnimal()**" method to work for a instance of Lion class, because Lion class will have inherited all the methods from the Animal class.
- That is, if animal class have a "**move()**" then the Lion class will have the method either same as the super class or an override method.


- So instead of a new "**moveLion()**" method we can use "**moveAnimal()**" method for the Lion instances.
```java
Lion lion = new Lion();
// Instead of -> moveLion(Lion);
// This works in java
moveAnimal(lion);
```

- In simple words, we can give a subclass as a super class for reference
- Any method with super class instance as the arg will accept the subclass instance, because subclass instance contains all the super class metthods or memVars
- Vice versa does not work.

```java
super class <reference> <== sub class <instance>
```
______

##### Key Fact - Notes

**"The subclass can take the form of super class using polymorphism in java."**

**"When a method of a morph instance is accessed, it is the instance method that is accessed not the class method."**

_______


### Polymorphism with interfaces

- When we declare a instance of sportsCar with Drivable then all the methods from Drivable could be accessed.
- But No other interface methods that are implemented in sportsCar is accessable.
- This is both a feature and also a limitation - kind of like a restriction. 
- A class can have 100's of interfaces but by using polymorphism we could restrict the methods accessable by a instance.

```java
public interface Drivable{
    public default void drive(){
        System.out.println("Driving");
    }
}

public interface FuelVehicle{
    public default void refuel(){
        System.out.println("Re-fueling the car");
    }
}


class SportsCar implements Drivable, FuelVehicle {
    
}

// Now with polymorphism
Drivable car = new SportsCar();
car.drive();
```

________

### Casting with Object references

- The above limitation could be solved by casting just like in the primitives
```java
int num = 10;
long number = (long) num;
```

- Just like this we can cast Object of class which have multiple interfaces.
- Java understands this casting for multiple interface related class objects.

```java
public interface Drivable{
    public default void drive(){
        System.out.println("Driving");
    }
}

public interface FuelVehicle{
    public default void refuel(){
        System.out.println("Re-fueling the car");
    }
}


class SportsCar implements Drivable, FuelVehicle {
    
}

// Now with polymorphism
Drivable car = new SportsCar();
car.drive();

// Casting of the class object
FuelVehicle carCopyWithFuel = (FuelVehicle) car;
carCopyWithFuel.refuel();
```

________

### Is - a Relationship

- The subclass Is - a Super class for the references.

_________

### Object Class

- Every class is a child of Object Class
- If there is a super class for the class then the super class's parent class is the Object class
- Object class is like a default class that is given to a class in java on creation.

- Link: https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html


#### Object Class Methods

- Every object class have several predefined methods as mentioned in the above link.
- Ex: Object.equals(c1, c2), c1.toString(), c1.clone(), etc.

_______


#### Object method - equals()

- method Declaration - public boolean equals(Object obj)
- The equals method for class Object implements the most discriminating possible equivalence relation on objects; that is, for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object (x == y has the value true).

```java
Vehicle c1 = new Vehicle();
Vehicle c5 = new Vehicle();
System.out.println(c1.equals(c5));
// Output - false
```

_________

#### Object method - toString()

- The toString method for class Object returns a string consisting of the name of the class of which the object is an instance, the at-sign character `@', and the unsigned hexadecimal representation of the hash code of the object. In other words, this method returns a string equal to the value of:
- **"getClass().getName() + '@' + Integer.toHexString(hashCode())"**


```java
public class Car{
    
}

Car c1 = new Car();
System.out.println(c1.toString());
// Output: Car@5f184fc6
```

___________

