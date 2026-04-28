## Template Method Pattern
- Def: The Template Method Pattern is a behavioral design pattern that defines the skeleton of an algorithm in a base class but allows subclasses to override specific steps without changing the core/algorithm's structure.

### Overview
The Template Method pattern provides a template for an algorithm, with some steps implemented in the base class and others left to subclasses. It ensures the overall algorithm structure remains consistent while allowing customization of specific steps.

### Core Features

1. **Code Reuse**: Promotes reuse by centralizing common algorithm parts.
2. **Algorithm Skeleton**: Defines and controls the overall algorithm structure in the base class.
3. **Deferred Steps**: Subclasses implement or override specific steps.
4. **Inversion of Control**: Base class calls subclass methods (Hollywood Principle).
5. **Consistency**: Ensures algorithm flow is maintained across implementations.

Note:
- Common in frameworks and libraries.
- Frameworks define a fixed flow and let developers plug in custom behavior.
- The pattern predates IoC, though IoC helped popularize it.
- IoC containers (like Spring) support plug-in behavior by managing objects and wiring implementations into a predefined flow.
- IoC frameworks often mimic Template Method with dependency injection, callbacks, and lifecycle hooks.

Examples:
- `java.util.Collection#sort`, Template Method = the sorting routine, Strategy = the comparator behavior used by that routine.
    - Unlike Strategy, Template Method keeps a fixed algorithm and overrides steps within it instead of swapping the whole comparator or strategy.
- `AbstractList#indexOf`, that implementation defines a fixed search algorithm: iterate over elements, compare each element with the target, return index when matched.

### When to Use

Use the Template Method pattern when:
- You have a fixed algorithm structure with variable steps.
- Common behavior should be shared, but specific parts customized.
- You want to avoid code duplication in similar algorithms.
- Subclasses should not change the overall algorithm flow.

### Implementation Details
- **Abstract Base Class**: Contains the template method and default implementations. The base class controls the flow, calling the child class rather than the child calling the parent.
- **Template Method**: Defines the algorithm skeleton, calling abstract or hook methods.
- **Abstract Methods**: Must be implemented by subclasses.
- **Hook Methods**: Optional methods with default behavior that can be overridden. Hooks can be variables too.
- Subclasses extend the base class and customize the deferred steps.
- The overall design is simple and straightforward, and UML consists of an Abstract Base class and a Concrete Subclass.

## Template Method vs. Strategy Pattern

| Aspect | Template Method Pattern | Strategy Pattern |
|--------|-------------------------|------------------|
| **Algorithm Handling** | Fixed structure (living in base class) with customizable steps | Entire algorithm encapsulated |
| **Implementation** | Inheritance-based; relying on base class | Interface-based; focused on contract and not inheritance |
| **Selection** | Chosen at compile-time | Selected at runtime |
| **Customization** | Override specific steps | Swap whole algorithm |
| **Flexibility** | Limited to defined hooks | Highly flexible algorithm choice |

**Key Differences:**
- Template Method customizes parts of a fixed algorithm; Strategy chooses between complete algorithms.
- Template Method uses inheritance; Strategy uses composition / dependency (in UML terms).
- Template Method for compile-time variation; Strategy for runtime selection.

### Pitfalls

1. **Access Control**: Must restrict method access to certain methods to prevent unintended overrides. eg by making the template method final and only allowing specific methods to be overridden.
2. **Hook vs. Operation Confusion**: Incorrect identification leads to incomplete behavior. Correct implementation of hooks (optional) and operations (required) is critical.
3. **Class Hierarchy Complexity**: Spreading logic can make hierarchies and flow confusing to understand especially in complex systems. 
4. **Intuition Break**: Violates expectation of self-contained objects, i.e. it breaks the usual expectation that an object contains a full unit of work.
5. **Scalability**: Many templates can complicate program flow.
6. **Performance**: Template Method can be slow due to method calls.

PTR: Despite these pitfalls, it remains effective for implementing algorithms cleanly and consistently.

### Summary

- Guarantees algorithm structure while allowing customization.
- Used in frameworks and IoC containers.
- Follows Hollywood Principle: "Don't call us, we'll call you"
- Requires overriding only specific parts. Rewriting pieces is a core feature of Template Pattern.
- Provides fixed workflow with pluggable steps.
- Offers a simpler interaction model compared to Strategy.