# Structural Design Patterns
- Def: Structural design patterns explain how to assemble objects and classes into larger structures, while keeping these structures flexible and efficient.

There are 7 structural design patterns in total:

1. **Adapter**
   - Allows two incompatible interfaces to work together by converting the interface of one class into another interface that the client expects.
   - Enables integration of existing classes with new interfaces without modifying the original code.
2. **Bridge**
   - Decouples an abstraction from its implementation so that the two can vary independently.
   - Allows changing the implementation of an abstraction without affecting clients.
3. **Composite**
   - Composes objects into tree structures to represent part-whole hierarchies.
   - Lets clients treat individual objects and compositions of objects uniformly.
4. **Decorator**
   - Dynamically adds behavior to an object by wrapping it with another object.
   - Provides a flexible alternative to subclassing for extending functionality.
5. **Facade**
   - Provides a simplified interface to a complex subsystem.
   - Hides the internal complexity of the subsystem, making it easier to use.
6. **Flyweight**
   - Uses sharing to support large numbers of fine-grained objects efficiently.
   - Reduces memory usage by sharing common state among multiple objects.
7. **Proxy**
   - Provides a surrogate or placeholder for another object to control access to it.
   - Useful for lazy initialization, access control, logging, or caching.