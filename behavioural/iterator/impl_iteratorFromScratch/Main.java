public class Main {
    public static void main(String[] args) {
        MyCollection<String> collection = new MyCollection<>();
        collection.addItem("Item1");
        collection.addItem("Item2");
        collection.addItem("Item3");

        IIterator<String> it = collection.myIterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }

        // PTR: No for-each is possible for MyCollection since it doesn't implement Iterable.
    }
}

/**
 * Output:
 * -------
 * Item1
 * Item2
 * Item3
 */