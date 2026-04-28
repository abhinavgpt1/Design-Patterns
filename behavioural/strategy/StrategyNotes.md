## Strategy Pattern
- Def: The Strategy pattern is a behavioral design pattern that defines a family of algorithms, put each of them into a separate class each one, and makes them interchangeable.

### Overview
The Strategy pattern encapsulates algorithms into separate classes, allowing clients to choose and switch between them at runtime. 
It eliminates conditional logic for algorithm selection and promotes clean, extensible code.

### Core Features

1. **Algorithm Encapsulation**: Each algorithm is in its own class.
2. **Interchangeability**: [Key Intent] Removes algorithm-selection **conditional** logic from the **core** application flow and can be swapped dynamically without changing client code.
3. **Client Choice**: Client is aware of the available algorithms and selects the appropriate strategy.
4. **Independence**: Strategies don't know about each other.
5. **Extensibility**: New algorithms can be added easily.

Examples: `java.util.Comparator` for sorting strategies.

### When to Use

Use the Strategy pattern when:
- You have multiple algorithms for a task and want to switch between them.
- You want to avoid conditional statements for algorithm selection.
- Algorithm variations are complex and need isolation.
- Clients need to choose algorithms at runtime.

### Implementation Details
- **Strategy Interface**: Defines the algorithm contract. Often implemented with an abstract base class for shared behavior.
- **Concrete Strategies**: Implement specific algorithms. Each algorithm variant is a separate concrete class.
- **Context**: Uses a strategy; client provides the strategy instance.
- Client creates and passes the strategy to the context.
- Strategies are independent; no communication between them.

## Strategy vs. State Pattern

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
- Strategy for algorithm selection; State for state-dependent behavior.
- Strategy encapsulates algorithm logic; State encapsulates state logic.
- Strategy chosen by client; State managed internally.
- Both use polymorphism but for different purposes.

### Pitfalls

1. **Client Complexity**: Client must know and manage strategies, and can shift conditional complexity to the client.
2. **Usability & Lifecycle**: Clients must manage creation and lifecycle of strategy objects, which can lead to misuse or unnecessary object churn.
3. **Over-engineering**: Unnecessary for simple algorithm variations.
4. **Runtime Errors**: Wrong strategy choice is common since there's no compile-time enforcement causing subtle runtime errors.
5. **Maintenance & Scalability**: Large sets of strategies hurt discoverability and require discipline to avoid duplicated logic or diverging implementations.
    - eg. CreditCardStrategy, UPIStrategy and WalletStrategy may start varying over time although they started with the same logic.
6. **Cross-Strategy Coordination**: Since strategies don't know about each other, scenarios needing shared or coordinated behavior become awkward or unsupported.
    - eg. Given PaymentStrategy, DiscountStrategy, FraudCheckStrategy - Apply discount only if fraud check passes, and log everything consistently
    - Something like makes context messy
    `
        if (fraudStrategy.check()) {
            discountStrategy.apply();
        }
        paymentStrategy.pay();
    `
    - Something like this breaks pattern
    `
    class DiscountStrategy {
        FraudStrategy fraud;
        void apply() {
            if (fraud.check()) {...}
        }
    }
    ` 
5. **Performance**: Interface switch overhead and object creation can introduce small but notable costs.
6. **Code Quality**: Maintaining consistency across strategy implementations requires strong team discipline to prevent logic drift or accidental re-introduction of conditionals.

### Summary

- Externalizes algorithms for flexible behavior variation without changing main application.
- Client chooses strategy; each in separate class.
- Requires client awareness of available strategies.
- Eliminates conditional logic from core code. Keeps main method simple and clean, shifting branching logic to separate classes.
- Strategy isolation makes individual algorithms easy to test and maintain.