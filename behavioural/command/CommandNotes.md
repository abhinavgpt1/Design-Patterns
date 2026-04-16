## Command Pattern
- Def: The Command Design Pattern is a behavioral design pattern that encapsulates a request as an object that contains all information about the request, thereby decoupling the sender of the request from the receiver.
It turns a request (like pressing a remote button) into an object so it can be passed, stored, queued, or undone easily.

### Overview
The Command pattern turns a request into a stand-alone object that contains all information about the request. This transformation allows you to parameterize methods with different requests, delay or queue a request's execution, and support undoable operations (eg, command.undo()).

### Core Features

1. **Encapsulation of Requests**: Each request is encapsulated as an object, making functionality modular and object-oriented.
2. **Decoupling**: Decouples the sender (invoker) from the receiver (processor), improving maintainability and flexibility.
3. **Undo Functionality**: Often used to implement undo functionality, the entire request is stored in the command object, which can be rolled back.
4. **Extensibility**: Makes systems easier to grow and extend by allowing new commands without changing existing code.
5. **State Management**: Commands can maintain state for complex operations and undo functionality.

Examples: `java.lang.Runnable` implementations, `javax.swing.Action` implementations.

### When to Use

Use the Command pattern when:
- You need to parameterize objects with operations.
- You want to queue operations, execute them at different times, or support undo/redo.
- You need to decouple the invoker of an operation from the object that knows how to perform it.
- You want to re-apply all operations in case of a system crash by loading all logs of commands.
- You need to structure a system around high-level operations built on primitive operations.

### Implementation Details
- **Command Interface**: Defines the contract with an `execute()` method. May include `undo()` for reversibility.
- **Concrete Commands**: Implement the Command interface and encapsulate the receiver and the action.
- **Invoker**: Holds a command and calls its `execute()` method. May store commands for undo.
- **Receiver**: Knows how to perform the operations associated with carrying out a request.
- **Client**: Creates a ConcreteCommand and sets its receiver.
- Advanced implementations may use reflection API for full decoupling (using callbacks).
- Key UML components: Client, Invoker, Receiver, Command, ConcreteCommand.

### Features:
1. Loose Coupling: Invoker/Switch doesn't directly call light.on() - goes through command. The invoker being unaware of the receiver is intentional design, not a flaw.
2. Encapsulation: Command manages state and can handle undo functionality
3. Flexibility: Can easily add more command types without changing invoker
4. State Management: Commands can maintain state for complex operations
5. Extensibility: Easy to add new commands without modifying existing code

#### Note: This pattern is sometimes criticized for breaking OO principles because it treats object as a verb aka command/action, and not noun. Methods are verbs.

## Command vs. Strategy Pattern

| Aspect | Command Pattern | Strategy Pattern |
|--------|-----------------|------------------|
| **Focus** | Encapsulates the what (action to perform) | Encapsulates the how (algorithm/approach) |
| **Structure** | One object per command/request | One object per strategy |
| **Usage** | Contains entire action for one scenario | Focuses on swapping algorithms, not actions |
| **State** | Manages state for undo | May or may not manage state |
| **Invocation** | Invoked by invoker | Selected and executed by context |

**Key Differences:**
- Command encapsulates actions (verbs); Strategy encapsulates algorithms (methods). Both pattern encapsulate, but different things.
- Command is about queuing and undoing requests; Strategy is about selecting behavior.
- Both create objects for encapsulation, but with different intents.

### Pitfalls

1. **Effectiveness**: Often combined with other patterns (e.g., Composite, Memento) to be fully effective, requiring more developer knowledge.
2. **Logic Duplication**: Common mistake to duplicate logic across commands; use Composite or Chain of Responsibility to combine.
3. **Undo Implementation**: Requires additional patterns like Memento for state management in complex undo scenarios.
4. **History Tracking**: Use Prototype to create copies for command history lists.
5. **Command vs. Strategy**: Can be mistaken for Strategy pattern, need to understand when Command pattern is the right fit.
6. **Overengineering**: Can be overkill for simple operations, adding unnecessary abstraction compared to direct method calls.
7. **Class Explosion**: Each action becomes a separate command class, which can lead to many small classes and increased codebase complexity.
8. **Hidden Dependencies**: Commands may implicitly depend on external state or receivers, making side effects harder to detect.

### Summary

- Highly used pattern, possibly second only to Singleton.
- Encapsulates each request as an object for modularity (self-contained, independent of the caller, easy to add/replace, reusable).
- Decouples sender from processor, a key benefit.
- Few drawbacks, mainly reliance on other patterns for effectiveness.
- Commonly used for undo functionality in applications.
