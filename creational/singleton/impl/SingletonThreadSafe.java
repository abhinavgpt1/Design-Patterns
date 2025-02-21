class DbSingleton
{
    private static volatile DbSingleton dbSingleton = null;
    // It ensures that the variable is always read from and written to the main memory,
    // rather than from thread-specific caches, ensuring visibility across threads

    private DbSingleton() throws RuntimeException{
        // java reflection API can be used to bypass private constructor to instantiate this class
        if (dbSingleton != null) {
            throw new RuntimeException("Use getInstance() for getting object");
        }
    }

    public static DbSingleton getInstance() { // static imp.
        // to make this function thread safe, we can make entire function synchronized -> low peformance as mostly this function will be called to fetch the instance and not create
        if (dbSingleton == null) {
            synchronized(SingletonThreadSafe.class){
                // what if 'x' threads enter reach here at the same time -> all will instantiate -> dbSingelton gets extra x-1 re-assignment
                if(dbSingleton == null)
                    dbSingleton = new DbSingleton();
            }
        }
        return dbSingleton;
    }
}

public class SingletonThreadSafe {
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