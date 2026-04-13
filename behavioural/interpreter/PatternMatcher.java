import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String input = "lions, tigers and bears are all present in zoo.";
        Pattern p = Pattern.compile("(lion|tiger|bear)");
        Matcher m = p.matcher(input);
        while (m.find()) {
            System.out.println("Found a " + m.group());
        }
    }
}

/**
 * Output:
 * -------
 * Found a lion
 * Found a tiger
 * Found a bear
 */