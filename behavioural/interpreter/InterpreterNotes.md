Definition (gfg): 
This design pattern defines a language's grammar and provide an interpreter to process statements in that language. 
It is useful for parsing and executing expressions or commands in a system.

Concepts:
Purpose of Interpreter Pattern
    Represents a grammar (e.g., music notation, mathematical equations, programming languages).
    Allows parsing and interpreting sentences based on defined rules.
    Enables creation of domain-specific languages (DSLs).
Common Uses
    Widely used in compilers to parse source code.
    Used to define and interpret grammars such as SQL or XML.
    Often paired with an Abstract Syntax Tree (AST) to represent structure.
Examples in Java API
    java.util.Pattern: Represents compiled regular expressions for string searching.
    java.text.Format: Abstract base class for locale-sensitive content formatting (dates, numbers, strings).
Design Considerations
    Choose when you need to define a language or grammar that can be interpreted.
    Particularly useful for DSLs and scenarios involving frequent parsing/evaluation.

Design:
Interpreter Pattern Structure
    Has a distinct design compared to most other patterns.
    Uses an Abstract Base Class / AbstractExpression declaring an interface for executing operations.
    The primary operation is the interpret() method.

Expression Types
    Terminal Expressions
        Represent leaves of the tree.
        Contain no other expressions.

    Non-terminal Expressions
        Represent compound expressions.
        Contain or combine other expressions.
        Typically call themselves recursively until reaching terminal expressions or subexpressions.

Key UML Components
    Context – Holds information global to the interpreter.
    AbstractExpression – Declares the interpret interface.
    TerminalExpression – Implements interpret for simple symbols/leaves.
    NonterminalExpression – Implements interpret for compound rules, may reference other expressions.
    Client – Builds and invokes the expression tree.

          +----------------+
          |    Context     |
          +----------------+
                  |
                  |
        +----------------------+
        |  AbstractExpression  |<---------------------------+
        |  + interpret(ctx)    |                            |
        +----------------------+                            |
           /            \                                   |
          /              \                                  |
+----------------+   +---------------------+                |
|TerminalExpr    |   |NonterminalExpr       |               |
|+interpret(ctx) |   |+interpret(ctx)       |               |
+----------------+   | references other     |---------------+
                     | AbstractExpressions  |
                     +----------------------+

                   +----------------+
                   |     Client      |
                   | builds the AST  |
                   +----------------+

Note: This pattern has nothing to do about the parsing, but rather establishing and interpreting a grammar

Pitfalls:
Complexity & Maintenance
    If the grammar becomes large or complex, it’s difficult to maintain.
    There is at least one class per grammar rule.
    Complex rules often require multiple classes, increasing the class count rapidly.

Adding Variants Is Costly
    Adding a new variant may require changes across every variant class.
    High risk of ripple effects when modifying or extending the grammar.

Pattern Specificity
    Interpreter is very specific to its problem domain.
    Unlike some other patterns, it’s less general-purpose and harder to reuse outside the defined grammar.

Mitigation
    Other design patterns (e.g., Visitor, Composite, or Flyweight) can help manage complexity and reduce class proliferation.

Interpreter vs Visitor:
Interpreter and Visitor patterns have similar structures but different implementation focuses.

Interpreter Pattern
    Functions (like interpret) are defined as methods inside the expression objects.
    Has direct access to properties because it contains the object.
    Adding new functionality means changing every expression variant.

Visitor Pattern
    Functionality lives in the visitors, not in the expression objects.
    Needs observer-like functionality to access properties (since they’re not inside the visitor).
    Adding a new variant requires changing every visitor.

In interpreter, the focus is more about whether you're adding more expressions or grammar rules or adding new visitors to interact with. 
And that is where the main focus on choosing one over the other comes into play.


Summary:
Use Case: The Interpreter pattern is best when you need to define a grammar, rules, or validation criteria for objects.
Flexibility: Although often shown with strings, it can also work with objects using generics.
Scope: It’s a specialized pattern, excellent for its specific purpose but limited outside of that domain.
Implementation Caution: Be mindful of where changes are most likely to occur; if changes are in operations rather than expressions, you might consider the Visitor pattern instead.