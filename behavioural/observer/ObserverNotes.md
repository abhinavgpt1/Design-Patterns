## Observer Pattern
- Def: Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

### Overview
The Observer pattern establishes a subscription mechanism where observers register with a subject to receive notifications of state changes. It promotes loose coupling by allowing subjects and observers to interact without knowing each other directly.

### Core Features

1. **One-to-Many Relationship**: One subject notifies multiple observers.
2. **Loose Coupling**: Subjects and observers are decoupled and don't reference each other directly; observers can be added/removed dynamically.
3. **Automatic Updates**: Observers are notified automatically when the subject changes.
4. **Event-Driven**: Supports event-driven architectures and reactive programming.
5. **Dynamic Registration**: Observers can subscribe/unsubscribe at runtime.

Examples: 
- `java.util.Observer/Observable`
- `java.util.EventListener` for AWT/Swing
- JMS Topics for message-driven applications
- Frequently used in MVC architectures, especially where views need to update based on events


#### Note: This pattern is often confused with Pub/Sub architecture, but they aren't the same. Observer is typically synchronous, whereas Pub/Sub is asynchronous.


### When to Use

Use the Observer pattern when:
- Objects need to be notified of state changes in a subject.
- Changes to one object require updating others without tight coupling.
- A system has a broadcast communication model.
- You need to implement event-driven or reactive systems.

### Implementation Details
- **Subject/Observable**: Interface to the object being observed; declares methods w.r.t. observers eg. attach/detach/notify.
- **Concrete Subject**: The object being observed; maintains list of observers; implements subject interface and defines abstract methods (attach, detach, notify).
- **Observer**: Interface defining the update method.
- **Concrete Observer**: Implements update method to react to subject changes.
- Notifications can be push (subject sends data) or pull (observers query subject).
- In `java.util.Observer`, the  subject implements `Observable`.

## Observer vs. Mediator Pattern

| Aspect | Observer Pattern | Mediator Pattern |
|--------|------------------|------------------|
| **Relationship** | One-to-many broadcast (one subject many observers) | One-to-one-to-many coordination (Invoker -> Meditator -> 1 or more Receivers) |
| **Purpose** | Notify listeners of changes | Orchestrate interactions directly rather than broadcasting events |
| **Coupling** | Decouples, but in interest of state change events | Decouples, but to simplify complex, multi-object interactions |
| **Communication** | Indirect, Event-driven, Decentralised, and Async in spirit (though not necessary) like Pub-Sub | Indirect and Centralised |
| **Usage** | State change broadcasts to listeners | Simplifies complex object interactions |

**Key Differences:**
- Observer broadcasts changes; Mediator manages interactions.
- Observer is for notifications; Mediator for collaboration.
- Mediator can use Observer internally for notifications. Mediator becomes subject in this case, and receivers become observers

### Pitfalls

1. **Unexpected Updates**: Subject doesn't know who its observers are, so observers may receive notifications unintentionally.
2. **Ambiguity**: Notifications don't specify what changed, leading to ambiguity and extra work to figure out what triggered the update.
3. **Performance**: Update storms from frequent or large notifications can cause unnecessary computation. Avoiding the pattern isn't the soln.
    - Observers process every notification even if the observed change is irrelevant.
4. **Debugging Difficulty**: Hard to trace event origins in complex systems.
5. **Memory Leaks**: Forgotten observers can prevent garbage collection.
- Real-world example (from message-driven systems)
    - Large systems may fire many notifications that observers do not need.
    - Leads to confusion and time spent filtering events on the observer side.

### Summary

- Decouples subjects and observers for flexible communication.
- Java originally provided built-in support (Observer/Observable).
- Can be combined with Mediator for enhanced coordination.
- Powerful for event-driven and reactive designs. Requires careful notification management.
- Harder to debug due to disconnected message flow
- Complexity exists regardless; pattern helps organize it. Not using it doesn't simplify communication.