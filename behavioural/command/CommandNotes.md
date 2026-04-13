Concept:
Encapsulates each request as an object.
Helps manage complex business logic by keeping functionality modular instead of in one large file.
Each callback request becomes object-oriented, not just another method in a large class.
Decouples the sender from the processor, improving maintainability and flexibility.
Makes systems easier to grow and extend over time.
Often used to implement undo functionality — the entire request is inside the command object and can be rolled back.
Java examples:
    java.lang.Runnable implementations.
    javax.swing.Action implementations.

Design:
Different from other patterns — sometimes criticized for breaking OO principles because there’s an object per command (commands are verbs, objects usually aren’t).
This view has largely been relaxed over time.
Main contract: the Command interface.
    All actions/commands implement this interface.
    Simplest form has an execute() method where the action is performed.
    For undo functionality, can also include unexecute()/undo() (optional, not required by pattern).
Advanced implementations may use reflection to fully decouple the client from the receiver (using callbacks).
Most examples use a simpler version of the pattern.
Key UML components:
    Command
    Invoker
    ConcreteCommand

Features:
1. LOOSE COUPLING: Client doesn't directly call light.on() - goes through command
2. ENCAPSULATION: Command manages state and can handle undo functionality
3. FLEXIBILITY: Can easily add more command types without changing invoker
4. STATE MANAGEMENT: Commands can maintain state for complex operations
5. EXTENSIBILITY: Easy to add new commands without modifying existing code

Pitfalls:
Often combined with other patterns to be more mature.
    Not inherently bad, but requires more developer knowledge.
Common mistake: duplicating logic across multiple commands.
    Better approaches:
        Use the Composite Pattern to combine commands.
        Or use Chain of Responsibility Pattern to pass commands along.
Undo functionality:
    Use the Memento Pattern to handle state for undo.
Tracking objects / storing history:
    Use the Prototype Pattern to create copies of commands for lists or history.
Contrast with Strategy Pattern to decide when the Command Pattern is the right fit.

vs Strategy pattern:
Command Pattern
    One object per command/request.
    Encapsulates the what (the action to perform).
    Contains the entire action for one specific scenario.

Strategy Pattern
    One object per strategy.
    Encapsulates the how (the algorithm/approach).
    Focuses on swapping or varying algorithms, not actions.

Similarity:
    Both create objects for encapsulation.
    Structures look similar but have different focuses (action vs algorithm).

Summary:
    Highly used pattern (possibly second only to Singleton).
    Encapsulates each request as an object.
    Decouples sender from processor — a key reason to use it.
    Few drawbacks — mainly possible reliance on other patterns.
    Commonly used for undo functionality in applications.
    Leads into next topic: Interpreter Pattern for processing tasks.
