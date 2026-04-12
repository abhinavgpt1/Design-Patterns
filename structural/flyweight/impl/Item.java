// Immutable inventory item. Contains private final property, no setters, no manipulating functions.
// Acts as flyweight since instantiation isn't needed more than once (as per our use case).
public class Item {
    private final String name;

    public Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
