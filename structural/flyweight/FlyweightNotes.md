## Flyweight Pattern
- Def: The Flyweight pattern is a structural design pattern that minimizes memory usage by sharing common data ("intrinsic state") among many similar objects, rather than storing redundant data in each one.
By reusing existing objects, it improves performance and memory efficiency.

## Overview
An optimization pattern used to fit more objects in RAM. Applicable when there are a large number of similar (immutable) objects. Instead of storing a new instance for every occurrence, reference a unique object.

### Examples in Java
- `java.lang.String` (string literal pool)
- `Integer.valueOf()` function : stores value in cache for certain range, hence Integer i=10; Integer j=10; share common memory location. Whereas, it isn't true for i=200;
- Other wrapper classes (Character, Boolean, Short)

## Extrinsic and Intrinsic Properties

### Intrinsic Properties
- Common properties shared across multiple instances
- Example: bullets in a gun, Samsung WH-CH710N headphones in shopping orders

### Extrinsic Properties
- Uncommon properties that distinguish individual objects

## Implementation Hint
If you see caching, Flyweight pattern might be applicable
- Both aim to reuse existing objects instead of creating new ones repeatedly.

## Pattern Within Patterns
Flyweight utilizes a Factory to retrieve flyweight objects after they've been created, encompassing the creational pattern inside a structural pattern.

## Pitfalls

- **Complexity**: Some complication in implementation and moving parts
- **Premature Optimization**: Optimization is not always needed, but you do it anyway
- **Pattern Understanding**: Must understand the Factory pattern (identify factory vs. flyweight objects)
- **Non-Graphical**: Usually it's taught using graphical examples, but it's not limited to graphics and UI-related problems. Some non-graphical examples:
    - String Pool in Java: Reuses identical string objects
    - Caching user roles / configurations: Same roles reused across users
    - Database connection pools: Reusing connections instead of creating new ones. FYI, connection.close() in connection pool doesn't close the connection, but marks it as available for reuse.