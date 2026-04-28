public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println(fan); // OFF
        fan.pullChain(); System.out.println();

        System.out.println(fan); // LOW
        fan.pullChain(); System.out.println();

        System.out.println(fan); // MEDIUM
        fan.pullChain(); System.out.println();

        System.out.println(fan); // OFF
        fan.pullChain(); System.out.println();

        System.out.println(fan); // LOW

        // Advantage of State pattern:
        // 1. Single Responsibility Principle: Each state class has its own behavior.
        // 2. Open-Closed Principle: Adding new states doesn't require changing existing code. I feel context driven transition is more OCP centric.
        // 3. Easier Maintenance: Changing behavior of a state is localized to that state.
        // 4. Debugging: Easier to debug state-specific issues. (although there's a pitfall to this as well)
        // 5. Clean and simpler code - no more big if-else structure. (although there's a pitfall on debugging & understaning the flow of system here)

        // PTR: There's no point in putting toString as abstract method in FanState interface 
        // since its definition comes from Object by default and will be implemented/overrided by default.
    }
}
/**
 * Output:
 * -------
 * toString(): Fan is OFF
 * pullChain(): Fan turned to LOW
 * 
 * toString(): Fan is LOW
 * pullChain(): Fan turned to MED
 * 
 * toString(): Fan is MED
 * pullChain():Fan turned to OFF
 * 
 * toString(): Fan is OFF
 * pullChain(): Fan turned to LOW
 * 
 * toString(): Fan is LOW
 */