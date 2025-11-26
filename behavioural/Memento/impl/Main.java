public class Main {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Employee emp = new Employee("Alice", "123-456-7890");
        System.out.println("Initial State of Alice: " + emp);
        caretaker.save(emp);

        emp.setPhone("888-999-1111");
        caretaker.save(emp);
        System.out.println("After Phone Update of Alice: " + emp);

        emp.setPhone("222-222-2222"); // <-- not saving phone
        caretaker.revert(emp);
        System.out.println("After Revert of Alice without saving phone: " + emp);

        caretaker.revert(emp);
        System.out.println("After Revert of Alice to Initial State: " + emp);
    }
}
/**
 * Output:
 * -------
 * Initial State of Alice: Employee{name='Alice', phone='123-456-7890'}
 * After Phone Update of Alice: Employee{name='Alice', phone='888-999-1111'}
 * After Revert of Alice without saving phone: Employee{name='Alice', phone='888-999-1111'}
 * After Revert of Alice to Initial State: Employee{name='Alice', phone='123-456-7890'}
 */