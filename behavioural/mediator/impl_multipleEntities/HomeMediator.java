import java.util.HashMap;
import java.util.Map;

public class HomeMediator implements IMediator {
    private Map<Action, ICommand> commandMap;

    public HomeMediator() {
        commandMap = new HashMap<Action, ICommand>();
    }

    @Override
    public void register(Action action, ICommand command) {
        commandMap.put(action, command);
    }

    @Override
    public void notify(Action action) {
        commandMap.get(action).execute();
    }
}
