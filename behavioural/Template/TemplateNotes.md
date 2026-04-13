=== CONCEPTS ===
- The template method pattern is chosen primarily for code reuse.
- It is commonly used in framework and library design.
- The pattern existed long before Inversion of Control (IoC) frameworks.
- IoC containers use this pattern to support pluggable components.
- IoC frameworks helped keep the template method pattern mainstream.
- The pattern focuses on defining and controlling the overall algorithm.
- It allows the algorithm structure to be fixed while letting users customize specific steps.
- The pattern enforces an algorithm but lets users override parts of it.
- A Java example is java.util.Collection#sort, where the sorting algorithm is fixed but behavior can be customized.
- Unlike Strategy, Strategy swaps the whole comparator, while Template focuses on overriding steps within the algorithm.
- Another Java example is indexOf in AbstractList.
- The pattern is used when selecting a design that requires a fixed algorithm with configurable pieces.

=== DESIGN ===
- The template method pattern is designed around an abstract base class.
- The base class controls the flow, calling the child class rather than the child calling the parent.
- The pattern uses hooks that may be overridden by subclasses.
- It also defines operations that must be overridden by subclasses.
- The UML consists of just two parts: an AbstractBase class and a ConcreteClass.
- The overall design is simple and straightforward.

=== PITFALLS ===
- You must properly restrict access to certain methods to prevent unintended overrides.
- Correct implementation of hooks (optional) and operations (required) is critical.
- Misidentifying hooks vs. operations can lead to incorrect or incomplete behavior.
- The pattern can create a confusing class hierarchy due to spreading logic across multiple classes.
- It breaks the usual expectation that an object contains a full unit of work, making the flow less intuitive.
- A large number of templates can lead to complex and hard-to-follow program flow.
- Despite these pitfalls, it remains effective for implementing algorithms cleanly and consistently.

=== COMPARISON ===
Template Method can be compared with the Strategy pattern as both focus on algorithms.

Template Method Pattern:
- Uses one fixed algorithm with different implementations for specific steps
- Class-based, relying on inheritance from a base class
- Concrete classes override hooks or parts of the algorithm, not the whole algorithm
- The algorithm structure lives in the base class
- Chosen at compile time, not swapped dynamically

Strategy Pattern:
- Implements an entire algorithm per strategy
- Focused on the contract/interface, not inheritance
- Allows the client to select the algorithm at runtime
- Used when runtime algorithm selection is required

=== SUMMARY ===
- Guarantees adherence to a defined algorithm structure
- Commonly used in IoC containers
- Aligns with the Hollywood Principle: "Don't call us, we'll call you"
- Offers a simpler interaction model compared to Strategy
- Typically requires overriding only a single method or small part of the algorithm
- Provides a fixed workflow with customizable steps