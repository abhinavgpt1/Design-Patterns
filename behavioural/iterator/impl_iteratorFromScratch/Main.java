public class Main {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<>();
        collection.addItem("Collection1_Item1");
        collection.addItem("Collection1_Item2");
        collection.addItem("Collection1_Item3");

        IIterator<String> it1 = collection.myIterator();
        while (it1.hasNext()) {
            String item = it1.next();
            System.out.println(item);
        }
        System.out.println();

        MyCollectionUsingList<String> collectionUsingListInternally = new MyCollectionUsingList<>();
        collectionUsingListInternally.addItem("Collection2_Item1");
        collectionUsingListInternally.addItem("Collection2_Item2");
        collectionUsingListInternally.addItem("Collection2_Item3");

        IIterator<String> it2 = collectionUsingListInternally.myIterator();
        while (it2.hasNext()) {
            String item = it2.next();
            System.out.println(item);
        }
        System.out.println();

        // PTR: No for-each is possible for MyCollection or MyCollectionUsingList
        // since none implements Iterable.
    }
}

/**
 * Output:
 * -------
 * Note: .\MyCollection.java uses unchecked or unsafe operations.
 * Note: Recompile with -Xlint:unchecked for details.
 * Collection1_Item1
 * Collection1_Item2
 * Collection1_Item3
 * 
 * Collection2_Item1
 * Collection2_Item2
 * Collection2_Item3
 */