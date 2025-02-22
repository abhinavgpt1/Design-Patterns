//immutable object -> private final property (no setters, no manipulating functions)
//acts as flyweight (as it got light)
public class Item {
    private final String name;
    Item(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
