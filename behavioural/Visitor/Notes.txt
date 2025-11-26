=== CONCEPTS ===
When to Use
- You need to separate algorithms from the object structure
- You anticipate frequent changes or new features
- You cannot or should not modify existing object classes

Key Idea
- Supports the open-closed principle by adding behavior without altering structures
- Specialized logic lives in the Visitor, not in the original objects

Examples (Java)
- Element + ElementVisitor → used for language processing internals

=== DESIGN ===
- Built around interfaces for both visitors and elements
- Must be planned early because the structure depends on visitor support from the start
- Objects expected to evolve with new behaviors
- Each Element implements an accept/visit method to allow a visitor to operate on it
- Each Visitor defines operations for every Element type it can handle
- Core roles: Visitor, ConcreteVisitor, Element, ConcreteElement

=== PITFALLS ===
Requires upfront planning
- Forces you to design for adaptability early
- Can lead to over-architecting, adding flexibility that may never be used

Introduces indirection
- Makes behavior feel disconnected from the object's own domain
- Forces visit methods onto all elements, adding boilerplate and cognitive overhead

Partial implementations
- Visitors may not implement every required method, creating gaps or partial behavior
- Sometimes pushes you to use an Adapter, adding even more complexity

Complexity and obscurity
- Pattern can feel obscure and complex, making it harder for teams to understand
- Rarely used in practice, meaning fewer examples and less familiarity among developers
- When misapplied, it can complicate rather than simplify the codebase

=== COMPARISON ===
Visitor can be compared with the Iterator pattern—both are interface-based patterns.

Visitor Pattern:
- Focuses on adaptability by externalizing behavior/changes outside the object structure
- Makes it easy to add new visitors, enabling new features without modifying existing elements
- Encourages multiple visitors, each providing different operations on the same object structure
- Example: Quickly adding a new visitor to display parts in the ATV parts example

Iterator Pattern:
- Also based on an interface, but commonly implemented with anonymous inner classes
- Focuses on navigation through a collection, not externalizing behavior
- Encapsulates traversal logic, but the behavior stays tied to the collection, not separated out
- Typically has only one iterator type per collection—more singular in purpose and usage

Core Difference:
- Visitor → externalize behavior, easy to add new operations
- Iterator → control navigation, usually one traversal approach, behavior stays internal

=== SUMMARY ===
When to Use
- Expecting future changes but don't know their specifics
- Want to externalize change instead of modifying existing objects
- Base API cannot be changed after deployment

Key Benefits
- Allows adding new functionality without altering existing structures
- Helps maintain the contract of the original classes
- Makes it easier to test that existing behavior isn't broken as new features are added

Trade-offs
- Adds some complexity, but stays within normal OOP principles