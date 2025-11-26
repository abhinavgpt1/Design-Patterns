public class RunnableExample {
    public static void main(String[] args) {
        Task task = new Task(5, 10); // encapsulating the request
        Task task2 = new Task(20, 30);
        Thread thread1 = new Thread(task); // invoker i.e. processor and actual tasks / definition are decoupled
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();        
        // receiver in this case is the console window
    }
}

class Task implements Runnable {
    int num1, num2;
    Task(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    @Override
    public void run() {
        System.out.println("num1 + num2: " + (num1 + num2));
    }
}