import java.util.StringTokenizer;

public class Demo {
    public static void main(String[] args) {
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
