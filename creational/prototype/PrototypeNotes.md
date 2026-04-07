## Prototype Pattern
- Def: The Prototype pattern is a creational design pattern that creates new objects by cloning an existing instance (the prototype) rather than creating from scratch. 
It is used when creating objects is time-consuming or resource-intensive, thus improving performance and efficiency.

### Overview
Uses a `clone()` method to get a new instance of a prototype object.

## Core Features

1. **Avoid Costly Creation**: Avoids expensive object creation (unlike the need for a Singleton)
2. **No Subclassing**: i.e. the prototype object is used within the class itself to create new instances
3. **Avoid `new` Keyword**: Don't use the `new` keyword (the first instance still requires it)
4. **Interface-Based**: Using interface ensures that the objects created adhere to consistent shape and contract.
5. **Registry Pattern**: Implemented with a registry; the first created object is kept in the registry, and all new instances are created using this instance from registry via cloning

## When to Use

When an object is expensive to create, but you can get a new instance by copying the member variables, the Prototype pattern is the way to go.

**In essence:** Redefine what the `new` keyword means.

### Implementation Details
- Class contains `clone()` and inherits `Cloneable`
- Avoid the `new` keyword; clone creates a copy that is a unique instance
- Doesn't address costly construction directly (opposite to Builder)
- Can use parameters during construction
- Designer chooses between Shallow vs. Deep copy

## Singleton vs. Builder vs. Prototype

- **Singleton**: Creates and returns the same instance
- **Builder**: Provides a new instance via complex construction
- **Prototype**: Provides a new instance by copying member variables

## Pitfalls

1. **Unclear Usage**: Sometimes unclear when to use Prototype; Singleton is misused instead

2. **Used with Other Patterns**: Often used with other patterns like Registry

3. **Deep Copy Complexity**: Deep copy requires more work; people may overlook it for shallow copy

4. **Default Values and Security**:
   - Defaults may exist for all instances since the original is set with defaults
   - Must take care of sensitive information across instances
   - Can mitigate with deep copy or by setting sensitive info to null after instantiation

## Prototype vs. Factory

| Aspect | Prototype | Factory |
|--------|-----------|----------|
| **Construction** | Light-weight (uses clone, not constructor calls) | Flexible (multiple constructors via new) |
| **Copy Type** | Shallow or deep copy | Fresh instance creation |
| **Customization** | Copy then customize with setters | Created with specific parameters (no default instance field values generally, but no restriction as well) |

**Key Difference:** Prototype creates through copying; Factory creates fresh instances.

## Summary

- Guarantee unique instances every time
- Often refactored later
- Helps solve performance issues in applications
- Avoids heavyweight creation by using the `new` keyword and helps gather objects quickly
- Don't jump to Factory as Prototype may solve the problem easily