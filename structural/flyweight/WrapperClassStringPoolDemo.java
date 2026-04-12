public class WrapperClassStringPoolDemo {
    public static void main(String[] args) {
        // Wrapper class example
        Integer firstInt = Integer.valueOf(5);
        Integer secondInt = Integer.valueOf(5);
        Integer thirdInt = Integer.valueOf(10);
        // firstInt.hashCode() == firstInt by definition, hence validation like
        // firstInt.hashCode() == secondInt.hashCode() is inappropriate.
        System.out.println(System.identityHashCode(firstInt)); // 498931366
        System.out.println(System.identityHashCode(secondInt)); // 498931366
        System.out.println(System.identityHashCode(thirdInt)); // 2060468723

        System.out.println();

        Long firstLong = Long.valueOf(100);
        Long secondLong = Long.valueOf(100);
        Long thirdLong = Long.valueOf(110);
        System.out.println(System.identityHashCode(firstLong)); // 622488023
        System.out.println(System.identityHashCode(secondLong)); // 622488023
        System.out.println(System.identityHashCode(thirdLong)); // 1933863327

        System.out.println();

        // String pool example
        String firstString = "xyz";
        String secondString = "xyz";
        System.out.println(System.identityHashCode(firstString)); // 112810359
        System.out.println(System.identityHashCode(secondString)); // 112810359
        System.out.println(firstString.hashCode() + ", " + secondString.hashCode()); // 119193, 119193

        // Note: Two equal objects will have equal hashCode, but vice-versa is NOT true.
    }
}

/**
 * Output:
 * -------
 * 498931366
 * 498931366
 * 2060468723
 * 
 * 622488023
 * 622488023
 * 1933863327
 * 
 * 112810359
 * 112810359
 * 119193, 119193
 */