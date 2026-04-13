import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BikeRepository repo = new BikeRepository();
        repo.addBike("Yamaha");
        repo.addBike("Honda");
        repo.addBike("Suzuki");

        Iterator<String> it = repo.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println();

        // PTR: foreach loop internally uses iterator
        // this works only because BikeRepository implements Iterable interface
        for(String bike : repo) {
            System.out.println(bike);
        }
    }
}

/**
 * Output:
 * -------
 * Yamaha
 * Honda
 * Suzuki
 * 
 * Yamaha
 * Honda
 * Suzuki
 */