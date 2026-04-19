import java.time.Instant;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    // Timer: schedules and coordinates execution of tasks. No task knows about the other.
    private final Timer timer; // mediator

    public TimerDemo() {
        timer = new Timer();
    }

    public void scheduleTasks(int delayInMillisecond) {
        System.out.println("Schduled tasks at: " + Instant.now());
        timer.schedule(new RemindTaskA(), delayInMillisecond); // task scheduled after 'delayInMillisecond' from above sout
        timer.schedule(new RemindTaskB(), 2 * delayInMillisecond); // task scheduled after 2 * 'delayInMillisecond'
    }

    class RemindTaskA extends TimerTask {
        @Override
        public void run() {
            System.out.println("Remind Task A - " + Instant.now());
        }
    }

    class RemindTaskB extends TimerTask {
        @Override
        public void run() {
            System.out.println("Remind Task B - " + Instant.now());
            timer.cancel(); // Terminate the timer thread
        }
    }

    public static void main(String[] args) {
        int delayInMillisecond = 5000; // 5 sec
        TimerDemo timerDemo = new TimerDemo();
        timerDemo.scheduleTasks(delayInMillisecond);

        // cancel() can't be in main, since timer tasks run asynchronouly i.e. on different threads, and would cancel them before they even run.
        // timerDemo.timer.cancel();
    }
}

/**
 * Output:
 * -------
 * Schduled tasks at: 2026-04-19T06:28:05.052698500Z
 * Remind Task A - 2026-04-19T06:28:10.092661800Z
 * Remind Task B - 2026-04-19T06:28:15.092694500Z
 */