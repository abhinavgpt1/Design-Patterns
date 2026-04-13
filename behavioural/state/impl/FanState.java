// State (Interface)
public interface FanState {
    void handleRequest(Fan fan); // can make this a concrete method in abstract class stating that "Request shouldn't come here" or throw exception if you don't want exception when anyone misses implementing this method.
}