## Factory Method Pattern
- Def: The Factory Method is a creational design pattern that defines an interface for creating objects but lets subclasses decide which object to instantiate. It encapsulates object creation logic, promoting loose coupling by eliminating the need to specify concrete classes in the main code, and delegating object creation to a method, making the system more flexible and extensible.

### Overview
The second most used design pattern (after Singleton). Opposite of Singleton in that it returns different instances, not the same instance.

## Core Concepts

### 1. Abstraction of Instantiation Logic
- Doesn't expose instantiation logic; the client doesn't know the type of object being created
- Defers creation logic to subclasses
- Client knows only about the common interface that the factory exposes

### 2. Factory Architecture
- Specified by architecture but implemented by subclasses/concrete classes

### Examples
- `java.util.Calendar`
- `java.util.ResourceBundle`
- `java.text.NumberFormat`

### Key Feature
Unlike Singleton, the factory can return different instances of different types.

## Design

1. **Responsibility**: Factory is responsible for creating objects (at least the creation part)
2. **Common Interface**: Factory exposes a common interface to the client; internally, it may refer to concrete classes (hidden from client)
3. **Parameterized Create Method**: A parameter determines the concrete type to create
4. **Factory Method Pattern**: Factory has a factory method that provides an object based on the parameter passed
5. **Abstract Instantiation**: An abstract method in the base class is used to instantiate all concrete class objects; creation happens only in the factory method

## Example: Calendar
```java
Calendar cal = Calendar.getInstance();
// On printing, we discover it's java.util.GregorianCalendar
```

**Observation:** Since the return type is the base class, the properties of the concrete class are hidden. Therefore, this design pattern works only with fields of the base class.

## Pitfalls

1. **Increased Complexity**: More complex code and moving parts compared to other design patterns
2. **Misunderstanding Creation Logic**: Developers often fail to understand that creation doesn't occur in the factory itself but in the subclass of the type being created
3. **No Refactoring**: Objects created aren't refactored (unlike Prototype); they're decided at implementation time

## Singleton vs. Factory

| Aspect | Singleton | Factory |
|--------|-----------|----------|
| **Returns** | Same instance every time | Various instances of different types |
| **Constructors** | One no-arg constructor | Multiple constructors with parameters |
| **Interface** | No interface; no subclass | Interface/abstract class (contract-driven) |
| **Testability** | Difficult to unit test | Easy to unit test |
| **Adaptability** | Not adaptable to environment | Adaptable to different environments |
| **Framework Usage** | Not framework-friendly | Frameworks are built as Factory patterns |

## Summary

- Param-driven pattern
- Solves complex creation (Builder also does this, but Factory handles multiple types)
- A bit more complex and opposite of Singleton
- If Singleton doesn't fit your problem, try thinking problem as Factory