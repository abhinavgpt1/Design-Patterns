=== CONCEPTS ===
When to Use
- When one subject must notify many observers
- Useful for decoupling objects so they don't reference each other directly
- Common in event-driven scenarios

Observer vs Pub/Sub
- Often used interchangeably, but not identical
- Observer → typically synchronous
- Pub/Sub → typically asynchronous

Common Use Cases
- Frequently used in MVC architectures, especially where views need to update based on events

Java API Examples
- java.util.Observer / Observable → included because the pattern is broadly useful
- java.util.EventListener → base interface for nearly all AWT/Swing event systems
- JMS Topics → uses the same pattern for message-driven applications

=== DESIGN ===
Core Structure

Subject:
- The object being observed
- Maintains a list of observers
- Provides methods for observers to register, deregister, and notify

Observers:
- Defined via an interface
- Concrete implementations react to updates from the subject

Java Implementation Notes
- In java.util.Observer, the subject implements Observable
- Concrete observers are often views in event-driven or MVC applications

UML Components
- Subject
- Concrete Subject
- Observer (interface)
- Concrete Observer

=== PITFALLS ===
Unexpected updates
- Subject doesn't know who its observers are, so notifications may reach objects unintentionally

Observers don't know what changed
- Notification only says "something changed"
- Leads to ambiguity and extra work to figure out what triggered the update

Large update consequences
- Observers must process every notification even if they don't care about the specific update
- Can cause unnecessary computation

Performance impact
- If the subject is large or triggers many changes, update storms can occur
- Performance hit is possible, though avoiding the pattern doesn't inherently solve the issue

Disconnected nature → difficult debugging
- Hard to trace where change events originate
- Message-driven systems often produce many irrelevant notifications
- Developers must manually determine whether each notification matters

Real-world example (from message-driven systems)
- Large systems may fire many notifications that observers do not need
- Leads to confusion and time spent filtering events on the observer side

=== COMPARISON ===
Observer can be compared with the Mediator pattern in terms of decoupling.

Observer Pattern:
- One-to-many model
- One subject, many observers
- Used to decouple an object from those interested in its state
- Works as a Pub/Sub or broadcast mechanism
- Communication is indirect, event-driven, and typically asynchronous in spirit (though not required)
- Primary purpose: notify many listeners of state changes

Mediator Pattern:
- One-to-one-to-many model
- Objects communicate to the mediator, and the mediator coordinates communication with others
- Used to reduce complex communication between objects
- Focuses on orchestrating interactions directly rather than broadcasting events
- Also promotes decoupling, but for the purpose of simplifying complex, multi-object collaboration

Relationship Between Them:
- Mediator can internally use Observer as its notification mechanism
- In such cases, the mediator becomes the subject, and other components become observers

=== SUMMARY ===
- Decouples communication between subject and observers
- Java originally provided built-in support (Observer/Observable)
- Can be combined with Mediator (mediator acts as subject)
- Powerful for event-driven designs
- Harder to debug due to disconnected message flow
- Not using it doesn't simplify communication—complexity still exists