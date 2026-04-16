public class Director implements BaseHandler {
    private BaseHandler next = null;

    @Override
    public void setNext(BaseHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("director level thing")) {
            System.out.println("Director is handling the request: " + request);
            // returning from here to not let CEO process the request.
            // Going by the general rule that only one handler handles -> not an obligation, depends on design.
            return;
        }

        if (next != null) {
            System.out.println("Director cannot handle the request, passing it on...");
            next.handleRequest(request);
        }
    }
}