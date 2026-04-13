import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorUsageOverForLoop {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");


        // for(int i=0; i<list.size(); i++) {
        //     if(i % 2 == 0)
        //         list.remove(i); // ConcurrentModificationException
        // }
        // System.out.println(list); // BCEF

        int idx = 0;
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            it.next();
            if(idx % 2 == 0)
                it.remove(); // Safe removal during iteration
            idx++;
        }
        System.out.println(list); // BDF - which is correct
    }
}
