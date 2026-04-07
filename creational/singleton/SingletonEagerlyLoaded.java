// Thread-safe
class DbSingleton {
    // Eagerly loaded -> whether or not we require this in our application, object gets created
    private static DbSingleton dbSingleton = new DbSingleton(); // Can make this instance final

    private DbSingleton() {
        // missing reflectionAPI check i.e. 
        // if(instance != null) { 
        // throw new IllegalStateException("Singleton instance already exists"); 
        // }
    }

    public static DbSingleton getInstance() { // static imp.
        return dbSingleton;
    }
}

public class SingletonEagerlyLoaded {
    public static void main(String args[]) {
        DbSingleton singleton1 = DbSingleton.getInstance();
        System.out.println(singleton1);
        // DbSingleton singleton2 = new DbSingleton(); //constructor not visible
        DbSingleton singleton2 = DbSingleton.getInstance();
        System.out.println(singleton2);
        System.out.println(singleton1 == singleton2);
    }
}
/*
 * Output:
 * -------
 * DbSingleton@36baf30c
 * DbSingleton@36baf30c
 * true
 */