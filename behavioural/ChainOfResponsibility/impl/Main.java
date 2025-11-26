// must read theory - https://refactoring.guru/design-patterns/chain-of-responsibility
// must read example - https://refactoring.guru/design-patterns/chain-of-responsibility/java/example
public class Main {
    public static void main(String[] args) {
        BaseHandler manager = new Manager();
        BaseHandler director = new Director();
        BaseHandler ceo = new CEO();

        manager.setNext(director);
        director.setNext(ceo);

        manager.handleRequest("direct");
        manager.handleRequest("manage");
        manager.handleRequest("decide");
        manager.handleRequest("unknown"); // no ones handles this, thus passes through all
    }
}
