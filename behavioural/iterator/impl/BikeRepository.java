import java.util.Iterator;
import java.util.NoSuchElementException;

public class BikeRepository implements Iterable<String> {
    private String[] bikes;
    int size;
    BikeRepository() {
        bikes = new String[10]; //init capacity=10
        size = 0;
    }

    public void addBike(String bike) {
        if(size == bikes.length) {
            String[] newBikes = new String[bikes.length * 2];
            System.arraycopy(bikes, 0, newBikes, 0, bikes.length);
            bikes = newBikes;
        }
        bikes[size++] = bike;
    }

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public String next() {
                if (index >= size)
                    throw new NoSuchElementException();
                return bikes[index++];
            }
            
        };
        return it;
    }
}
