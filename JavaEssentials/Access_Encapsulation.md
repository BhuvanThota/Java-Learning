

## Packages

- A package can contain multiple classes
- All the classes in a package are unique.
- Multiple packages can have class of same name.

- pwd = -> Source -> JavaEssentials -> Basics -> Car.java

```java
package JavaEssentials.Basics;

class Car {
    int seats;
    int wheels;
    double weight;
    double mileage; 
}
```

- Used for grouping classes and interfaces
- Provides namespacing for class names
- Provides encapsulation - access control for code in classes
- No hierarchy! -> **_Very Important_**

_______

## Importing Class

- Import is used to access a class from different package
- There could be multiple classes with a given name
- You can use a fully qualified name instead of import
- You can import * for a package

To get the Car class from above
```java
import JavaEssentials.Basics.*;

class Vehicle{
    public static void main(String[]){
        Car c1 = new Car();
        
    }
}
```
________

## Access Modifiers

##### Types of Access

- Public -> Accessible to everyone
- Private -> Not accessible outside the class
- Protected -> Accessible by inheritance (subclass)
- Default -> Package private 

```java
class Car {
    // Private Access - Only within this class
    private int seats;
    private int wheels;
    private double weight;
    private double mileage;

    Car() {  
        mileage = 0;
        wheels = 4;
    }

    Car(int numberofSeats) { 
        this(); 
        seats = numberofSeats;
    }
    
    // Public Access - Outside of class
    public boolean isFourSeater(){
        return seats == 4;
    }
}

Car audi = new Car();

// audi.seats = 7; // XXXXXX This Do not work XXXXXXX

boolean checkFourseater = audi.isFourSeater(); // This will work.
```


### Default access modifier

- When we do not mention the access modifier for a class varMem or Method
- Default is package private
- Acts like public if in the same package
- Acts like private to other packages

#### Access Modifier Grid

| Modifier    | Class | Package | SubClass | All else |
|-------------|-------|---------|----------|----------|
| public      | Y     | Y       | Y        | Y        |
| protected   | Y     | Y       | Y        | N        |
| no modifier | Y     | Y       | N        | N        |
| private     | Y     | N       | N        | N        |


### Recommended Practice

- All State is private
- Methods can be mixed - depends on whether the method is internal-only or meant to be called outside
- Use getters and setters to access internal state
- Package-private rarely used
- Protected based on inheritance access needs


_________

## Static Keyword

- When we need to define a class member as independent of any object instance
- Make a class member associated with a class not an instance

```java
class Car{
    Static int seats;
    int wheels;
    double weight;
    double topSpeed;
    
    static voide staticMethodName() {
        
    }
}

Car myCar = new Car();
// We call the non static var mems like this
myCar.wheels;

// To call the static varMems or Methods
Car.seats;
Car.staticMethodName();
```

- Makes a class member associated with the class, not instance
- Can be accessed before any instance are created.
- No instances assumptions -> no **_"this"_**
- All instances of a class share the same static varMem or method.
- Used by method that starts every java program, Ex: public static void main

__________


## Final Modifier

```java
final double PI = 3.14;

final int MAX_NUMBER_OF_SEATS = 10;
```

- Constant Variable Value with all Capitals
- Used to declare a variable as a "constant"
- Affects the variable/ reference only
- Object reference can be final - but doesn't affect instance variables
- Collections can be final - but doesn't affect containing elements
- Benefit - runtime optimization
- Benefit - programming best practice

________

## Nested Classes

##### Types of Nested Classes

- Local Classes
- Inner Classes
- Static Inner Class
- Anonymous Class

### Local Class

- The normal class or functions inside the main is called local scope

```java
public  static void main(String[] args){
    class Car {
        int seats;
    }
    
    Car ferrari = new Car();
    ferrari.seats = 2;
}
```


### Inner Class

- if there is a class inside a class
- This Class is dependent on the parent class.
- The inner class exists only after parent class instance is declared.

- The Wheel instance is associated with the particular Car instance. 
```java
class Car{
    class Wheel{
        
    }
}

Car audi = new Car();

// AudiWheel is associated with Audi car.
Car.Wheel audiWheel = audi.new Wheel();
```


### Static Inner Class

- It is Static Class inside a class.
- This Static Class is accessible without dependent parent class instance.

- The Wheel instance is not associated with any car instance.
- It is independent of car instances.
```java
class Car{
    static class Wheel{
        
    }
}

Car audi = new Car();

//Premium Wheel here is a static wheel which is of Wheel Class in Car Class but is not associated with any particular car instance.
Car.Wheel premiumWheel = new Car.Wheel();
```


### Anonymous Inner Class

- These are the inner classes defined inside a class to modify or update a portion of that class.
- This uses Inheritance Concepts.


```java
Class Car{
    private int seats;
    
    public boolean isTwoSeater(){
        return seats == 2;
    }
}

Car audi = new Car() {
    // Anonymous inner Class
    public boolean isTwoSeater() {
        return seats >= 2;
    }
}
```


##### Local Class - Variable scope - Interview Question

1. What needs to happen for an outer variable to be accessed in a local inner class?
   - The outer variable need to be final / effectively final.(Should not be modified).


2. Can we use the variable from main scope inside the local class?
- Yes
```java
public static void main(String[] args){
    int i = 10;
    
    class Foo{
        int x = i;
    }
}
```

- No
- Any variable which is changing in the scope cannot be used in the local inner class.

```java
public static void main(String[] args){
    int i = 10;
    
    class Foo{
        int x = i;
    }

    i = 20;
}
```

________






