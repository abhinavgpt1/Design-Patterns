class MyClass {
    private String[] items;
    private int size;

    MyClass() {
        items = new String[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public String getItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items[index];
    }

    public void addItem(String item) {
        if (size == items.length) {
            String[] newItems = new String[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        items[size++] = item;
    }

    public MyIterator myIterator() {
        return new MyClassMyIterator(this);
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.addItem("Item1");
        myClass.addItem("Item2");
        myClass.addItem("Item3");

        MyIterator it = myClass.myIterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }
    }
}

/**
 * Output:
 * -------
 * Item1
 * Item2
 * Item3
 * 
 */