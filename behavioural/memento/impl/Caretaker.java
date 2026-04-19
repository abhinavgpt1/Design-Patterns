import java.util.Stack;

public class Caretaker {
    private Stack<PersonMemento> mementoStack = new Stack<>();
    
    public void save(Person person) {
        mementoStack.push(person.getMemento());
    }
    
    public void revert(Person person) {
        if (!mementoStack.isEmpty()) {
            person.setFromMemento(mementoStack.pop());
        }
    }
}
