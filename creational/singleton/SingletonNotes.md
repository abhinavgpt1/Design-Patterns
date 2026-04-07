## Singleton
- Def: Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

### Variants
- Eagerly Loaded
- Lazily Loaded
- Lazily Loaded with Thread Safety

## Singleton vs. Factory Pattern

### Singleton
- Returns the same instance every time
- Single constructor method with no arguments (private constructor for restricted access)
- No interface for returning custom objects
- Difficult to unit test (introduces global state)
- Creates a global dependency, complicating replacement or dependency injection
- Not every class in an application needs to be a Singleton; Factory can be a better alternative

### Factory
- Returns different instances of various types
- Has multiple constructors
- Interface-driven (abstracts backend implementation and returned objects)
- Easy to unit test
- Adaptable to different environments (unlike Singleton)

## Summary
- Use Singleton when you need to guarantee only one instance
- Easy to implement and make thread-safe
- Solves the single-instance problem but is often overused in applications
- Not everything needs to be a Singleton; understand the differences with the Factory pattern
- Helpful for memory utilization

### Implementation Considerations
- Use a static instance variable
- Consider the `volatile` keyword for thread safety
- Be aware of reflection API issues
- Use static synchronization when needed
- Consider the cleaner solution with static inner classes (loads once per lifetime)
  Reference: https://www.geeksforgeeks.org/singleton-design-pattern/