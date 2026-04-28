interface FanState {
    // FanState can be a abstract class with handleRequest() throwing
    // UnsupportedOperationException() stating "Request shouldn't come here"
    void handleRequest(Fan fan);
}