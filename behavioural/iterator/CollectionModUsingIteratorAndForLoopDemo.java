import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionModUsingIteratorAndForLoopDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        // // Using for loop for removal: Results in wrong output
        // for (int i = 0; i < list.size(); i++) {
        //     if (i % 2 == 0) {
        //         list.remove(i);
        //     }
        // }
        // System.out.println(list); // BCEF [WRONG]

        int idx = 0;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            it.next();

            if (idx % 2 == 0)
                it.remove(); // it.remove() is safe becoz it controls modification.
            idx++;
        }
        System.out.println(list); // BDF [CORRECT]
    }
}

/**
 * Output:
 * -------
 * [B, D, F]
 */