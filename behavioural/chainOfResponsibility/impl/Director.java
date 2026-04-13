public class Director implements BaseHandler{
    private BaseHandler next = null;

    @Override
    public void setNext(BaseHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("direct")) {
            System.out.println("Director handling request.");
        } 
        if (next != null) {
            next.handleRequest(request);
        }
    }
}
