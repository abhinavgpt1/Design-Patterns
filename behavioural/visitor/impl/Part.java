interface Part {
    // Element's function which delegates to Visitor to handle business logic
    void accept(PartVisitor visitor);
}