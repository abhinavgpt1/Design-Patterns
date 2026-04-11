## Adapter Pattern
- Def: Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.
It is useful for integrating legacy code or third-party libraries into a new system.

### Purpose
Connects new code with legacy code without changing the original contract or interface produced by the legacy code.

### Note on Real-Life Analogy
Since India uses round-shaped sockets while American-made laptops have flat, vertical plugs, a plug adapter is a classic example of the Adapter Pattern - it enables compatibility between incompatible interfaces.

## Concepts

### When to Use
This pattern exists when the client wants to interact with an interface, but some part of the code/system is legacy that you don't want to or cannot change. 
It effectively translates the request from the client to the legacy code being adapted.

### Examples
- **Collection API**: Arrays (legacy) adapted to List (Collection Framework) through adapter methods
- **Streams**: Almost all I/O streams can interact with other streams or readers

## Design

### Structure
- Very client-centric; it helps integrate/adapt the client to legacy components.
- Often implemented as an interface but isn't necessarily required to be.
- The Adaptee can be an implementation as well.
- Just adapts (converts from one form to another) rather than adding additional functionality like Decorator.

### Implementation Note
Generally, an adapter fits between an interface and a concrete class. The adapter acts as a wrapper, and a new wrapper is created per instance.

## Pitfalls

- Not a lot, just don't overcomplicate adapters; Use adapters to make things work together, 
but if you're adding functionality to legacy code in the adapter, consider using Decorator or other structural patterns
- While a system typically has multiple adapters, this doesn't mean one adapter isn't valid

## Adapter vs. Bridge

| Aspect | Adapter | Bridge |
|--------|---------|--------|
| **Design Time** | Retrofitted after design; makes things work after they are designed | Designed upfront for flexibility |
| **Context** | Deals with legacy code and unrelated classes | Built in advance for continuous flexibility among interfaces and implementations |
| **Timing** | Used after the system is in existence | Planned from the beginning |
| **Adaptation** | Retrofitted to make unrelated classes work together | Provides a layer of abstraction upfront |

**Key Difference**: Both adapt multiple disparate/unrelated systems to work together, but at different stages of the design process.

## Summary

- Simple solution to a very specific/well-defined problem
- Easy to implement
- Integrates with legacy code that you don't want or can't change
- Can provide multiple adapters; developers generally implement one. However, when working with different legacy APIs, you might need multiple adapters.
