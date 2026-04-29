## Visitor Pattern
- Def: Visitor is a behavioral design pattern that lets you separate algorithms from the objects on which they operate.

### Overview
Visitor is a behavioral pattern that lets you add new operations to a group of related objects without modifying their classes by externalizing behavior into visitor classes. It separates algorithms from the objects they operate on, keeping the object structure stable while allowing behavior to be extended, which improves modularity and maintainability.

### Core Features

1. **Separation of Concerns**: Algorithms are separated from object structures. Logic lives in the Visitor, not in the original object. This way we externalize behavior into visitor classes.
2. **Open-Closed Principle**: Add new operations without modifying existing classes.
3. **Double Dispatch**: The method to execute is determined by both the type of the element and the type of the visitor, achieved through two method calls - first to the element's accept() method (which resolves element type), and then to the visitor's visit() method (which resolves correct operation).
4. **Extensibility**: Easy to add new visitors for new operations.
5. **Stability**: Object structure remains unchanged for new behaviors.
6. **Testability**: Visitor classes are easy to test since the logic is encapsulated. As new features adds on, there's less risk of breaking existing behavior/regressions, making testing more isolated and reliable.

Examples: Element and ElementVisitor interfaces in language processing.

### When to Use

Use the Visitor pattern when:
- You need to perform operations on objects / group of objects without modifying their classes.
- You anticipate frequent changes or new features and 
    - don't want to pollute classes with unrelated operations. Having too many features violates SRP and it's hard to maintain. eg. Calculate area, Render on screen, Export to JSON, Log details, etc.
    - don't know their specifics
- You cannot or should not modify existing object classes.
    - Base API cannot be changed after deployment.

### Implementation Details
Built around interfaces for both Visitor and Element.
Must be planned early since elements need to support visitors from the start.

- **Visitor Interface**: Defines visit methods for each element type supported.
- **Concrete Visitor**: Implements operations for each element type supported.
- **Element Interface**: Defines accept() method to allow visitors to operate on it.
- **Concrete Element**: Implements accept, calling visitor's appropriate method.
- Uses double dispatch: element.accept(visitor) calls visitor.visit(this).


## Visitor vs. Iterator Pattern (by Bryan Hansen)

| Aspect | Visitor Pattern | Iterator Pattern |
|--------|-----------------|------------------|
| **Purpose** | Externalizing operations without modifying objects | Traverse collections |
| **Focus** | Externalize behavior | Control navigation, not externalize behavior; Behavior is internal |
| **Extensibility** | Easy to add new visitors/operations, enabling new features on same object | Encapsulates traversal within the collection, typically with one iterator per collection. |
| **Implementation** | Interface-based with double dispatch | Interface-based implemented with anonymous inner class |
| **Usage** | Multiple operations on stable structure | Single traversal approach (can be birectional) |

**Key Differences:**
- Visitor externalizes operations; Iterator controls navigation, usually one internal traversal approach.
- Visitor for adding behaviors; Iterator for accessing elements.
- Both interface-based but serve different concerns.

## Visitor vs. Command Pattern

| Aspect | Visitor Pattern | Command Pattern |
|--------|-----------------|----------------|
| Purpose | Add operations without modifying objects | Encapsulate a request/action as an object |
| Focus | Externalize behavior across object types | Decouple invoker from action execution |
| Extensibility | Easy to add new visitors/operations | Easy to add new commands |
| Implementation | Interface-based with double dispatch | Interface-based with execute() method |
| Usage | Multiple operations on stable structure | Triggering actions, undo/redo, queues |

### Key Differences
- Visitor externalizes operations across multiple object types; Command encapsulates a single request or action.
- Visitor is used to add behaviors to a structure; Command is used to decouple invocation from execution.
- Visitor uses double dispatch for type-specific behavior; Command typically uses a single execute() call.
- Visitor operates on object structures; Command operates on receivers via invokers.

### Pitfalls

1. **Upfront Planning**: Requires designing for visitors from the start and forces to adapt it early. 
    - Adding visitor is easy, but adding element requires updating all visitors which want to handle it.
2. **Indirection & Overhead**: Behavior feels disconnected from objects; forces accept() method onto all elements, adding boilerplate (standard, repeated code) and cognitive overhead.
3. **Partial Implementation**: Visitors may not handle all element types, leading to incomplete or inconsistent behavior; this often forces the use of adapter or default implementations (empty body impl by visitor eg. `public void visit(Triangle t) {// 🤷 don't care}`) to fill the gaps, adding extra complexity.
4. **Complexity & Obscurity**: "Visitor isn't rare conceptually, but it's less commonly used. It can feel over-engineered and hard to understand, especially for teams unfamiliar with it; when misapplied, it adds unnecessary complexity instead of simplifying codebase.

### Summary

- Adds/externalizes functionality without changing existing classes.
- Useful when anticipating future changes (frequent or unknown specifics).
- Maintains original class contracts especially when it can't be changed, eg. base API after deployment.
- Adds complexity but follows OOP principles.
- New features are added without touching existing code, making it easier to test changes without risking regressions.