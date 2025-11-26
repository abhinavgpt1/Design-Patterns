interface BaseHandler {
    void setNext(BaseHandler next);
    void handleRequest(String request);
}