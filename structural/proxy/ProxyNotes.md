## Proxy Pattern
- Def: Proxy Design Pattern is a structural design pattern where a proxy object acts as a placeholder to control access to the real object.
The client communicates with the proxy, which forwards requests to the real object.
The proxy can also provide extra functionality such as access control, lazy initialization, logging, and caching.

### Overview
A structural design pattern that provides a substitute or placeholder for another object to control access to it.

### Purpose
A proxy controls access to the original object, allowing you to perform actions either before or after the request reaches the original object. 
- eg. initialization / method is expensive and time consuming and you want limited hits with user having appropriate permissions/roles and inputs/pre-requisites.

## Design Considerations

### When to Use
When you want to wrap a class because of:
- Adding functionality
- Solving security concerns
- Simplifying access to complex objects
- Perform remote service calls
- Saving costs by wrapping with lazy initialization

### How It Works
- The proxy is called to access the real object
- An interface-based pattern ensuring flexibility

### Examples in Java
- `java.lang.reflect.Proxy`: Facilitates creation of proxy objects dynamically at runtime.
- `java.rmi.*`: Remote Method Invocation for accessing remote objects
- **Use Case**: `InvocationHandler` and `reflect.Proxy` for advanced implementations

## Pitfalls

1. **Single Proxy Limitation**: Only one proxy can wrap an object at a time; Proxy is typically designed for a single responsibility.
   - Adding multiple concerns like auditing and security can lead to bloated proxy, hence a trade-off.
   - Chaining proxies is technically possible but isn't natural or maintainable as using the Decorator pattern; violates SRP.

2. **Abstraction Complexity**: Proxy makes remote calls look like local ones, which can lead to hidden latency and unexpected failures.

3. **Confusion with Other Patterns**: Similar structure to Decorator
   - Easy to mistakenly choose the wrong pattern

4. **Instance Creation**: The client always interacts with the proxy instance, while the real object’s creation is controlled internally and may be delayed or avoided entirely, which can lead to hidden initialization behavior.

## Single-responsibility applications of proxy
- Logging
- Access control (security)
- Caching
- Lazy initialization != singleton :: Control access : single instane
- Network handling

## Proxy vs. Decorator

| Aspect | Proxy | Decorator |
|--------|-------|-----------|
| **Purpose** | Control access to the original object | Add functionality to an object |
| **Multiple Instances** | Only one proxy per object | Multiple decorators can be chained |
| **Chaining** | Cannot chain proxies | Decorators can be composed |
| **Determination** | It looks like it's determined at compile time, but you can dynamically choose proxies remote/local, security, caching | Determined at runtime |

## Real-World Applications

Used extensively in:
- Dependency injection frameworks
   - Your actual class is not called directly — the framework creates a proxy around it to inject additional behavior.
- Inversion of Control (IoC) containers (Spring, Guice)
   - DI/IoC frameworks (e.g., Spring, Guice) use proxies to inject cross-cutting concerns like transactions, security, and logging without modifying core business logic.

## Summary

Great pattern for implementing:
- **Lazy Loading**: Initialize objects only when required
- **Caching**: Store/retrieve cached results
- **Security**: Control access to sensitive objects
- All above concerns can be combined seamlessly in a single proxy implementation; but it's a trade-off on bloated proxy and SRP.