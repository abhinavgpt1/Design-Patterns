## Composite Pattern
- Def: The Composite Pattern is a structural design pattern that organizes objects into tree structures, enabling clients to treat individual and composite objects uniformly through a common interface.

### Overview
Used when a tree-like structure forms. This pattern is designed to treat individual components and groups of components (composites) the same way. The same operations work on individual items and collections.

### Core Idea
It's **not** about composition (has-a relationship) in the traditional sense — it's about hierarchical structures.

### Examples
- `java.awt.components` (GUI components)
- RESTful web services (GET operations)

## Tree Structure

The root of the tree starts with a component, which is either a leaf or a composite (containing objects).

### Key Difference: Leaf vs. Composite
- **Leaf**: Has operations that perform work
- **Composite**: Has the same operations but also knows about child components and delegates work to leaves

## UML Components

1. **Component**: The abstraction for all components (leaves and composites)
   - Declares the interface for objects in the composition
   - Declares methods that both leaves and composites implement

2. **Leaf**: Implements component methods

3. **Composite**: 
   - Implements component methods
   - Has additional operations to manipulate child objects
   - Delegates functionality to its children

### Example
`Map<String, String>` Combining all other map key-pairs is a way of "composing" objects into one and treating them as one. It resembles the Composite pattern though it is not a strict implementation.

## Contract Enforcement

We can enforce contract rules to components, leaves, and composites:
- Some operations only make sense in composites (e.g., adding/removing leaf nodes)
- Such operations should be restricted to composite only, not to leaf
   - eg. declare abstract methods in composite interface

## Pitfalls

1. **Oversimplification**: The pattern can oversimplify things, making it difficult to restrict operations in the hierarchical structure. Thus, we need to rely on runtime checks.
2. **Runtime Checks**: Everything is treated the same (the pattern's intent), but we need to rely on runtime checks for restrictions rather than compile-time safety
3. **Implementation Cost**: Can be costly in case of large composites or if implemented incorrectly

## Composite vs. Decorator

### Composite Pattern
- Tree structure with leaves and composites sharing the same interface
- Provides unity between objects in the hierarchy

### Decorator Pattern
- Contains another entity (composition)
- Modifies the contained entity's behavior by adding functionality
- The decorates the underlying entity, but not necessarily change

## Summary

- **Composite**: Generalizes the hierarchical structure
- **Decorator**: Adds behavior without modifying the underlying object
- **Key Distinction**: Composite != Composition
  - Composite deals with hierarchical structures
  - Composition is an object containing another object
- Can simplify things too much, requiring runtime checks
- Easier for clients to work with due to uniform interface