import java.util.HashMap;
import java.util.Map;

public class CompositeDemoJavaUtil {
    public static void main(String[] args) {
        Map<String, String> personAttr = new HashMap<>();
        personAttr.put("height", "person");
        personAttr.put("vocal tone", "person");
        Map<String, String> groupAttr = new HashMap<>();
        groupAttr.put("collaboration", "group");
        
        Map<String, String> communityAttr = new HashMap<>();
        communityAttr.putAll(personAttr);
        communityAttr.putAll(groupAttr);
        // this way each map is treated as composite of prev. one

        System.out.println(communityAttr);
        
    }   
}
