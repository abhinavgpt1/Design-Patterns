import java.util.Arrays;
import java.util.List;

public class ArraysAsListDemo {
    public static void main(String[] args) {
        /**
         * Arrays.asList() is an example of the Adapter pattern because it wraps an
         * array and exposes it as a List interface. It allows you to use array data
         * with List methods without modifying the original array, thereby adapting the
         * array interface to the List interface.
         * 
         * - Adaptee → Integer[] arr (array)
         * - Adapter → Arrays.asList()
         * - Target Interface → List
         */
        Integer[] arr = new Integer[] { 1, 2, 3 };
        List<Integer> lst = Arrays.asList(arr);
        System.out.println(arr); // [Ljava.lang.Integer;@3fee733d
        System.out.println(lst); // [1, 2, 3]
    }
}
