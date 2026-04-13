import java.util.Observable;
import java.util.Observer;

public class ObserverExample {
    public static void main(String[] args) {
        TwitterStream twitterStream = new TwitterStream();

        Client client1 = new Client("Client1");
        Client client2 = new Client("Client2");
        Client client3 = new Client("Client3");
        Client client4 = new Client("Client4");
        Client client5 = new Client("Client5");


        twitterStream.addObserver(client1);
        twitterStream.addObserver(client2);
        twitterStream.addObserver(client3);
        twitterStream.addObserver(client4);
        twitterStream.addObserver(client5);

        twitterStream.newTweet("Hello World!");
        twitterStream.newTweet("Observer Pattern in action!");

        // PTR: it is synchronous in nature, hence the output is in order 5->1. Pub-sub is asynchronous.
        // functions like setChanged(), notifyObservers() and update() are easy - just look into their defintions.
        // - setChanged() — marks the subject as changed.
        // - notifyObservers() — loops through observers and calls their update() method.

        /**
         * Shortcomings / Problems (as per Bryan Hansen - the example in Main doesn't solve this & I feel it's unnecessary. Check his code in .zip)
         * ------------------------
         * Observers know nothing about the concrete subject they observe.  <- getting last message from stream after registering subject with observer is okay.
         *  They don’t know what changed — only that something changed.
         *  Must manually fetch subject state if needed.
         * Initialization feels hardwired:                                  <- observers themselves doing changes in subject isn't right solution, but his example is real tho. Observers can be Client as well for MessageStream.
         *  Code wiring in main is somewhat rigid.                          <- his point of doing this that observer should have control when to register with subject. It should be not like subject sending messages mindlessly after registering on its own.
         *  Requires manual registration and setup.
         * Overall: too much disconnectedness + some tight wiring.
         */
    }
}

class TwitterStream extends Observable {
    // Observerable stores Observers in a list

    public void newTweet(String tweet) {
        setChanged(); // Observable aka TwitterStream marks itself as changed
        notifyObservers(tweet); // Notify all observers with the tweet
    }
}

class Client implements Observer {
    private String name;
    public Client(String name) {
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        String tweet = (String) arg;
        System.out.println(name + " received tweet: " + tweet);
    }
}
/**
 * Output:
 * -------
 * Client5 received tweet: Hello World!
 * Client4 received tweet: Hello World!
 * Client3 received tweet: Hello World!
 * Client2 received tweet: Hello World!
 * Client1 received tweet: Hello World!
 * Client5 received tweet: Observer Pattern in action!
 * Client4 received tweet: Observer Pattern in action!
 * Client3 received tweet: Observer Pattern in action!
 * Client2 received tweet: Observer Pattern in action!
 * Client1 received tweet: Observer Pattern in action!
 */