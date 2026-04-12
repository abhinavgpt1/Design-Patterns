## Decorator Pattern
- Def: Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

#### Ref: https://refactoring.guru/design-patterns/decorator

## Overview
A hierarchical pattern that builds functionality at each level using composition.

## Purpose
Wraps an object to add functionality to it without affecting other objects.

## When to Use
- More sophisticated than simple inheritance
- Follows the Single Responsibility Principle
- When you want behavior dynamically added to an existing class. It may feel like a creational / behavioral pattern but it isn't as it adds a structure/wrapper (having behavior through creation).

## Design
- Uses both inheritance and composition (is-a, has-a relationships)

- Acts as an alternative to subclassing
- Constructor requires an instance from the hierarchy
    - Enables composition over inheritance such that fields/methods can be accessed/overridden

## Implementation
- A new class is needed for every feature added
- Decorator avoids subclass explosion by promoting implementing decorator interfaces rather than extending concrete class. 
    - Side effect: increases small & specialized decorator classes
- Often confused with simple inheritance

## Challenges
- Tough to remove decorations between layers
- Examples: `java.io.InputStream`

## Summary
Decorator provides a flexible alternative to subclassing, allowing dynamic behavior addition through composition.