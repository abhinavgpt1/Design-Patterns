import java.util.Stack;

public class Caretaker {
    private Stack<EmployeeMemento> mementoStack = new Stack<>();
    
    public void save(Employee emp) {
        mementoStack.push(emp.getMemento());
    }
    
    public void revert(Employee employee) {
        if (!mementoStack.isEmpty()) {
            employee.setFromMemento(mementoStack.pop());
        }
    }
}
