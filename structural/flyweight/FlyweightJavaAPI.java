public class FlyweightJavaAPI {
    public static void main(String[] args) {
        Integer firstInt = Integer.valueOf(5);
        Integer secInt = Integer.valueOf(5);
        Integer thirdInt = Integer.valueOf(10);
        System.out.println(System.identityHashCode(firstInt));
        System.out.println(System.identityHashCode(secInt));
        System.out.println(System.identityHashCode(thirdInt));

        // System.out.println(firstInt.hashCode()); // not a good check as it returns firstInt itself
        // System.out.println(secInt.hashCode());
        Long firstLong = Long.valueOf(100);
        Long secLong = Long.valueOf(110);
        Long thirdLong = Long.valueOf(100);
        System.out.println(System.identityHashCode(firstLong));
        System.out.println(System.identityHashCode(thirdLong));
        System.out.println(System.identityHashCode(secLong));

        //same example for strings
        String firstString = "xyz";
        String secondString = "xyz";
        System.out.println(firstString.hashCode());
        System.out.println(secondString.hashCode());
    }    
}
