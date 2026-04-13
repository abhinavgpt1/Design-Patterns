=== CONCEPTS ===
Why Iterator?
- Needed to traverse containers (collections) like lists, maps, sets
- Avoids directly exposing internal structure (unlike indexing or manual loops)
- Each structure may need a different algorithm for traversal → iterator abstracts this away

Core Idea
- Decouples data structure from traversal algorithm
- Ensures sequential navigation, even when the data itself doesn't inherently have a natural sequence

Examples
- java.util.Iterator is the built-in interface for traversal
- Enumeration came first (legacy) → later replaced/enhanced by Iterator
- Iterator formally introduced with Collections API in Java 1.2

Design Considerations
- Use when you want clean, consistent traversal across different types of collections
- Hides complexity of underlying data structure
- Makes traversal uniform and extensible

=== DESIGN ===
- Iterator design is interface-based
- Any object to be iterated provides a method that returns an iterator instance
- This works like a factory method pattern for creating iterators
- Each iterator is independent of other iterators
- Iterators are fail fast → if two iterators try to modify the underlying structure, an error is thrown
- Enumerators are fail safe → designed to avoid failing in such cases
- Both fail fast and fail safe approaches have pros and cons
- UML representation involves an Iterator interface and a ConcreteIterator instance created by a container

Note: Using iterator helps since the traditional for(int i...) doesn't need to be used. Also, if the underlying datastructure changes, then the code might work.
eg. List<String> names; Iterator<String> x = names.iterator(); while(x.hasNext()) {...}
The above code will work for Set<String> names; but if you had traversal like for(int i=0; i<names.size(); i++) ...then the code would fail.

=== PITFALLS ===
- Iterator does not provide access to an index
- Cannot directly get an element at a specific position using the base iterator
- Base Java Iterator is unidirectional → only moves forward
- Some subimplementations (e.g., ListIterator) allow bidirectional access
- In most cases, Iterator is efficient and may even add functionality beyond index-based access
- In some scenarios, Iterator can be slower than using an index-based loop
- Performance depends on the underlying collection (e.g., some are faster at retrieval, others at insertion)
- Typically, performance overhead is minimal, but it can exist depending on the use case

=== COMPARISON ===
Iterator stands more independently compared to other patterns.
For comparison, it can be contrasted with a traditional for loop.

Iterator:
- Interface-based
- Removes traversal algorithm from the client
- No index available
- Helps prevent concurrent modification issues

For loop:
- Traversal code is pushed onto the client
- Provides access to an index
- Doesn't change the underlying object in some scenarios - if it does, then it may not be clean (check IteratorUsageOverForLoop.java)
- Cannot use for-each syntax unless the object implements Iterable
- Typically slower than iterator, though performance depends on underlying collection

PTR: for loop doesn't let safe removal from collection, iterator does it better - check IteratorUsageOverForLoop.java

=== SUMMARY ===
- Iterator is an efficient way to traverse a collection's structure
- Hides traversal algorithm from the client
- Simplifies client code by removing traversal complexity
- Can add extra functionality such as security, caching, or lazy data retrieval (e.g., from a database)
- Improves code value, functionality, and sometimes performance
- Supports use of the modern for-each syntax via the Iterable interface
- Pitfalls exist (like no index, unidirectional by default), but can be managed if understood