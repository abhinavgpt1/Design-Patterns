## Abstract Factory Pattern
- Def: The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. 
It acts as a "factory of factories," where a super-factory creates other factories that in turn produce specific objects.

### Overview
Implemented as a "factory of factories." It's called the factory of related objects and takes the common interface concept to another level, involving subclass instantiation.

### Examples
- `DocumentBuilderFactory` (Java XML APIs)
- Frameworks

## Design

### Core Structure
- **Group of Factories**: Organizes multiple factories under a common interface
- **Instantiation**: Performs factory instantiation under the common interface
- **Parameterized Factory Creation**: Factory is returned based on a parameter passed (inside AbstractFactory create() method)
- **Composition-Based**: Uses composition (key distinction from Factory pattern) == has-a relationship. In the example, Main/Client has-a ICarCompanyFactory. Actually factory gets swapped easily from MercedesFactory to TataFactory. This can't be said so for Factory Pattern since CarFactory isn't initialised in Main, but we use getCar straightaway. Also, there's no need for factory class instantiation since object creation happens inside sub-class via common interface method.
- **Hidden Implementation**: Goal is to hide implementation from both client and abstractFactory

### Key Principle
- Right factory and concrete classes are determined based on parameters
- Client receives functionality through interface (interface reference)
- Client only interacts with interfaces, be it abstractFactory or abstractProduct

**Quote [GFG]:** "The client does not know or care which concrete objects it gets from each of these concrete factories since it uses only the generic interfaces of their products."

### Structure
- AbstractFactory creates Factory
- Factory creates Product (subclass of AbstractProduct)

## Real-World (pluralsight) Examples

### Credit Card Factory
- Client provides credit score
- Based on score, provide Amex or Visa card
- Client can then choose Gold or Platinum:
  - creditScore > 650 → AmexFactory
  - Otherwise → VisaFactory (named CreditCardFactory)

### Database Connections
- DriverManager for all DBs - SQLServer, MySQL, Oracle
- Execute queries using abstract function - execute(), executeUpdate(), executeQuery()

### Location-Based Car Provider
- Provides Mini, Luxury, or Micro cars based on location
- Reference: https://www.geeksforgeeks.org/abstract-factory-pattern/

## When to Use

[GFG] Use when:
- System must be independent in object creation, composition, and representation
- A family of related objects must be used together
- You want to provide an object library showing only interfaces and not implementations
- System must be configured with one of several families (factories) of objects

## Pitfalls

1. **Most Complex Pattern**: The most complex design pattern to implement

2. **Runtime Parameter Concern**: Client can deduce from the use of parameters about the class being returned, hence it seems to expose bit of impl., but it isn't since sub-class implementation logic isn't exposed.

3. **Pattern Within a Pattern**: Combines patterns (grouping of factories) for specific problems

4. **Evolutionary Design**: Often starts as Factory, then refactored to AbstractFactory

## Factory vs. Abstract Factory

| Aspect | Factory | Abstract Factory |
|--------|---------|------------------|
| **Returns** | Various instances | Various instances with families |
| **Implementation** | Direct | 99% implemented with Factory |
| **Hiding** | N/A | Hides concrete factories |
| **Abstraction** | Single level | Additional layer of abstraction |
| **Construction** | Direct | Composition-based |
| **Complexity** | Moderate | Heavily abstracted (interfaces, contracts, composition) |
| **Pattern Type** | Solves specific problem | Framework pattern |
| **Interface** (Similarity) | Interface-driven, adaptable to environment | Interface-driven, adaptable |

## Summary

- Most complex among Gang of Four patterns
- Extends Factory to manage families of related objects
- Critical in framework design
- Provides flexibility for multiple object families