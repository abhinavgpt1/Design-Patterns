import java.util.StringTokenizer;

public class StringTokenizerDemo {
    public static void main(String[] args) {
        /**
         * StringTokenizer lets you treat a String like an iterator, which it was never
         * originally designed to be.
         * 
         * Explanation:
         * StringTokenizer is an example of the Adapter pattern because it wraps a
         * String and provides a new interface (hasMoreTokens(), nextToken()) to access
         * it as a sequence of tokens. It converts a plain string into an iterable form
         * without modifying the original String, thereby adapting one interface to
         * another.
         */
        String emp = "106877,  Sherlock,Holmes,sherlockholmes@gmail.com";
        StringTokenizer tokenizer = new StringTokenizer(emp, ",");
        if (tokenizer.hasMoreTokens()) {
            System.out.println(Integer.parseInt(tokenizer.nextToken()));
        }
        if (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
        if (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
