/**
 * ============================================================================
 * BILL PUGH SINGLETON DESIGN PATTERN (Initialization-on-Demand Holder Idiom)
 * ============================================================================
 *
 * THEORY & HOW IT WORKS:
 * 1. Lazy Initialization:
 *    When the outer class {@code BillPughSingleton} is loaded by the JVM, the
 *    private static inner class {@code SingletonHelper} is NOT loaded into
 *    memory. It is loaded only when {@code getInstance()} is called for the
 *    very first time.
 *
 * 2. Thread-Safety Without 'synchronized' or 'volatile':
 *    According to the Java Language Specification (JLS §12.4.2), class
 *    initialization is guaranteed to be serial and thread-safe. If Thread A
 *    and Thread B call {@code getInstance()} at the exact same time:
 *      - The JVM acquires an internal Class Initialization Lock (LC).
 *      - Thread A initializes {@code SingletonHelper} and creates {@code INSTANCE}.
 *      - Thread B waits until Thread A finishes constructor execution.
 *      - Thread B then receives the already-created {@code INSTANCE}.
 *
 * 3. Zero Locking Overhead After Initialization:
 *    Once {@code SingletonHelper} is initialized, subsequent threads (Thread C,
 *    Thread D, etc.) do NOT acquire any lock. They read the {@code static final}
 *    reference in parallel with full memory visibility guaranteed by the Java
 *    Memory Model (JMM).
 */
public class BillPughSingleton {

    // Private constructor prevents direct instantiation using 'new'
    private BillPughSingleton() {
        System.out.println("Singleton instance created by: " + Thread.currentThread().getName());
    }

    /**
     * Private static inner helper class.
     * Loaded by the JVM only upon first reference to {@code SingletonHelper.INSTANCE}.
     */
    private static class SingletonHelper {
        // 'static final' guarantees visibility across all threads after class init
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    /**
     * Global access point to the single instance.
     *
     * @return the single {@code BillPughSingleton} instance
     */
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void showMessage() {
        System.out.println("Handled by " + Thread.currentThread().getName()
                + " -> Instance hashCode: " + this.hashCode());
    }

    // ========================================================================
    // DEMO: Simulating concurrent access (Threads A & B, then Threads C & D)
    // ========================================================================
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main started. Notice Singleton is NOT created yet.\n");

        Runnable task = () -> {
            BillPughSingleton singleton = BillPughSingleton.getInstance();
            singleton.showMessage();
        };

        // Phase 1: Thread-A and Thread-B race to initialize the Singleton
        Thread threadA = new Thread(task, "Thread-A");
        Thread threadB = new Thread(task, "Thread-B");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("\n--- Instance is now initialized (Lock-free phase) ---\n");

        // Phase 2: Thread-C and Thread-D read INSTANCE concurrently without any lock
        Thread threadC = new Thread(task, "Thread-C");
        Thread threadD = new Thread(task, "Thread-D");

        threadC.start();
        threadD.start();

        threadC.join();
        threadD.join();
    }
}