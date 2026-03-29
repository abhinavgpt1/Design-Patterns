// Note: This code is still vulnerable. Attacker can use reflection and set dbSingleton to null, enabling constructor to work.
// Soln: use enum for DbSingleton. Reflection doesn't work for enum. It throws IllegalArgumentException for new enum()

// In case of additional field, say private Connection connection, code remains same expect you add intialisation of connection inside synchronized block with monitor on DbSingleton.class
// FYI, reflection can still be used to convert accessibility of private connection field to public. Soln: Eagerly loading with private final connection field. Modern JVM doesn't let accessibility of static final fields to be changed.

// Note: Reflection is an internal attack vector, not an external exploit. If a hacker has already managed to inject and execute custom Java reflection code inside your running application, they don't need to steal your Connection object.
class DbSingleton
{
    private static volatile DbSingleton dbSingleton = null;
    // It ensures that the variable is always read from and written to the main memory,
    // rather than from thread-specific caches, ensuring visibility across threads
    // https://www.geeksforgeeks.org/volatile-keyword-in-java/#:~:text=Volatile%20variables%20have%20the%20visibility%20features%20of%20synchronized%20but%20not%20the%20atomicity%20features.%20The%20values%20of%20the%20volatile%20variable%20will%20never%20be%20cached%20and%20all%20writes%20and%20reads%20will%20be%20done%20to%20and%20from%20the%20main%20memory

    private DbSingleton() throws RuntimeException{
        // Java Reflection API can be used to bypass private property of this constructor during instantiation.
        if (dbSingleton != null) {
            throw new RuntimeException("Use getInstance() for getting object");
        }
    }

    public static DbSingleton getInstance() { // static imp.
        // to make this function thread safe, we can make entire function synchronized -> low peformance as mostly this function will be called to fetch the instance and not create
        if (dbSingleton == null) {
            synchronized(DbSingleton.class){ // prevent multiple access to static members which are in synchronized block. Other members can still be accessed during this lock period
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
        System.out.println(singleton1.hashCode());
        System.out.println(singleton1.hashCode() == singleton2.hashCode());
        // hashcode != memory address
        // https://stackoverflow.com/questions/16418713/does-hashcode-number-represent-the-memory-address
    }
}
/*
 * Output:
 * -------
 * DbSingleton@36baf30c
 * DbSingleton@36baf30c
 * true
 */