public class MyCollection<T> {
    private T[] items;
    private int size;

    public MyCollection() {
        // items = new T[10];
        /**
         * qq: Why generic array creation is not allowed here?
         * ans: It's not allowed because the type of the array should be known at compile time.
         * 
         * Java uses type erasure for generics:
         * - At runtime, T is not known (it becomes Object or its bound)
         * - But arrays do know and enforce their element type at runtime
         * - This creates a conflict.
         * 
         * Soln 1: cast Object[] : Gives an unchecked cast warning.
         * - Reason: the compiler asks:
         * - "How do I know this Object[] really holds only T elements?"
         * - It can’t prove it, so it issues an unchecked cast warning.
         * - eg. items[0] = (T) new Integer(5); // suppose T is actually String.
         * - This compiles (with warnings), but may fail later in subtle ways.
         * 
         * Soln 2 [PREFERRED]: Use List : No type-safety issues, no casting required.
         * - List<T> items = new ArrayList<>();
         */

        items = (T[]) new Object[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public T getItem(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items[index];
    }

    public void addItem(T item) {
        if (size == items.length) {
            T[] newItems = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
        }
        items[size++] = item;
    }

    // Extra: there can be remove(item) and remove(index) functions too

    public IIterator<T> myIterator() {
        return new MyCollectionIterator(this);
    }

    class MyCollectionIterator implements IIterator<T> {
        MyCollection<T> collection;
        int index = 0;

        MyCollectionIterator(MyCollection<T> collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return index < collection.getSize();
        }

        @Override
        public T next() {
            if (index >= collection.getSize()) {
                throw new IndexOutOfBoundsException("No more elements");
            }
            return collection.getItem(index++);
        }
    }
}