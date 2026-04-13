public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println(fan); // OFF
        fan.pullChain();
        System.out.println(fan); // LOW
        fan.pullChain();
        System.out.println(fan); // MEDIUM
        fan.pullChain();
        System.out.println(fan); // OFF
        fan.pullChain();
        System.out.println(fan); // LOW

        // Advantage of State pattern:
        // 1. Open/Closed Principle: Adding new states doesn't require changing existing code.
        // 2. Single Responsibility Principle: Each state class has its own behavior.
        // 3. Easier Maintenance: Changing behavior of a state is localized to that state
        // 4. Debugging: Easier to debug state-specific issues.
        // 5. Clean and simpler code - no more big if-else structure.

        // PTR: Java code runner in vscode doesn't compile a .java file if .class already exists.
        // PTR: There's no point in putting toString as abstract method in FanState interface since its definition comes from Object by default.
    }
}
/**
 * Output:
 * -------
 * toString(): Fan is OFF
 * pullChain(): Fan turned to LOW
 * toString(): Fan is LOW
 * pullChain(): Fan turned to MED
 * toString(): Fan is MED
 * pullChain(): Fan turned to OFF
 * toString(): Fan is OFF
 * pullChain(): Fan turned to LOW
 * toString(): Fan is LOW
 */