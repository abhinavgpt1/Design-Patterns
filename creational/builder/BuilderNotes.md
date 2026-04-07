## Builder Pattern
- Def: Builder is a creational design pattern that lets you construct complex objects step by step (often immutable once constructed).
The pattern allows you to produce different types and representations of an object using the same construction code.

### Overview
A creational pattern for constructing objects with many parameters, making them immutable once constructed.

### Example
`StringBuilder` is a built-in Java implementation of this pattern.

## When to Use

- **Complex Constructors**: Handles complex constructors with many parameters
- **Large Parameter Sets**: When many parameters are required
- **Immutability**: When you want to create immutable, customizable instances

## Problem It Solves

The creation of multiple constructors with each parameter variation is called **telescoping constructor pattern**. 
The Builder pattern solves this by handling object construction through a builder object than with parameters.

#### Note: Both approaches - Bean class and Telescope class are not ideal ways to achieve immutable and customizable object. Depending upon situation, such approaches are implemented as well as Builder pattern.

### Builder Pattern Benefits
- Typically written with a static inner class
- Negates the need for exposed setters

## Pitfalls

1. **Immutable Class Generation**: An immutable class is generated every time

2. **Static Inner Class Issues**: Static inner class can cause issues when the same builder is used again (stale data from previous use)
   - INC (Immediately Nested Classes) could solve this but increases code and breaks the pattern.
      - To create builder class instance, you'll have to create a lunchOrder instance with no args which doesn't look nice/clean. The lunchOrder should be created in a single statement ideally.

3. **Attention while designing**: They are designed first and not refactored like Prototype patten.

4. **Implementation Complexity & Reference Returns**: Adds complexity compared to a simple constructor. Also, due to chaining of reference returns (which generally doesn't happen in object initialisation eg. new LunchOrder();), complexity of implementation increases.

## Builder vs. Prototype Pattern

| Aspect | Builder | Prototype |
|--------|---------|----------|
| **Purpose** | Handles complex constructors | Avoids costly constructor calls |
| **Interface** | No interface (can be implemented with one) | Focuses on clone method interface |
| **Implementation**  [IMP] | Builder class can be separate class or inner class | Clone method is focused around member variables and constructor, hence it is inside the class it clones |
| **Legacy Code** | Easy to integrate with legacy code (if implementation is in separate class) | Difficult to implement in legacy code |
| **Constructor** | Calls the constructor | Avoids the constructor |

**Key Difference**: Builder calls the complex constructor; Prototype avoids it entirely.

## Summary

- Creative way to deal with constructor complexity
- Easy to implement
- Very few drawbacks
- Can be refactored to a separate class (no need for static inner class)