## Facade (/fəˈsɑːd/) Pattern
- Def: The Facade Design Pattern is a structural pattern pattern that provides a simple and unified interface to a complex subsystem. 
It hides the internal complexity of the system, by providing a single, high-level entry point, making it easier to use and maintain.

### Purpose
Makes an API easy to use. Facade is often seen wrapping a poorly designed API with a cleaner interface to hide details from the client.

### Benefits
- Simplifies client usage and code
- Reduces dependency on external complex code/library
- Improves API usability

### Use Cases
Typically a refactoring pattern used for complex or poorly designed APIs.

### Example in Java
- java.net.URL: provides a simple interface to complex networking operations like connection handling, protocol management, and data streaming.
    - Protocol handling (HTTP, HTTPS, FTP)
    - DNS resolution (domain → IP)
    - Opening connections
    - Handling streams
    - Data transfer over network

### References
For more examples, see:
- RefactoringGuru
- GFG