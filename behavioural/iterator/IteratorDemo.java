import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String name = it.next();
            System.out.println(name);

            if (name.equals("Bob")) {
                it.remove(); // Safe removal during iteration
            }
        }
        // PTR: advantage of using iterator is that if the underlying data structure
        // changes, the code will still work. eg. Set, LinkedList, ArrayDeque
        System.out.println();

        // PTR:
        // - for-each loop internally uses iterator
        // - This works only because List implements Iterable interface (List ->
        // Collection -> Iterable)
        for (String name : names) {
            System.out.println(name);
        }

        // PTR: Map doesn't have iterator functionality -> iterate over keySet(),
        // entrySet() or values()
        Map<String, Integer> nameToAge = new HashMap<>(); // can use TreeMap too
        nameToAge.put("Darwin", 30);
        nameToAge.put("Einstein", 76);
        Iterator<String> keyIterator = nameToAge.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer age = nameToAge.get(key);
            System.out.println(key + " is " + age + " years old.");
        }
        System.out.println();
    }
}

/**
 * Output:
 * -------
 * Alice
 * Bob
 * Charlie
 * 
 * Alice
 * Charlie
 * 
 * Einstein is 76 years old.
 * Darwin is 30 years old.
 */