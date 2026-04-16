public class Manager implements BaseHandler {
    private BaseHandler next = null;

    @Override
    public void setNext(BaseHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(String request) {
        if (request.equals("manager level thing")) {
            System.out.println("Manager is handling the request: " + request);
            // returning from here to not let Director or CEO process the request.
            // Going by the general rule that only one handler handles -> not an obligation, depends on design.
            return;
        }

        if (next != null) {
            System.out.println("Manager cannot handle the request, passing it on...");
            next.handleRequest(request);
        }
    }
}