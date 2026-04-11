## Bridge Pattern
- Def: Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies — abstraction and implementation — which can be developed independently of each other.

### Purpose
Decouples abstraction from implementation, allowing both to vary independently.

### Core Concepts
Uses encapsulation, composition, and inheritance. The main advantage is that changes in the abstraction (interface) won't affect the client, since the client interacts with the implementation of the interface.

### Emphasis
More emphasis on composition than inheritance. It extends beyond simple composition since the application is expected to change from both sides (both abstraction and implementation).

## Design Philosophy

The pattern is designed **upfront** to let abstraction and implementation vary independently, providing flexibility while implementing and creating both systems.

## Examples

### JDBC Example
The driver acts as a bridge, since you can pass any connection string and driver to the same `DriverManager.registerDriver()` method to connect to:
- MySQL
- PostgreSQL
- SQL Server
- H2
- And others

The client doesn't have to change unless the table and data changes.

### Printer/Formatter Example
You have a printer that can print different media types (movies, images, etc.) in multiple formats (HTML, XML, JSON):

```
Formatter: HTMLFormatter, JSONFormatter, etc.
Media: Movie, Image, etc.
Printer:
  - Media
  + print(Formatter) - calls formatter.format() and returns Media in the expected format
```

## Pitfalls

1. **Increases Complexity**: Adds complexity to the design
2. **Planning Challenges**: Difficult to plan since you're breaking code into interfaces, which requires careful thought
3. **Abstraction Confusion**: Can be confusing determining what goes where with so much hierarchies and variations on both sides (abstractions and implementations)

## Comparison with Other Patterns

### Bridge vs. Adapter
- **Bridge**: Designed upfront consciously; works with new code
- **Adapter**: Retrofitted after design; works with legacy code
- **Complexity**: Bridge is more complex
- **Functionality**: Bridge breaks functionality into pieces independently; Adapter wraps to make things work

**Key Difference**: Adapter works after the code is designed and is intended for legacy applications aka Retrofitted. Bridge is designed upfront for flexibility.

## Summary

Bridge provides flexibility, although it may be complex to implement. Use when you need independence between abstraction and implementation, particularly when changes are expected in both areas.