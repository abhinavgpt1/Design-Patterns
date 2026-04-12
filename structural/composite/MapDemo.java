import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> personAttr = new HashMap<>();
        personAttr.put("height", "person");
        personAttr.put("vocal tone", "person");

        Map<String, String> groupAttr = new HashMap<>();
        groupAttr.put("collaboration", "group");

        Map<String, String> communityAttr = new HashMap<>();
        communityAttr.putAll(personAttr);
        communityAttr.putAll(groupAttr);
        // This way each map is treated as composite of prev. one.
        // A Map<String, String> groups multiple key-value pairs into a single object,
        // allowing them to be treated as one unit, which conceptually resembles the
        // Composite pattern (though it is not a strict implementation).

        System.out.println(communityAttr);
    }
}

/**
 * Output:
 * -------
 * {vocal tone=person, collaboration=group, height=person}
 */