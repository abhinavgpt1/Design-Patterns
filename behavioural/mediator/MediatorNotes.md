## Mediator Pattern
- Def: The Mediator design pattern is a behavioral pattern that centralizes communication between objects through a mediator object, thus reducing chaotic and direct dependencies among objects.

### Overview
The Mediator pattern introduces a mediator object that handles communication between different objects (colleagues), preventing direct interactions and reducing dependencies. It acts as a central hub for coordinating interactions.

### Core Features

1. **Loose Coupling**: Reduces direct dependencies between objects by centralizing communication.
2. **Centralized Control**: All interactions go through the mediator, making it easier to manage and modify, hence prevents spaghetti code caused by direct inter-object communication.
3. **Reusability**: Individual components become more reusable since they don't need to know about others.
4. **Simplified Maintenance**: Changes to interaction logic are confined to the mediator.
5. **Interface-Based**: Often uses interfaces for flexibility in mediator implementations.

Examples: `java.util.Timer` for scheduling, `java.lang.reflect.Method.invoke()` for reflection.

### When to Use

Use the Mediator pattern when:
- You have a set of objects that communicate in complex ways, leading to tight coupling.
- Reusing objects is difficult due to interdependencies.
- You want to centralize control logic for interactions.
- Behavior distributed among several classes should be customizable without subclassing.

### Implementation Details
- **Mediator Interface**: Defines the communication contract.
- **Concrete Mediator**: Implements the interface and coordinates between colleagues.
- **Colleague Classes**: Objects that communicate through the mediator; they reference the mediator but not each other.
- Mediator knows about colleagues; colleagues know about the mediator, but colleagues don't know about each other.
- Can be implemented as a class, but interface adds flexibility. Using an interface allows swapping mediators.
- Minimizes inheritance (aka subclassing of colleague classes for inter-communication) by handling communication externally.

## Mediator vs. Observer Pattern

| Aspect | Mediator Pattern | Observer Pattern |
|--------|------------------|------------------|
| **Purpose** | Defines how objects interact | Defines one-to-many broadcast |
| **Coupling** | Decouples by replacing direct references with mediator | Decouples via broadcast mechanism instead of managed interaction |
| **Interaction** | Explicit and specific interactions | Generic notifications to listeners; Listeners decide individually how to react |
| **Modification** | Adding features requires changing (modity / extend) mediator since it controls the interactions | Adding features is easy - just add a new listener; no need to change any central orchestrator |
| **Centralization** | Centralized control | Decentralized reactions; Instead of defining interactions, it notifies all subscribed listeners |

**Key Differences:**
- Mediator centralizes and controls interactions; Observer decentralizes and broadcasts events.
- Mediator is for managed, specific interactions; Observer is for generic event notifications.

### Pitfalls

1. **God Object Risk**: Mediator can become too large and handle too many responsibilities.
2. **Limited Subclassing**: Restricts easy subclassing of components turning them dumb since all logic is in the mediator. 
    - To support different behaviors, you often need multiple mediators, which can shift complexity rather than eliminate it.
3. **Confusion with Command**: Can be confusing to use Mediator instead of or along with Command pattern; often used together.
4. **Overhead in Simple Systems**: Adds extra indirection that can make simple object interactions more complex than needed.
5. **Single Point of Failure**: If the mediator breaks, all communication between components is affected.
6. **Hidden Flow of Control**: Interaction logic is centralized, making system behavior harder to trace and debug.
    - qq: why is it hard to debug when we know all logic is centralised?
    - ans: Because control flow is hidden inside the mediator, it’s not obvious how components interact or why a behavior occurred. In complex systems, the mediator’s logic can be hard to follow. So the flow becomes: "Something happened → go check mediator → find out what actually happens"
7. **Low Reusability**: Mediators are usually tightly coupled to specific components, limiting reuse in other contexts. A mediator doesn’t just "coordinate anything" - it encodes business rules and interaction logic between particular objects. eg,
    - A ChatRoomMediator might coordinate User, Message, and Notification.
    - A UIFormMediator might coordinate Button, TextField, and Checkbox.
    - Even though both are "mediators", their logic is completely different.

### Summary

- Promotes loose coupling in complex communication scenarios.
- Direct communications can become noisy/messy, so it centralizes interaction logic to absorb complexity and simplify components.
- Works well with Command pattern for clean architecture and communication orchestration.
    - Both these patterns complement each other rather than compete.
    - Mediator helps resolve Command Pattern shortcomings by handling coordination at the correct layer, while Command focuses on encapsulating actions.
    - Using a Mediator alone (without Command) often results in bloated and less clean code, since it ends up handling both coordination and execution leading to a "god object" scenario.
- Avoids spaghetti code from direct object communication.
- Best used when coordination is needed at a higher layer.