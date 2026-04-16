import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerDemo {
    private static final Logger log = Logger.getLogger(LoggerDemo.class.getName());

    public static void main(String[] args) {
        // Problem statement: 
        // log contains a chain of handlers which go upto FINEST level.
        // The log is configured to log only FINE, and FINER logs. Although it can be
        // configured to log till the FINEST level.
        log.setLevel(Level.FINER);

        // Handler is more permissive (can handle up to FINEST)
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);
        log.addHandler(handler);

        log.fine("This is a fine level log message.");
        log.finer("This is a finer level log message.");
        log.finest("This is a finest level log message.");
        // log level is till FINER, so finest log won't print. 
        // If the chain of handlers were till FINE, then the request would be handled partially i.e. it would execute till FINE, and not beyond that.
        // => log = max. limit, handlers = capability.
    }
}

/**
 * Output:
 * -------
 * Apr 17, 2026 12:04:36 AM LoggerDemo main
 * FINE: This is a fine level log message.
 * Apr 17, 2026 12:04:36 AM LoggerDemo main
 * FINER: This is a finer level log message.
 */