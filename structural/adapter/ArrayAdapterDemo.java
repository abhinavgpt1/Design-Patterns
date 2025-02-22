import java.util.Arrays;
import java.util.List;

public class ArrayAdapterDemo {
    public static void main(String[] args) {
        Integer [] arr = new Integer[] {1,2,3};
        List<Integer> lst = Arrays.asList(arr);
        System.out.println(arr); // [Ljava.lang.Integer;@3fee733d
        System.out.println(lst); // [1, 2, 3]   
    }
}
