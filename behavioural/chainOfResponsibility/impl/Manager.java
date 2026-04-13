public class Manager implements BaseHandler {
    private BaseHandler next = null;

    @Override
    public void setNext(BaseHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("manage")) {
            System.out.println("Manager handling request.");
        } 
        if (next != null) {
            next.handleRequest(request);
        }
    }    
}
