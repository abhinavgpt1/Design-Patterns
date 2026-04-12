# Creational Design Patterns
- Def: Creational design patterns focus on object creation, providing flexibility in what, who, and how objects are created while hiding class details and instantiation processes.

There are 5 creational design patterns in total:

1. **Abstract Factory**
   - Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
   - Useful for creating product families that are used together, ensuring consistency across platforms.

2. **Builder**
   - Provides a way to create complex (immutable) objects with different representations using the same construction code.
   - Ideal for constructing complex objects step-by-step, especially when the object has many optional parameters.

3. **Factory Method**
   - Defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.
   - Promotes loose coupling by eliminating the need to bind application-specific classes into the code.

4. **Prototype**
   - Efficient for creating objects when instantiation is expensive or when you need to avoid subclasses by cloning existing instance / prototype.

5. **Singleton**
   - Ensures a class only has one instance, and provides a global point of access to it.
   - Useful for managing shared resources like database connections or configuration settings.