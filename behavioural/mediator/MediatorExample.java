import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class MediatorExample {
    private final Timer timer; // acts as mediator. It schedules tasks and coordinates their execution. Either task doesn't know about the other.
    MediatorExample(int seconds) {
        timer = new Timer();
        System.out.println("Schduled tasks at: " + Instant.now());
        timer.schedule(new RemindTaskA(), seconds * 1000); //scheduled after 5 seconds
        timer.schedule(new RemindTaskB(), seconds * 2 * 1000); //scheduled after 10 seconds
    }

    class RemindTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("remind task A - " + Instant.now());
        }
    }
    class RemindTaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("remind task B - " + Instant.now());
            timer.cancel(); // Terminate the timer thread
        }
    }
    public static void main(String[] args) {
        MediatorExample me = new MediatorExample(5);
        // me.timer.cancel(); // can't have it here since processes are async
    }
}

/**
 * Output:
 * -------
 * Schduled tasks at: 2025-10-02T11:10:22.461939Z
 * remind task A - 2025-10-02T11:10:27.475666Z
 * remind task B - 2025-10-02T11:10:32.474921Z
 */