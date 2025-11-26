=== CONCEPTS ===
Why Use the State Pattern
- To localize state-specific behavior into its own objects
- Ensures the current state is stored in an object, not scattered across variables and conditionals
- Cleanly separates what state you are in from where you are in the application

Design Benefits
- Helps objects follow the Open–Closed Principle (OCP):
  - The main class is closed for modification
  - Individual state classes are open for extension
- Makes behavior changes at runtime more organized and maintainable

Examples
- No strong examples in core Java API
- Some argue the JSF lifecycle phases reflect the State pattern
- Others claim Iterator implementations use it because behavior changes at runtime — though this is generally considered a weak or inaccurate example

=== DESIGN ===
Structure

State interface or abstract class:
- Typically implemented as an abstract class to provide default behavior
- Useful because not every state needs to implement every method

Concrete State Classes:
- Each state is represented as its own class
- Encapsulates behavior specific to that particular state

Context (the main object):
- Holds a reference to the current state object
- Unaware of all possible states — unlike earlier approaches where the context knew every state and used conditionals
- Delegates state-specific behavior to the current state instance

UML Components
- Context
- State (abstract class or interface)
- Concrete States (one class per state)

=== PITFALLS ===
- Know your states clearly — poorly defined states cause inconsistencies and confusion
- More classes — the pattern increases class count compared to simple conditionals
- Logic leakage into the context — avoid putting conditional logic back into the context
- Unclear state-change triggers — be explicit about what causes transitions
- Copy-paste errors — similar state classes make mistakes easy

=== COMPARISON ===
State can be compared with the Strategy pattern as both use polymorphism for behavior.

State Pattern:
- Purpose: Encapsulate states and handle behavior changes based on the current state
- Structure:
  - Interface or abstract class defines the state behavior
  - Each state is its own class
- State awareness:
  - States typically know what state they can transition to next
  - This means one state can trigger transitions by telling the context what its next state is
- Behavior:
  - Behavior changes dynamically as the context moves from one state to another
- Use case:
  - When an object's behavior is determined by its internal state, and it must change at runtime

Strategy Pattern:
- Purpose: Encapsulate interchangeable algorithms or behaviors
- Structure:
  - Interface or abstract class defines the algorithm (strategy) behavior
  - Each strategy is its own class
- State awareness:
  - Strategies do not know about each other
  - No transitions exist between strategies
- Behavior:
  - The algorithm can be swapped out at runtime, but strategies do not coordinate or transition themselves
- Use case:
  - When you want to choose or swap algorithms without the algorithm objects needing to know anything about the bigger context

=== SUMMARY ===
Purpose
- Reduces cyclomatic complexity by removing nested if/else logic
- Makes adding new states easier and more structured

Trade-offs / Pitfalls
- Increases the total number of classes in a project
- Prone to copy-paste errors because state classes often resemble each other
- Requires careful identification of valid states and transitions

Relationship to Strategy Pattern
- Very similar in implementation (interface + multiple concrete classes)
- State pattern handles transitions between states
- Strategy pattern focuses on interchangeable algorithms with no knowledge of each other