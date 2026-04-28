import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    // compareTo() acts as Template - the parent (Comparable) calls the child's i.e. Person's compareTo() method
    // This will become more evident in impl & Main.java example
    @Override
    public int compareTo(Person p2) {
        return this.age - p2.age;
    }
}

public class ComparatorDemo {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 25);
        Person charlie = new Person("Charlie", 20);

        List<Person> people = new ArrayList<>();
        people.add(alice);
        people.add(bob);
        people.add(charlie);
        System.out.println("People list before sort: " + people);

        // Passing comparator is like using strategy pattern.
        // Here, the algo remins same (TimSort) hence it's an example of Template
        Collections.sort(people);
        System.out.println("People list after sort: " + people);
    }
}

/**
 * Output:
 * -------
 * People list before sort: [Alice (30), Bob (25), Charlie (20)]
 * People list after sort: [Charlie (20), Bob (25), Alice (30)]
 */