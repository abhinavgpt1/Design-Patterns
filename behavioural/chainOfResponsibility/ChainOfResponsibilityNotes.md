## Chain of Responsibility Pattern
- Def: Chain of Responsibility is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.


### Overview
The Chain of Responsibility pattern allows passing requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain. This promotes loose coupling between the sender and receiver of requests.

#### Note: In the classic Chain of Responsibility, a request is typically handled by exactly one handler. But that’s a convention, not a rule.

### Core Features

1. **Decoupling of Sender and Receiver**: The sender doesn't need to know which object will handle the request, and the receiver doesn't need to know who the sender was.
2. **Successor Reference**: Each handler contains a reference to the next receiver or successor in the chain.
3. **Loose Coupling**: Modifies the chain and adds links without rewriting large portions of the application logic.
4. **No Handling Guarantee**: It's acceptable if no handler processes a given request; the application continues normally.
5. **Hierarchical Processing**: Requests are processed hierarchically as they move down the chain.

Examples: `java.util.logging.Logger` API, `servlet.Filter`, Spring Security API.

### When to Use

Use the Chain of Responsibility pattern when:
- You want to decouple the sender of a request from its receiver.
- Multiple objects may handle a request, and the specific handler isn't known in advance.
- You want to issue a request to one of several objects without specifying the receiver explicitly.
- The set of handlers can change dynamically at runtime.

### Implementation Details
- The chain consists of receiver objects, typically implemented as a linked list or similar structure.
- Each handler is based on a main interface that defines the contract between chain links.
- Concrete handlers implement the interface and interpret/process specific requests.
- Each handler has a reference to its successor (next link in the chain).
- [USP] Processing can start from any node in the chain and continues until the request is handled or the chain ends.
- Efficient because it only traverses the chain as far as necessary.
- Business logic is contained within the handlers, keeping it localized and not scattered throughout the application.
- So nowhere else inside your application needs to know about who's approving what or what pieces are doing, what they're supposed to be doing.

## Chain of Responsibility vs. Command Pattern

| Aspect | Chain of Responsibility | Command Pattern |
|--------|--------------------------|-----------------|
| **Structure** | Chain of handlers | Commands that wrap all work into one object |
| **Handling** | Passes request along until handled | Handles request completely itself |
| **Tracking** | Doesn't track which handler processed it (risk of unhandled requests) | Usually trackable or reversible (undo/redo) |
| **Coupling** | Loose coupling between handlers | Commands are self-contained |
| **Internal Usage** | Handlers can use Command Pattern internally | We call a command knowing it will handle the request. |

**Key Differences:**
- Chain = passes request along until handled.
- Command = handles request completely itself.
- Chain = no automatic history.
- Command = often has history for undo/redo.

### Pitfalls

1. **No Handling Guarantee**: There is no guarantee that any handler in the chain will actually process the request, leading to unhandled or dropped requests.
2. **Order Dependency**: The sequence of handlers is critical; changing the order can silently break logic or produce incorrect results.
3. **Runtime Configuration Risks**: Flexible configuration is powerful, but untested or incorrect setups can cause missing handlers, broken flows, or unexpected behavior.
4. **Silent Failures**: The system may continue running even when something goes wrong (e.g., skipped handlers), making bugs hard to detect.
5. **Performance Degradation**: Long or poorly constructed chains can introduce unnecessary processing and latency.
6. **Memory / Resource Issues**: Chains that grow over time or handlers that retain references/resources without proper cleanup can lead to memory growth or resource leaks.
7. **Testing Complexity**: Multiple possible paths and configurations make it difficult to test all scenarios thoroughly.
8. **Debugging Difficulty**: Tracing the flow of a request through multiple handlers becomes harder, especially when behavior is determined at runtime.


### Summary

- Decouples the sender and receiver of a request.
- Can be configured at runtime.
- Flexibility of runtime configuration can be helpful but also dangerous. eg. Reordering, missing handlers, unexpected short-circuiting, more debugging because of combinatorial nature, etc.
- Hierarchical in nature, building down the chain to find the appropriate handler.
- Large chains can become performance bottlenecks.
- Business logic inside the chain can cause confusion if not well-documented.
- Shares some similarities with the Command pattern but focuses on request delegation rather than encapsulation.