import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String name = it.next();
            System.out.println(name);

            if(name.equals("Bob")) {
                it.remove(); // Safe removal during iteration
            }
        }
        // PTR: advantage of using iterator is that if the underlying data structure changes, the code will still work. eg. Set, LinkedList, ArrayDeque
        System.out.println();
        
        // PTR: Map doesn't have iterator functionality -> iterate over keySet(), entrySet() or values()
        Map<String, Integer> nameToAge = new HashMap<>(); // can use TreeMap too
        nameToAge.put("Darwin", 30);
        nameToAge.put("Einstein", 76);
        Iterator<String> keyIterator = nameToAge.keySet().iterator();
        while(keyIterator.hasNext()) {
            String key = keyIterator.next();
            Integer age = nameToAge.get(key);
            System.out.println(key + " is " + age + " years old.");
        }

        // PTR: foreach loop internally uses iterator
        for(String name : names) { // this works only because List implements Iterable interface (List -> Collection -> Iterable)
            System.out.println(name);
        }
    }
}

/**
 * Output:
 * -------
 * Alice
 * Bob
 * Charlie
 * 
 * Darwin is 30 years old.
 * Einstein is 76 years old.
 */