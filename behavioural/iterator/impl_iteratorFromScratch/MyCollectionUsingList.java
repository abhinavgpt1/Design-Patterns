import java.util.ArrayList;
import java.util.List;

public class MyCollectionUsingList<T> {
    private List<T> items;

    public MyCollectionUsingList() {
        // Since collection uses List<T> items instead of T[]
        // You'll notice how convienient it is.
        items = new ArrayList<>();
    }

    public int getSize() {
        return items.size();
    }

    public T getItem(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return items.get(index);
    }

    public void addItem(T item) {
        items.add(item);
    }

    // Extra: there can be remove(item) and remove(index) functions too

    public IIterator<T> myIterator() {
        return new MyCollectionUsingIterator(this);
    }

    class MyCollectionUsingIterator implements IIterator<T> {
        MyCollectionUsingList<T> collection;
        int index = 0;

        MyCollectionUsingIterator(MyCollectionUsingList<T> collection) {
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