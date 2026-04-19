public class RunnableDemo {
    public static void main(String[] args) {
        // Runnable acts as a Command since it encapsulates the request.
        Task task = new Task(5, 10);
        Task task2 = new Task(20, 30);

        // Thread acts as an Invoker. Actual task / definition is decoupled.
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        // Receiver in this case is the console window
    }
}

class Task implements Runnable {
    int num1, num2;

    Task(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    // This is the command definition, and not the receiver.
    // The receiver is the object which does the work, which is the console window in our case i.e. to print.
    // In our case, command itself is acting as the receiver logic holder.
    @Override
    public void run() {
        System.out.println("num1 + num2: " + (num1 + num2));
    }
}

/**
 * Output:
 * -------
 * num1 + num2: 50
 * num1 + num2: 15
 */