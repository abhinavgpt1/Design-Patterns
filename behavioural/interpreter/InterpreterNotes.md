## Interpreter Pattern
- Def: The Interpreter pattern is a behavioral design pattern used to define and evaluate the grammar of a language. It provides an interpreter for that language, which is useful for parsing and executing expressions or commands.

### Overview
The Interpreter pattern represents a grammar (e.g., music notation, mathematical equations, programming languages) and allows parsing and interpreting sentences based on defined rules. It represents each rule of the language as a class. It enables the creation of domain-specific languages (DSLs) and is often paired with an Abstract Syntax Tree (AST) to represent structure.

### Core Features

1. **Grammar Representation**: Represents and interprets grammars for languages or expressions. eg SQL / XML.
2. **Parsing and Evaluation**: Allows parsing and executing statements based on rules. eg. Used in compiler to parse source code.
3. **Domain-Specific Languages**: Enables creation of DSLs for specific problem domains.
4. **AST Integration**: Commonly used with Abstract Syntax Trees for structural representation.
5. **Recursive Evaluation**: Non-terminal expressions call themselves recursively.

Examples: 
`java.util.Pattern`: Represents compiled regular expressions for string searching.
`java.text.Format`: Abstract base class for locale-sensitive content formatting (dates, numbers, strings).

### When to Use

Use the Interpreter pattern when:
- You need to define a language or grammar that can be interpreted.
- You have a problem that can be expressed as a grammar and interpreted repeatedly.
- You want to create domain-specific languages (DSLs).
- Parsing and evaluation of expressions are frequent operations.
- The grammar is relatively simple and stable.

### Implementation Details
- **AbstractExpression**: Declares an interface for executing operations, primarily the `interpret()` method.
- **TerminalExpression**: Represents leaves of the expression tree; implements `interpret()` for simple symbols.
- **NonterminalExpression**: Represents compound expressions; implements `interpret()` and may reference other expressions. Typically they call themselves recursively until reaching terminal expressions or subexpressions.
- **Context**: Stores shared state (e.g., variables, input, environment data) used during interpretation.
- **Client**: Builds the expression tree (AST) and invokes interpretation.
- The pattern focuses on interpretation, not parsing; parsing is handled separately. Parsing implies converting input into an AST, while interpretation evaluates the AST.
- Expressions are organized in a tree structure for recursive evaluation.

## Interpreter vs. Visitor Pattern

| Aspect | Interpreter Pattern | Visitor Pattern |
|--------|---------------------|-----------------|
| **Functionality Location** | Functions (e.g., interpret) defined inside expression objects | Functionality lives in visitors, not in expression objects |
| **Property Access** | Direct access to properties since contained in object | Needs observer-like functionality to access properties |
| **Adding Functionality** | Adding new functionality requires changing every expression variant | Adding a new variant requires changing every visitor |
| **Focus** | Adding more expressions or grammar rules | Adding new visitors (operations) |

**Key Differences:**
- Interpreter embeds behavior in expressions; Visitor separates behavior into visitor classes.
- Interpreter is better for stable grammars; Visitor for evolving operations on stable structures.
- Choose Interpreter for grammar interpretation; Visitor for operations on object structures.

### Pitfalls

1. **Complexity and Maintenance**: Large or complex grammars are hard to maintain; at least one class per rule, leading to class explosion.
2. **Costly Variants**: Adding new variants or extending grammar requires changes across classes, risking ripple effects.
3. **Specificity**: Very specific to its domain; less reusable outside defined grammar.
4. **Mitigation**: Use patterns like Visitor, Composite, or Flyweight to manage complexity.

### Summary
- Use case: Best for modeling and evaluating a grammar, rules, or validation logic (often in DSLs).
- Scope: Purpose-built—very effective within this domain, but not a general solution.
- Parsing vs interpretation: Assumes structure is already built; focuses only on evaluation.
- Flexibility: Works with strings or object structures (e.g., via generics).
- Trade-off: Easy to add new expressions/grammar rules; hard to add new operations (consider Visitor in that case).
- Complexity: Doesn’t scale well with large grammars — structure or combine with other patterns to keep it manageable.