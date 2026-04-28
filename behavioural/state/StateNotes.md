## State Pattern
- Def: State is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.

### Overview
The State pattern encapsulates state-specific behavior into separate state classes. The primary object, called the Context, delegates all state-related work to an instance of one of these state classes. This eliminates conditional statements and makes state transitions explicit.
It cleanly separates what state you are in from where you are in the application. Think of the State Pattern as splitting your code into two orthogonal concerns:
    - "What state you are in" → the current behavior mode
    - "Where you are in the application" → the flow/context that's executing

### Core Features

1. **State Encapsulation**: Each state is represented by its own class with specific behavior.
2. **Dynamic Behavior**: Object behavior changes based on current state without modifying the class.
3. **Open-Closed Principle**: New states can be added without changing existing code. Main class is closed for modification; individual states are open for extension.
4. **Clean Transitions**: State changes are handled explicitly by state objects, making behavior transitions organized and maintainable.
5. **Reduced Complexity**: Ensures the current state is stored as an object, not scattered across variables and conditionals

Examples: No strong example in core java, but JSF lifecycle phases (arguably), and Iterator since its behavior changes at runtime (weak example).

### When to Use

Use the State pattern when:
- An object's behavior depends on its state and must change at runtime.
- Operations have large, multipart conditional statements based on state.
- You want to avoid scattering state-specific code across the class.
- State transitions are complex and need to be managed explicitly.

### Implementation Details
- **State Interface/Abstract Class**: Defines methods for state-specific default behavior. Useful because not every state needs to implement every method.
- **Concrete State Classes**: Implement state-specific logic.
- **Context**: Holds reference to current state; delegates state-specific behavior to the current state object.
There are 3 valid models on state transition, it depends on how you design the system:
1. State-driven transitions: State knows its next state and triggers transition by telling context what its next state is.
    - Context is unaware of all states, only knows the current one - unlike earlier approaches (State_BadImpl.java) where the context knew every state and used conditionals. eg. impl in current codebase.
2. Context-driven transitions: Context is responsible for transitions between states.
    - State knows that a transition should happen, but Context decides how that transition is performed
3. Externalized transitions: Transition logic is handled by an external component. eg. TransitionManager / StateMachine.

## State vs. Strategy Pattern
Can be compared with the Strategy pattern as both use polymorphism for behavior.

| Aspect | State Pattern | Strategy Pattern |
|--------|----------------|------------------|
| **Purpose** | Encapsulate state and handle behavior based on internal state | Encapsulate interchangeable algorithms |
| **Structure** | Interface/Abstract class defines behavior; each state is its own class | Interface/Abstract class defines the algorithm/behavior; each strategy is its own class |
| **Transitions** | States (may) know their next state and trigger transitions by telling context what its next state is | Strategies do not know about each other;No transitions between strategies |
| **Client Role** | Context manages state automatically | Client selects strategy | 
| **Awareness** | States coordinate with context | Strategies are independent |
| **Behavior Change** | Dynamic behavior as context moves from state to state | Swapped at runtime by client, but strategies do not coordinate or transition themselves |
| **Use Case** | State-dependent dynamic behavior | Let's you swap algorithm at runtime without them knowing the context that uses them, eg. checkout system, billing system |

**Key Differences:**
- State manages transitions and context; Strategy focuses on algorithm interchange.
- State encapsulates state logic; Strategy encapsulates algorithm logic.
- Strategy chosen by client; State managed internally.
- Both use polymorphism but for different concerns.

### Pitfalls

1. **Increased Class Count**: More classes for each state causing state explosion as features increase.
2. **Copy-Paste Errors**: Similar state classes can lead to mistakes.
3. **Logic Leakage**: Avoid putting conditionals back in context which otherwise defeats the purpose.
4. **Unclear Transitions**: Must define clear triggers for state changes.
5. **State Definition**: Poorly defined states cause inconsistencies.
6. **Overengineering**: Using State pattern for simple conditional logic adds unnecessary complexity.
7. **Transition Coupling**: States may become tightly coupled if they directly create or reference each other. So, avoid hardcoding transition state instances. 
    - eg. ctx.setState(new PublishedState()); [BAD]
    - eg. ctx.transitionTo(StateType.PUBLISHED); [GOOD - let context handle the transition logic]
8. **Hidden Control Flow**: Behavior is distributed across multiple state classes, hence require jumping between classes to understand flow, making it difficult to debug across states.

### Summary

- Reduces cyclomatic complexity by eliminating conditional logic for states.
- Makes adding states easier and more maintainable.
- Increases class count but improves organization.
- Prone to copy-paste errors because state classes often resemble each other.
- Requires careful state identification and transition management.
- Similar to Strategy but handles state transitions instead of interchangeable algorithms.