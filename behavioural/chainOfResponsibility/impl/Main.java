// ref: https://refactoring.guru/design-patterns/chain-of-responsibility
public class Main {
    public static void main(String[] args) {
        BaseHandler manager = new Manager();
        BaseHandler director = new Director();
        BaseHandler ceo = new CEO();
        manager.setNext(director);
        director.setNext(ceo);

        manager.handleRequest("director level thing");
        System.out.println();
        manager.handleRequest("manager level thing");
        System.out.println();
        manager.handleRequest("just decide asap");
        System.out.println();
        manager.handleRequest("unknown request"); // passes all handlers without being handled = Unhandled.
    }
}

/**
 * Output:
 * -------
 * Manager cannot handle the request, passing it on...
 * Director is handling the request: director level thing
 * 
 * Manager is handling the request: manager level thing
 * 
 * Manager cannot handle the request, passing it on...
 * Director cannot handle the request, passing it on...
 * CEO is handling the request: just decide asap
 * 
 * Manager cannot handle the request, passing it on...
 * Director cannot handle the request, passing it on...
 */