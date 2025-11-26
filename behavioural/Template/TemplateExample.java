import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    // acts as Template - the parent (Comparable) calls the child's (this) method
    // This will become more evident in Main.java example
    @Override
    public int compareTo(Person p2) {
        return this.age - p2.age;
    }
}

public class TemplateExample {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 30);
        Person bob = new Person("Bob", 25);
        Person charlie = new Person("Charlie", 20);

        List<Person> people = new ArrayList<>();
        people.add(alice);
        people.add(bob);
        people.add(charlie);
        System.out.println("People list before sort: " + people);
        
        // We don't pass comparators unlike strategy pattern.
        // The algo remins same but the inner part changes.
        // PTR: Comparator vs Comparable
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