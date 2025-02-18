
## Class

- The class is an entity which holds data like state(variables) and behaviour(methods).

##### Ex Classes:

- Car
- Account
- Message
- Employee

##### Difference between Class and Object

| Class         | Object                        |
|---------------|-------------------------------|
| New Data Type | Variable / value of that type |

-  Class ------>>> is template for ------>>> Object
-  Class <<<------ is instance of <<<-------  Object
- Objects are referred to as instance or class instances


### Class Syntax

```java
// Definition
class ClassName{
    type memVar;
    type memVar;
    
    type methodName(parameters){
        //method body
    }
    
    type methodName(parameters){
        //method body
    }
}

// Instance -> Object
ClassName myObject = new ClassName();
```

##### Example of class

- The class name should be CapitalCamelCase
- The variables and methods need to be camelCase

```java
class Car{
    int seats;
    int wheels;
    double weight;
    doubt topSpeed;
}

Car myNewCar = new Car();
```
_______
## Summary - Class & Objects

- Classes are blueprints and Objects are instances
- Classes contain instance variables and methods
- A class definition forms a new type
- Object instances of class are values of the type (like a variable of type)
 

- To create a new instance using the "new" keyword
- The "new" keyword allocates memory for the object instance.
- The memory allocation happens at runtime
- Object variables are really reference variables.
- References can be changed by having them point to other instances.
_______


## Variable Shadowing

What is Variable Shadowing

```java
class Car{
    int seats;
    int wheels;
    double weight;
    double mileage;
    
    boolean canSeat(int seats){
        return seats >= seats;  
        // This is is Instance Variable Shadowing
    }
}
```
By having same name for the parameters as the instance variables causes the variable shadowing

- To solve we use "this"
- _seats_ refers to the method arg/ param
- _this.seats_ refers to the instance variable
```java
class Car{
    int seats;
    int wheels;
    double weight;
    double mileage;
    
    boolean canSeat(int seats){
        return this.seats >= seats;  
        
    }
}
```
_________


## Constructor

```java
class Car{
    int seats;
    int wheels;
    double weight;
    double mileage;
    
    Car() {  // This is a Constructor
        mileage = 0;
        wheels = 4;
    }
    
    boolean isFourSeater(){
        return seats == 4;
    }
    
    boolean canSeat(int seats){
        return this.seats >= seats;  
        
    }
}
```
- This helps us assign default values for the new instances on initializing.

##### Constructor Rules

- Same name as class
- No return type
- Can use access modifiers
- Can have multiple constructors (Constructor Overloading)

##### Constructor Overloading

- Constructor is used based on how we initialize objects using class.
- _"this();"_ To call the Car() for defaults.

```java
class Car{
    int seats;
    int wheels;
    double weight;
    double mileage;
    
    Car() {  // This is a Constructor
        mileage = 0;
        wheels = 4;
    }
    
    Car(int numberofSeats) { // This is a Constructor
        this(); // To call the Car() for defaults.
        seats = numberofSeats;
    }
    boolean isFourSeater(){
        return seats == 4;
    }
    
    boolean canSeat(int seats){
        return this.seats >= seats;  
        
    }
}

// Constructor is used based on how we call this class.
Car c1 = new Car(); 
Car c2 = new Car(5);
```

_______


## Summary - Call By Value vs Reference

- Java implements call by Value
- Any Value passed as parameters is copied to the method args
- If the arg is an object reference, the reference is copied
- The reference copy points to the same instance as the source object.

```java
class Car {
    int seats;
    int wheels;
    double weight;
    double mileage;

    Car() {  
        mileage = 0;
        wheels = 4;
    }

    Car(int numberofSeats) { 
        this(); 
        seats = numberofSeats;
    }
    
    boolean isHeavier(Car c){
        return this.weight > c.weight;
    }
}

Car audi = new Car();

// In This the value is copied to numberOfSeats
Car bmw = new Car(7); 

// In this audi reference of the car is passed to the Car c
boolean bmwHeavy = bmw.isHeavier(audi);
```

______










