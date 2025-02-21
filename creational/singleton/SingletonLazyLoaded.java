// not thread safe
class DbSingleton {
    private static DbSingleton dbSingleton = null;

    private DbSingleton() {
    }

    public static DbSingleton getInstance() { // static imp.
        if (dbSingleton == null) {
            dbSingleton = new DbSingleton(); // lazy loaded -> substantial performance improvement of application. 
            //Say, in an application there are a lot of singleton classes (logger, DB connection, etc) 
            //-> then if lazy loading is not done then, app will take a lot time to set up these instances
        }
        return dbSingleton;
    }
}

public class SingletonLazyLoaded {
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