# Behavioral Design Patterns
- Def: Behavioral design patterns define how objects communicate and collaborate to manage responsibilities effectively. They improve flexibility and simplify complex control flows within a system.

There are 11 behavioral design patterns in total:

1. **Chain of Responsibility**
   - Pass requests along a chain of handlers until one handles it.
   - Supports loose coupling between sender and receiver by allowing multiple handlers to process a request.
2. **Command**
   - Encapsulate requests as objects to enable undo/redo and queuing.
   - Separates the invoker from the receiver and makes it easy to add logging, retries, or transactional behavior.
3. **Interpreter**
   - Define a grammar and interpret sentences in that language.
   - Useful for parsing expressions or domain-specific languages when the grammar is simple and extensible.
4. **Iterator**
   - Traverse a collection without exposing its internal structure.
   - Provides a common way to access elements sequentially while keeping the collection implementation hidden.
5. **Mediator**
   - Centralize complex communications between objects through a mediator.
   - Reduces dependencies between cooperating objects and simplifies maintenance of interaction logic.
6. **Memento**
   - Capture and restore an object's state without violating encapsulation.
   - Enables rollback or undo operations by keeping snapshots of internal state.
7. **Observer**
   - Notify multiple objects when one object's state changes.
   - Decouples the subject from its observers and supports event-driven architectures.
8. **State**
   - Change an object's behavior when its internal state changes.
   - Encapsulates state-specific behavior and avoids large conditional statements.
9. **Strategy**
   - Encapsulate interchangeable algorithms and select one at runtime.
   - Makes algorithm selection flexible and promotes reusable, pluggable behavior.
10. **Template Method**
   - Define an algorithm skeleton, letting subclasses override specific steps.
   - Ensures consistent overall flow while allowing subclasses to customize individual steps.
11. **Visitor**
   - Add new operations to objects without modifying their classes.
   - Externalizes behavior from object structures and supports multiple operations over a stable object model. 