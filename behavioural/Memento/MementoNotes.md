=== CONCEPTS ===
When to Use
- You need to restore an object to a previous state
- Commonly used for undo/rollback functionality in applications

Key Idea
- Externalize the object's internal state so it can be restored later
- Must do this without violating encapsulation

Benefits
- Supports undo/rollback mechanisms cleanly
- Shields complex internals from other objects
- Maintains encapsulation by controlling who can access saved state

Examples (Java)
- java.util.Date → internally represented by a long timestamp; restoring state is done by resetting this value
- java.io.Serializable → allows an object's state to be fully saved and recreated—serves as a better example of the memento concept

=== DESIGN ===
Class-Based Design
- Pattern consists of three main roles:

1. Originator
- The object whose state we want to save or restore
- Responsible for creating mementos that capture its internal state

2. Caretaker
- Manages stored mementos (e.g., keeps a list/history)
- Think of it like the Undo menu in an application
- Does not inspect the contents of a memento

3. Memento
- Represents the saved state of the originator
- Stores a "magic cookie" → a collection of the specific fields needed to recreate the originator's state
- Not a literal object but a concept describing encapsulated state data

UML Structure
- Contains three components: Originator, Caretaker, Memento
- Originator ↔ Memento handle state
- Caretaker stores Mementos but doesn't modify them

=== PITFALLS ===
Potentially expensive
- Mementos may contain large copies of originator state
- Storing many mementos can have high memory and performance overhead

Caretaker memory management
- Caretaker must decide how many mementos to keep
- Poor cleanup can lead to memory leaks
- Requires clear strategy for deleting old history

Encapsulation risk
- Must ensure originator state is not exposed through the memento
- State should be transferred into the memento only, not accessible to external objects

=== COMPARISON ===
Memento can be compared with the Command pattern for implementing history.

Memento Pattern:
- Captures state of an object
- Each memento = an independent snapshot of state
- Designed to build history (managed by the caretaker)
- Enables rollback/restore functionality

Command Pattern:
- Captures requests, not state
- Each command = an independent operation to be executed
- Can support history, but many implementations don't emphasize it
- Typically focuses on encapsulating an action, not preserving past object states

Core Contrast:
- Memento → history of state
- Command → history of actions (optional)
- Command can maintain history since all pieces exist, but it's not the usual emphasis

=== SUMMARY ===
Purpose
- Captures the state of an object at a specific point in time
- Allows restoring or recreating the object from that saved state

Key Strength
- Enables accurate rollback to any saved moment
- Useful for undo/restore scenarios

Potential Cost
- Capturing many states can be heavy in memory
- Large or frequent mementos can lead to memory leaks if not managed carefully

Relation to Command Pattern
- Similar in concept—both can support history
- Command focuses on actions/operations, not state
- To implement undo with commands, you often need memento-like state capture

Overall
- Powerful for state restoration, but requires careful memory management