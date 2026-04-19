## Memento Pattern
- Def: Memento is a behavioral design pattern that lets you save and restore the previous state of an object without revealing its internal structure. It works like taking a snapshot of an object at a particular moment in time. This pattern is commonly used to implement undo and redo functionality in applications.

### Overview
The Memento pattern externalizes an object's internal state so it can be saved and restored later. It involves three key participants: the originator (the object being saved), the memento (the saved state), and the caretaker (manages the mementos).

### Core Features

1. **State Capture**: Saves the internal state of an object for later restoration.
2. **Encapsulation Preservation**: Maintains encapsulation by controlling access to saved state.
3. **Undo/Redo Support**: Enables rollback to previous states.
4. **Externalization**: Allows state to be stored externally without exposing internals.
5. **Memory Management**: Caretaker handles storage and cleanup of mementos.

Examples: 
- `java.util.Date` - internally represented by a long timestamp; restoring state is done by resetting this value.
- `java.io.Serializable` - allows an object's state to be fully saved and recreated — is a better example of Memento.

### When to Use

Use the Memento pattern when:
- You need to save and restore an object's state without exposing its internals. 
    - Same as saying you want to implement checkpoints or snapshots of object state.
- Undo/rollback functionality is required.
- You want to manage state history without cluttering the originator with state management logic.

### Implementation Details
- **Originator**: The object whose state we want to save or restore. Can create mementos containing its current state. Can restore from a memento.
- **Memento**: Stores the internal state of the originator, so that it can be restored later; acts as a snapshot.
- **Caretaker**: Stores and manages mementos; doesn't inspect or modify them. Think of it as the Undo option of an application.
- Mementos are opaque to the caretaker; only the originator can access the state.
- Common state storage way is serialization.
- Caretaker decides retention policy for mementos.

## Memento vs. Command Pattern

| Aspect | Memento Pattern | Command Pattern |
|--------|-----------------|-----------------|
| **Focus** | Captures object state | Captures requests/actions as objects |
| **History** | Independent snapshots of state | Independent operations |
| **Usage** | Designed to manage history via rollback/restore | Designed for executing actions; undo/redo is good to have but state management isn't the prime focus |
| **State Management** | Explicit state snapshots | May include state for undo |
| **Encapsulation** | Protects internal state | Encapsulates actions |

**Key Differences:**
- Memento captures state for history; Command captures actions.
- Memento emphasizes state restoration; Command emphasizes action execution.
- Both can support undo, but Memento is more direct for state-based undo.

### Pitfalls

1. **Memory Overhead**: Storing large or many mementos can be expensive.
    - Mitigation: limit history size, store diffs instead of full snapshots, or compress snapshots.
2. **Performance**: Frequent state capture can impact performance.
    - Mitigation: capture state at meaningful checkpoints (batching), or use incremental/delta mementos.
3. **Memory Leaks**: Poor cleanup of old mementos by caretaker can lead to memory leaks. Requires clear cleanup policy.
    - Mitigation: enforce policies like fixed-size history, time-based eviction, or explicit pruning.
4. **Encapsulation Risks**: Memento must not expose state inappropriately. State should be transferred into the memento only, and not accessible to external objects.
    - Mitigation: make mementos immutable and restrict access (e.g., inner/private classes).

### Summary

- Captures and restores object state without violating encapsulation aka without exposing internal implementation.
- Enables undo/rollback by saving snapshots.
- Requires careful memory management due to potential overhead and memory leaks.
- Similar to Command pattern - both can support history. To implement undo with commands, you often need memento-like state capture.
- Powerful for state restoration but costly if not managed well.