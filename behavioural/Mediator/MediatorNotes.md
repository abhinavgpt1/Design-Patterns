=== CONCEPTS ===
Why Mediator?
- Needed to achieve loose coupling between objects
- Useful when multiple well-defined objects communicate in complex ways
- Prevents spaghetti code caused by direct inter-object communication
- Helps create reusable components by centralizing communication

Core Idea
- Acts as a hub or router for all communication between objects
- Routes interactions through a central component
- Objects communicate through the mediator instead of directly with each other

Examples
- java.util.Timer mediates calls via its schedule methods
- java.lang.reflect.Method invoke method mediates calls to reflected classes

Design Considerations
- Use when you have complex communication between multiple objects
- Centralizes control logic in one place
- Makes individual components simpler and more reusable

=== DESIGN ===
- Mediator design is interface-based with a concrete class implementation
- Can also be implemented directly as a class, but interface adds flexibility
- Using an interface allows swapping mediators depending on the situation
- Mediator minimizes inheritance since it handles communication instead of relying on class hierarchies
- Mediator knows about the colleagues, but colleagues don't know about each other
- UML representation involves a Mediator interface and ConcreteMediator implementation

=== PITFALLS ===
Risk of a “deity object”
- Mediator can become overly large and responsible for too many things.
- Happens when it handles every scenario and grows quickly.

Limited subclassing
- Mediator structure can restrict how easily you can subclass components.
- You can create different mediators for different situations (often due to platform differences).

Confusion with the Command Pattern
- It can be unclear whether to use the Mediator instead of or along with the Command Pattern.
- Demo uses Mediator with Command Pattern because they work well together.

Need to compare with other patterns
- Comparison helps solidify understanding.
- The text avoids comparing with the Command Pattern again since it was already used in the demo.

=== COMPARISON ===
Mediator stands distinct from the Observer pattern, though both promote decoupling.

Mediator Pattern:
- Defines how objects interact with each other
- Decouples objects by replacing direct references with a single mediator reference
- Interaction logic is explicit and specific
- Adding features often means modifying or extending the mediator, since it controls the interactions

Observer Pattern:
- Defines a one-to-many broadcast model
- Instead of defining interactions, it notifies all subscribed listeners
- Listeners decide individually how to react
- Also promotes decoupling, but via a broadcast mechanism instead of managed interaction
- More generic compared to mediator
- Adding features is easy—just add a new listener; no need to change any central orchestrator

Core Contrast:
- Mediator: centralizes and controls interactions
- Observer: decentralizes and broadcasts events

=== SUMMARY ===
- Great for loose coupling, especially in complex communication scenarios
- When objects interact directly (e.g., via the Command Pattern), communication can become noisy
- Mediator simplifies interactions by centralizing communication
- Mediator may absorb complexity, which is acceptable since it keeps complexity out of individual objects
- Mediator and Command Pattern complement each other—they are not competing patterns
- Mediator helps resolve Command Pattern shortcomings by handling coordination at the correct layer
- Using a Mediator alone (without Command) often results in awkward code patterns
- Using Mediator + Command together provides a cleaner, more structured architecture

PTR: Mediator works best alongside Command Pattern for clean communication orchestration