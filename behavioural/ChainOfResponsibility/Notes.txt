Decouples a request from a handling object in a chain of handlers until it is finally recognized.

Concepts:
* Decouples sender and receiver - Oftentimes in an application, we want to pass a request to a receiving object without knowing who the sender was and vice versa. The sender shouldn't have to know who the receiver was in order for it to process that request.
* When using the chain, the receiver should also contain a reference to the next receiver or the successor.
* One of the main reasons for choosing this pattern is to promote loose coupling. We can modify the chain and add links to the chain without rewriting large portions of the logic in the application.
* It should also be okay that there may not be a handler for a given request and that the application will just continue on.

eg.java.util.logging.Logger API, servlet.Filter, Spring Security API.

Design:
The design of the chain of responsibility has a chain of receiver objects. This can be implemented in a number of ways, but some basic form of a list is typically the most common. Each handler is based off of a main interface that defines the contract between each chain link. There is a concreteHandler for each receiver or implementation that will interpret a request. In building the chain, each handler has a reference to its successor or the next link in the chain. The pieces of the UML diagrams are a Handler and a ConcreteHandler and then a successor. 

Implementation:
Beauty is that handling goes till the end of the chain, and you can set the handler to start from any node.
It's actually quite efficient because it only will go down the chain as far as it needs to go. And it's less code overall, especially if you have a lot of scenarios. So I really like the loose coupling of the chain of responsibility. 
And I like how the business logic of the code is contained exactly where it needs to be and not scattered throughout your application. 
So nowhere else inside your application needs to know about who's approving what or what pieces are doing, what they're supposed to be doing.

Pitfalls:
* handler or handling guarantee. We aren't guaranteed that someone along the chain will, in fact, handle our request.
* runtime configuration. We have great flexibility with this configuration, but it can mean that there are some configurations that haven't been tested and something might actually not get processed.
* If you just keep tacking on handlers, it can get quite large and the performance could start to degrade.
* potential memory leak because you haven't tested all of the scenarios of that chain. And this goes back to the chain length or performance risks. You need to make sure you understand everything that you're building in your chain configuration and know that all of those paths are executed and tested appropriately.

Comparison:
Chain of Responsibility
* Has a chain of handlers.
* Each handler is unique and knows its next handler.
* If it can’t handle a request, it passes it on.
* Doesn’t track which handler processed it (risk of unhandled requests).
* Handlers can use Command Pattern internally.

Command Pattern
* Has commands that wrap all the work into one object.
* Each command is unique and self-contained.
* Does not pass the request to others.
* Usually trackable or reversible (undo/redo).
* We call a command knowing it will handle the request.

Key Differences

Chain = passes request along until handled.
Command = handles request completely itself.

Chain = no automatic history.
Command = often has history for undo/redo.

Summary:
* Decouples the sender and receiver of a request
    * Sender doesn’t need to know which object will handle the request
    * Receiver doesn’t need to know who the sender was
* Can be configured at runtime
* Flexibility of runtime configuration can be helpful but also dangerous
* Hierarchical in nature
* Builds as it goes down the chain to determine which handler can process the request
* Large chains can become performance bottlenecks
* Business logic inside the chain can cause confusion
* Command pattern shares some similarities with the chain of responsibility pattern