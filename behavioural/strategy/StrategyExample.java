import java.util.Arrays;
import java.util.Comparator;

class Person {
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
}
public class StrategyExample {
    public static void main(String[] args) {
        // Comparators can be used as strategies to sort array in different ways
        
        Comparator<Person> byNameAsc = new Comparator<>() { // lambda can be used too, but using anonymous class for clarity
            @Override
            public int compare(Person p1, Person p2) {
                return p1.name.compareTo(p2.name);
            }
        };
        Comparator<Person> byAgeAsc = (p1, p2) -> p1.age - p2.age; // or Integer.compare(p1.age, p2.age);

        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 20)
        };

        Arrays.sort(people, byNameAsc); // or use Collections.sort(Arrays.asList(people), byNameAsc);
        System.out.println("Sorted by name: " + Arrays.toString(people));

        Arrays.sort(people, byAgeAsc);
        System.out.println("Sorted by age: " + Arrays.toString(people));

        // Another example could be different payment strategies in a shopping cart
        // OR Sort an array using different algorithms (bubble sort, quicksort, etc.) as strategies
        // Check: https://github.com/abhinavgpt1/Learn-DSA/blob/150c5042d12db8ec8c6392c81a64e6ee90c62ac5/DSA-self/03_DS_extra/SortingAlgos_StrategyDP.java
    }
}

/**
 * Output:
 * -------
 * Sorted by name: [Alice (30), Bob (25), Charlie (20)]
 * Sorted by age: [Charlie (20), Bob (25), Alice (30)]
 */