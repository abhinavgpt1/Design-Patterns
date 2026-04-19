public class Main {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Person alice = new Person("Alice", "123-456-7890");
        System.out.println("Alice initially: " + alice);
        
        // Saving before modification 1
        caretaker.save(alice);
        alice.setPhone("888-999-1111");
        System.out.println("Alice after phone update: " + alice);
        
        // Saving before modification 2
        caretaker.save(alice);
        alice.setPhone("222-222-2222");
        System.out.println("Alice after another phone update: " + alice);
        
        // Reverting state: sets phone to 888-999-1111
        caretaker.revert(alice);
        System.out.println("Alice after state revert: " + alice);
        
        // Reverting state: sets phone to 123-456-7890
        caretaker.revert(alice);
        System.out.println("Alice after another state revert: " + alice);
    }
}
/**
 * Output:
 * -------
 * Alice initially: (Alice, 123-456-7890)
 * Alice after phone update: (Alice, 888-999-1111)
 * Alice after another phone update: (Alice, 222-222-2222)
 * Alice after state revert: (Alice, 888-999-1111)
 * Alice after another state revert: (Alice, 123-456-7890)
 */