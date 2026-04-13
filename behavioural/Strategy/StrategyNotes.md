=== CONCEPTS ===
When to Use the Strategy Pattern
- When you want to eliminate conditional logic (if/else, switch) tied to algorithm selection
- When adding new algorithm variations is difficult under the current design
- When the client is expected to choose the algorithm/strategy at runtime

What the Strategy Pattern Does
- Encapsulates algorithm options into separate, dedicated classes
- Removes algorithm-selection logic from the main application flow
- Promotes cleaner, extensible code by isolating variations

Client's Role
- The client is aware of available strategies
- The client explicitly selects and provides the strategy to use

Java Example
- java.util.Comparator is a key example
- Used to apply different comparison strategies when sorting collections

=== DESIGN ===
Design Structure
- Strategy is typically defined using an interface, but often implemented with an abstract base class for shared behavior
- Each algorithm variant is implemented as a separate concrete strategy class
- Every concrete strategy contains its own unique algorithm implementation

Key Intent
- Minimize—or ideally eliminate—if/else conditional logic when selecting or executing different algorithms
- Move algorithm selection outside the core application logic

Knowledge & Independence
- The client is aware of the available strategies and selects which one to use
- Strategies operate independently and do not need to know about each other

UML Components
- Context – the object that uses a strategy
- Strategy Interface – defines the algorithm contract
- Concrete Strategy Classes – implement different versions of the algorithm

=== PITFALLS ===
Design & Architecture
- Strategy selection can shift conditional complexity to the client, and over-engineering is common when only a few algorithm variations exist

Correctness & Safety
- Choosing the wrong strategy is easy because there's no compile-time enforcement, causing subtle runtime errors

Usability & Lifecycle
- Clients must manage creation and lifecycle of strategy objects, which can lead to misuse or unnecessary object churn

Maintenance & Scalability
- Large sets of strategies hurt discoverability and require discipline to avoid duplicated logic or diverging implementations

Cross-Strategy Coordination
- Because strategies don't know about each other, scenarios needing shared or coordinated behavior become awkward or unsupported

Performance
- Interface indirection and excessive strategy instantiation can introduce small but notable runtime performance costs

Team & Code Quality
- Maintaining consistency across strategy implementations requires strong team discipline to prevent logic drift or accidental re-introduction of conditionals

=== COMPARISON ===
Strategy can be compared with the State pattern as both use polymorphism for behavior.

Purpose:
- Strategy: Focuses on choosing between interchangeable algorithms
- State: Focuses on representing and transitioning between object states

Behavior:
- Strategy: Algorithms are independent and do not know about each other
- State: Each state knows which state it can transition to next

Structure:
- Strategy: Interface (or abstract base) with one class per algorithm
- State: Interface with one class per state

Client Involvement:
- Strategy: Client chooses which strategy to use
- State: Context transitions automatically based on state logic

=== SUMMARY ===
Core Purpose
- Externalizes algorithms so behavior varies without changing the main application

Client Role
- Client must know and choose the correct strategy (e.g., selecting the right credit-card processor)

Structure
- One class per strategy, each implementing a specific algorithm

Main Benefit
- Eliminates conditional logic, removing nested if/else blocks from the core code

Testability
- Each strategy is isolated, making individual algorithms easy to test

Clean Design
- Keeps the main method simple and readable, shifting branching logic to separate classes