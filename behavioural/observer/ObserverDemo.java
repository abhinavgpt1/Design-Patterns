import java.util.Observable;
import java.util.Observer;

class TwitterAccount extends Observable {
    // Observerable stores Observers in a Vector internally

    public void newTweet(String tweet) {
        // Observable aka TwitterAccount marks itself as changed, and ready to send
        // notifications.
        // if not set, then no observer is notified and we simply return (internally).
        setChanged();

        // Notify all observers with the tweet
        notifyObservers(tweet);
    }
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable twitterAccount, Object tweetByTwitterAccount) {
        // System.out.println(twitterAccount); // TwitterAccount@7e9e5f8a
        String tweet = (String) tweetByTwitterAccount;
        System.out.println(name + " received tweet: " + tweet);
    }
}

public class ObserverDemo {
    public static void main(String[] args) {
        TwitterAccount twitterStream = new TwitterAccount();

        Subscriber alice = new Subscriber("Alice");
        Subscriber boris = new Subscriber("Boris");
        Subscriber callum = new Subscriber("Callum");

        twitterStream.addObserver(alice);
        twitterStream.addObserver(boris);
        twitterStream.addObserver(callum);

        twitterStream.newTweet("Hello Everyone!");
        System.out.println();
        twitterStream.newTweet("Get ready for some exciting news!");

        // PTR: it is synchronous in nature, hence the output is in order Callum->Boris->Alice.
        // Pub-sub is asynchronous.

        // java.util.Observer:
        // - setChanged() — marks the subject as changed.
        // - notifyObservers() — loops through observers and calls their update()
    }
}

/**
 * Output:
 * -------
 * Note: ObserverDemo.java uses or overrides a deprecated API.
 * Note: Recompile with -Xlint:deprecation for details.
 * Callum received tweet: Hello Everyone!
 * Boris received tweet: Hello Everyone!
 * Alice received tweet: Hello Everyone!
 * 
 * Callum received tweet: Get ready for some exciting news!
 * Boris received tweet: Get ready for some exciting news!
 * Alice received tweet: Get ready for some exciting news!
 */