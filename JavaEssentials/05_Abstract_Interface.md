## Abstract class

```java
abstract class Animal {
    // Implementation generic to all animals
}

abstract class Pet extends Animal {
    // Implementation generic to all pets
}

class rabbit extends Pet {
    // Inherits what's in Animal and Pet
}
```

- Now when we have generic class we would want to restrict from creating instances of these class

Ex:
```java 
Animal dog = new Animal();
```

- For this reason we have the "abstract" keyword which prevents from creating instance of generic class.
- When we use "abstract" before a class and then try creating an instance the system shows an error.

________

### Abstract Methods

```java
abstract class Animal {
    // Abstract method is declared
    abstract public void move();
}

abstract class Pet extends Animal {
    // Implementation generic to all pets
}

class rabbit extends Pet {
    // All the abstract methods need to be defined
    public void move(){
        // method body
    }
}
```

### Abstract Summary

- Can be applied to classes that you don't want instantiated
- Can be a hierarchy of abstract classes
- Abstract methods indicate the method signature without implementation
- Anything abstract cannot be instantiated
- A non-abstract class extending an abstract class must implement all abstract members
- Method overriding rules apply - method signature, no weaker privilege.

__________

## Final Keyword with inheritance

- Final class which we do not want any more changes or updates for it.
- We cannot inherit from final class

```java
final class A{
    
}

class B extends A{
    // XXX Error Cannot inherit from final class XXX
}
```

### Final methods - Prevent method override

```java
class Rabbit extends Pet{
    final public void move(){
        // method body
    }
}

class WildRabbit extends Rabbit{
    public void move(){
        // XXX Error Cannot override final method XXX
    }
}
```

__________


## Interfaces

- Interface defines is the shape of the class.
- It has the interface instead of class
- Related class will have implements instead of class

```java
public interface Car{
    public void drive();
    public void refuel (Fuel f);
}

class SportsCar implements Car {
    
    @Override
    public void drive(){
        
    }
    
    @Override
    public void refuel (Fuel f){
        
    }
}
```

### Implementing multiple interfaces

- We can have a class which can implement multiple interfaces
- The class need to define all the methods of all the interfaces.

```java
public interface Drivable{
    public void drive();
}

public interface FuelVehicle{
    public void refuel(Fuel f);
}


class SportsCar implements Drivable, FuelVehicle {
    
    @Override
    public void drive(){
        
    }

    @Override
    public void refuel(Fuel f){

    }
}
```

### Interfaces with extends

-Just like in class - subclass, the interfaces can be extended


```java
public interface Drivable{
    public void drive();
}

public interface FuelVehicle extends Drivable{
    public void refuel(Fuel f);
}


class SportsCar implements FuelVehicle {
    
    @Override
    public void drive(){
        
    }

    @Override
    public void refuel(Fuel f){

    }
}
```
________

### Interfaces vs Abstract classes

| Interfaces                  | Abstract                                      |
|-----------------------------|-----------------------------------------------|
| Define "contract" for class | "Template" or starting point for class        |
| Ex: User manual of a device | Ex: Common Structure used in multiple classes |

________


### Default Method in Interface

- In the newer versions of the java we can have default method body for the interface methods
- In the Strict way interfaces only have the Interface method declarations not the method body.
- This looks alot like abstract but an interface is the signaling  the external contract.

```java
interface Drivable{
    
    public default void drive(){
        System.out.println("Driving");
    }
}
```


- We can have this Default method as a problem too
- Wrong case of multiple interfaces
- Error : Multiple interface method defaults
- To Solve: We need to Override the method for it to work.

```java
public interface Drivable{
    public default void drive(){
        System.out.println("Driving");
    }
}

public interface FuelVehicle{
    public default void drive(){
        System.out.println("Driving with fuel");
    }
}


class SportsCar implements Drivable, FuelVehicle {

    // Which drive() works here XXXXXXX
    // To solve override the method
    
    @Override
    public void drive(){
        System.out.println("Driving with fuel");
    }
}
```

_______

### Interfaces Summary

- Used to define the "interface" of a class
- A class can implement multiple interfaces
- Interfaces can extend other interfaces
- Interfaces can contain default methods
- Class Implementation overrides default methods
- When there are conflicts, class has to have implementation
- Interfaces can define "constants" that are available in implementation classes
- Interface can define static methods just like classes
- Interfaces can have private methods. These are called by other methods in the interface. (Use case: common to defualt methods)

__________
