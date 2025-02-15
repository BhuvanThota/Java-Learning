
## Inheritance

- Allows generic classes to define traits common to a set of related classes

```java
// Parent Class / Super Class
class A{
    
}

// Child Class / Sub-Class
class B extends A{
    
}
```
_______

#### Access Modifier Grid

| Modifier    | Class | Package | SubClass | All else |
|-------------|-------|---------|----------|----------|
| public      | Y     | Y       | **Y**    | Y        |
| protected   | Y     | Y       | **Y**    | N        |
| no modifier | Y     | Y       | **N**    | N        |
| private     | Y     | N       | **N**    | N        |

_______

#### Variable name same as the Super class

```java
class A{
    public String m;
}

class B extends A{
    public int m;
}
```

- This situation have variable shadowing, so we use "super" keyword.

```java
class A{
    public String m;
}

class B extends A{
    public int m;

    public void printValue() {
        this.m = 10;
        System.out.println(m);
    }
    
    public void printSuperClassValue(){
        super.m = "Hello";
        System.out.println(super.m);
    }
}
```

_______

#### Method Override

```java
class A{
    public String findName(){
        // method body
    }
}

class B extends A{
    public String findName(){
        // modified method - this is method override
    }
}
```

- When we override a method we cannot make it weaker. But we can make it strong or open
-  protected -> public => works
- public -> private => Does not work - error


```java
class A{
    public String findName(){
        // method body
    }
}

class B extends A{
    @Override 
    public String findName(){
        // modified method - this is method override
    }
}
```

- "@Override" helps the compiler identifies super method or show error if there is a mistake.
- Good developer practice.

_______


## Encapsulation Revisited with Inheritance

```java
public class Car{
    private int seats;
    
    public void run(){
        // can access seats here
    }
}

public class SportsCar extends Car{
    
    //public void run(){
    //  can access seats using the run method from super
    // }
}
```

##### But can we access the seats if we override the run method
- NO

```java
public class Car{
    private int seats;
    
    public void run(){
        // can access seats here
    }
}

public class SportsCar extends Car{

    @Override
    public void run(){
      // canNOT access seats here.
     }
}
```

##### For this problem we have "getters & setters" for the private variables


```java
public class Car{
    private int seats;
    
    public int getSeats(){
        return seats;
    }
    
    public void setSeats(int seats){
        this.seats = seats;
    }
    
    public void run(){
        // can access seats here
    }
    
}

public class SportsCar extends Car{
    
    @Override
    public void run(){
        // cannot access seats
        // Can access getters and seaters - coz they are public methods
     }
}
```

_____________


## Constructor calls with inheritance

```java
class A {
    public A() {
        System.out.println("A's constructor called!");
    }
}

class B {
    public B() {
        System.out.println("B's constructor called!");
    }
}

B myIns = new B();

```

#### Now when we create a B's instance like above which constructors are called and in which order?
- The Constructors from super to sub are called in order
- The "super constructor" with no-arg is called automatically.
- So here first A() constructor is called then B() constructor is called.

```java
class A {
    public A(int i) {
        System.out.println("A's constructor called!"+ i);
    }
}

class B {
    public B(int i) {
        super(i) // need to explicitly called.
        System.out.println("B's constructor called!"+ i);
    }
}

int i = 10;
B myIns = new B(i);

```


- Important is "super class" have "no no-arg constructor" only subclass constructor is called and super is missed
- If super class with args constructor need to be called then we call in "super(args)" in subclass constructor explicitly.

##### Construction call order
- Constructor calls are performed in the order of derivation/ extension.


_______

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
- When we use "abstract" before a class and then try creating a instance the system shows an error.

________

## Abstract Methods

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








