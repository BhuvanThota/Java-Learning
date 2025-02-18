
## Exception Handling

- try - catch block is the basic block to handle the exceptions

```java
// try - catch syntax
try{
    // Risky code    
} catch (Exception error){
    // Handle error
} finally {
    // Wrap up/ clean up
}
```
_________

### Multiple Exception 

- Exception - Super class
- ArithmeticException - child class of Exception

```java
// try - catch syntax
try{
    // Risky code    
} catch (ArithmeticException error){
    // Handle error
} catch (Exception e){
    // Handle Error
}finally {
    // Wrap up/ clean up
}
```
__________

### Throw Keyword

```java
// try - catch syntax
try{
    // Risky code    
} catch (ArithmeticException error){
    // Handle error
    throw new ArithmeticException("You passed zero for the denum");    
} catch (Exception e){
    // Handle Error
}finally {
    // Wrap up/ clean up
}
```

___________

### Exception Types

- Throwable - It have child types
  1. Exception
  2. Error -> No need to write try catch -> Need to solve it

-  Exception - It have many child types 
  1. RuntimeException -> No need to write for try catch - Need to solve it
  2. ArithmaticException  

________


### Custom RuntimeException


```java
public class CustomRuntimeException extends RuntimeException{
    
}

public void run(){
    throw new CustomRuntimeException();
}
```

___________

## Exception Handling Best Practices - Summary

- Do not use generic catch-all exception. Be as specific as you can
- Use exception chaining to make handling consistent. (Use case: Have all the exceptions from your package into CustomException. Let the developer know the exceptions are from one package instead of generic exception message. This helps in debugging.)
- Pay attention to the exception order in your catch blocks (IDEs can help)
- Use checked exceptions whenever you can work around the issue
- Make sure you clean up resources with finally or try with resource


- try with resource block
```java
String query = "select * from EMPLOYEES";

// try with resource for clean - up
try(Statement stmt = con.createStatement()) {
    // Risky Code
} catch (SQLException e) {
    // Handle error    
}
```

_________







