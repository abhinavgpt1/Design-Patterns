// The invoker being unaware of the receiver is intentional design, not a flaw.
public class Switch_Invoker {
    public void execute(Command command) {
        command.execute();
    }
}