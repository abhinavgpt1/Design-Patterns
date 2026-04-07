[Def, GFG] A design pattern systematically names, motivates, and explains a general design that addresses a recurring design problem in object-oriented systems.

[Def, GoF] Design Patterns are:
- Descriptions of communicating objects and classes that are customized to solve a general design problem in a particular context.
- A design pattern names, abstracts, and identifies the key aspects of a common design structure that make it useful for creating reusable object-oriented designs.


The Gang of Four (GoF) has organized design patterns into three groups: Creational, Structural, and Behavioral.

## Creational Patterns
[Def, Baeldung] Creational design patterns are concerned with the way in which objects are created.

[GoF] Creational design patterns:
    - Abstract the instantiation process.
    - Help make a system independent of how its objects are created, composed, and represented.
    - Use inheritance (class creational patterns) to vary the instantiated class, or delegate instantiation to another object (object creational patterns).

### Creational Patterns List
1. Singleton
2. Builder
3. Prototype
4. Factory Method
5. Abstract Factory

## Structural Patterns
[Def, RefactoringGuru] Structural design patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.

[Def, GoF] Structural patterns are concerned with how classes and objects are composed to form larger structures.

These patterns are used for improving performance, refactoring, and memory utilization.

### Structural Patterns List
1. Adapter
2. Bridge
3. Composite
4. Decorator
5. Facade
6. Flyweight
7. Proxy

**Reference:** Association vs. Aggregation vs. Composition
- https://stackoverflow.com/questions/21967841/aggregation-vs-composition-vs-association-vs-direct-association



## Resources

- **Pluralsight: Design Patterns in Java - Creational** by Bryan Hansen
  - https://app.pluralsight.com/library/courses/design-patterns-java-creational/table-of-contents

- **Pluralsight: Design Patterns in Java - Structural** by Bryan Hansen
  - https://app.pluralsight.com/library/courses/design-patterns-java-structural/table-of-contents

- **Medium: Factory Method Design Pattern** by Prasad CT (with real-world examples)
  - https://prasadct.medium.com/factory-method-design-patternfactory-method-design-pattern-with-real-world-example-4ee909a24ab6

- **Refactoring Guru** - Design Patterns Explained Quality Blog Posts

- **Binary Symphony** - YouTube Channel with Design Pattern Tutorials


## Useful Commands

To delete all `.class` files:
```bash
del /S *.class
```